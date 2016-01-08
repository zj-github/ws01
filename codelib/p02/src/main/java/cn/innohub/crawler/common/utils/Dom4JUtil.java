package cn.innohub.crawler.common.utils;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class Dom4JUtil {
	public static Document getDocument(String xmlFilePath) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlFilePath);
		return document;
	}
	public static Document getDocument(InputStream is) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(is);
		return document;
	}
}
