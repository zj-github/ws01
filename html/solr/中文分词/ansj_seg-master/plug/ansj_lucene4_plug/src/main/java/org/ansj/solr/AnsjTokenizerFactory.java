package org.ansj.solr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.ansj.lucene.util.AnsjTokenizer;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource.AttributeFactory;

public class AnsjTokenizerFactory extends TokenizerFactory {
	boolean pstemming;
	boolean isQuery;
	private String stopwordsDir;
	public Set<String> filter;

	public AnsjTokenizerFactory(Map<String, String> args) {
		super(args);
		assureMatchVersion();
		isQuery = getBoolean(args, "isQuery", true);
		pstemming = getBoolean(args, "pstemming", false);
		stopwordsDir = get(args, "words");
		addStopwords(stopwordsDir);
	}

	// add stopwords list to filter
	private void addStopwords(String dir) {
		if (dir == null) {
			System.out.println("no stopwords dir");
			return;
		}
		// read stoplist
		System.out.println("stopwords: " + dir);
		filter = new HashSet<String>();
		File file = new File(dir);
		InputStreamReader reader = null;
		BufferedReader br = null;
		try {
			reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			br = new BufferedReader(reader);
			String word = br.readLine();
			while (word != null) {
				filter.add(word);
				word = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No stopword file found");
		} catch (IOException e) {
			System.out.println("stopword file io exception");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Tokenizer create(AttributeFactory factory, Reader input) {
		if (isQuery == true) {
			// query
			return new AnsjTokenizer(new ToAnalysis(new BufferedReader(input)), input, filter, pstemming);
		} else {
			// index
			return new AnsjTokenizer(new IndexAnalysis(new BufferedReader(input)), input, filter, pstemming);
		}
	}
}