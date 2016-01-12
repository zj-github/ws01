package javase.a27_xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
//SAX读取的原理
public class SaxDemo1 {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();//读取器
		
		reader.setContentHandler(new MyContentHandler());//注册内容处理器
		
		reader.parse("src/book.xml");
	}

}
class MyContentHandler implements ContentHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("读到了文档的开始");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("读到了文档的结束");
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		System.out.println("读到了元素的开始"+qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("读到了元素的结束"+qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("读到了文本内容："+new String(ch,start,length));
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
