package c04_crawler.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class JsoupSelectTest {

	public static void main(String[] args) {
		
//		String html = "<div><p>aaaaa<i>ccc</i></p><p>bbbbb</p></div>";
		String html = "<p>I am a <i>strong</i> man. I am a <i>strong</i> man.</p>";
		Document doc = Jsoup.parse(html);
		
		Elements select = doc.select("p");
		Element element = select.get(0);
		Node node= (Node)element;
		
		element.childNode(0);
		
		
		
		
	}
	
}
