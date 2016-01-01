package a27_xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
//��ȡ��2��������ߣ�����
public class SaxDemo2 {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();//��ȡ��
		
		reader.setContentHandler(new DefaultHandler(){
			//1����2����� 2:�����ߵ���������
			private int index = 0;//��¼��ǰ����������Ԫ�ص�����
			private boolean isAuthor = false;//�������Ƿ�������
			@Override
			public void startElement(String uri, String localName,
					String qName, Attributes attributes) throws SAXException {
				if("����".equals(qName)){
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
				if("����".equals(qName)){
					index++;
				}
				isAuthor = false;
			}

		});//ע�����ݴ�����
		
		reader.parse("src/book.xml");

	}

}
