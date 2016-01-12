package javase.a27_xml.jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
//������:
//�쳣��
//�����������������鷳
//�������ɵ����ߴ���
public class JaxpDomUtils {
	public static Document getDocument() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/exam.xml");
		return document;
	}
	public static void write2xml(Document document) throws Exception{
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/exam.xml"));
	}
}
