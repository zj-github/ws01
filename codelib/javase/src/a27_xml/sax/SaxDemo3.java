package a27_xml.sax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

//��ȡ�����ļ�������Ϣ����װ��JavaBean��.�߼��е㸴�ӣ���΢�е��Ѷ�
public class SaxDemo3 {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();//��ȡ��
		List<Book> books = new ArrayList<Book>();
		reader.setContentHandler(new MyContentHandler1(books));//ע�����ݴ�����
		reader.parse("src/book.xml");
		
		for(Book b:books)
			System.out.println(b);
	}

}
class MyContentHandler1 extends DefaultHandler{
	private List<Book> books;
	public MyContentHandler1(List<Book> books) {//ע��
		this.books = books;
	}
	
	private Book book;//��ǰ�������
	private String currentTagName;//��ǰ������Ԫ�ص�����
	
	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		if("��".equals(qName)){
			book = new Book();
		}
		currentTagName = qName;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if("����".equals(currentTagName)){
			book.setName(new String(ch,start,length));
		}
		if("����".equals(currentTagName)){
			book.setAuthor(new String(ch,start,length));
		}
		if("�ۼ�".equals(currentTagName)){
			book.setPrice(new String(ch,start,length));
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		currentTagName = null;
		if("��".equals(qName)){
			books.add(book);
		}
	}
}
