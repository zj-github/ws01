package a27_xml.dom4j;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JUtil {
	public static Document getDocument() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/book.xml");
		return document;

	}
	public static void write2xml(Document document) throws Exception{
		FileOutputStream out = new FileOutputStream("src/book.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
//		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(out, format);
		writer.write(document);
		writer.close();
	}
}
