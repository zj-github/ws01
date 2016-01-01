package a27_xml.sax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

//读取配置文件，把信息都封装到JavaBean中.逻辑有点复杂，稍微有点难度
public class SaxDemo3 {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();//读取器
		List<Book> books = new ArrayList<Book>();
		reader.setContentHandler(new MyContentHandler1(books));//注册内容处理器
		reader.parse("src/book.xml");
		
		for(Book b:books)
			System.out.println(b);
	}

}
class MyContentHandler1 extends DefaultHandler{
	private List<Book> books;
	public MyContentHandler1(List<Book> books) {//注入
		this.books = books;
	}
	
	private Book book;//当前的书对象
	private String currentTagName;//当前读到的元素的名称
	
	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		if("书".equals(qName)){
			book = new Book();
		}
		currentTagName = qName;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if("书名".equals(currentTagName)){
			book.setName(new String(ch,start,length));
		}
		if("作者".equals(currentTagName)){
			book.setAuthor(new String(ch,start,length));
		}
		if("售价".equals(currentTagName)){
			book.setPrice(new String(ch,start,length));
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		currentTagName = null;
		if("书".equals(qName)){
			books.add(book);
		}
	}
}
