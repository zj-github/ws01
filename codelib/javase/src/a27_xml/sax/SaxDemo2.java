package a27_xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
//读取第2本书的作者：董泽
public class SaxDemo2 {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();//读取器
		
		reader.setContentHandler(new DefaultHandler(){
			//1：第2本书的 2:是作者的主体内容
			private int index = 0;//记录当前读到的作者元素的索引
			private boolean isAuthor = false;//读到的是否是作者
			@Override
			public void startElement(String uri, String localName,
					String qName, Attributes attributes) throws SAXException {
				if("作者".equals(qName)){
					isAuthor = true;
				}
			}
			@Override
			public void characters(char[] ch, int start, int length)
					throws SAXException {
				if(index==1&&isAuthor)
					System.out.println(new String(ch,start,length));
			}
			@Override
			public void endElement(String uri, String localName, String qName)
					throws SAXException {
				if("作者".equals(qName)){
					index++;
				}
				isAuthor = false;
			}

		});//注册内容处理器
		
		reader.parse("src/book.xml");

	}

}
