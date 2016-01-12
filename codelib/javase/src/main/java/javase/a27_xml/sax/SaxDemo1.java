package javase.a27_xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
//SAX��ȡ��ԭ��
public class SaxDemo1 {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();//��ȡ��
		
		reader.setContentHandler(new MyContentHandler());//ע�����ݴ�����
		
		reader.parse("src/book.xml");
	}

}
class MyContentHandler implements ContentHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("�������ĵ��Ŀ�ʼ");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("�������ĵ��Ľ���");
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		System.out.println("������Ԫ�صĿ�ʼ"+qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("������Ԫ�صĽ���"+qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("�������ı����ݣ�"+new String(ch,start,length));
	}
	
	
	
	
	@Override
	public void setDocumentLocator(Locator locator) {
		
	}

	

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		
	}

	

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		
	}
	
}
