package c04_crawler.jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupExtractOutLinks {
	public static void main(String[] args) throws Exception {
		String url = "http://www.innohub.net/sciencemarket/article/index.html";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Element body = doc.body();
		Elements es = body.select("a[href]");
		for (Iterator<Element> it = es.iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			String href = e.attr("href");
			if (checkUrl(href)) {
				URL baseUrl = new URL("http://www.innohub.net/sciencemarket/article/index.html");
				URL u = new URL(baseUrl, href);
				URL u01 = new URL(u.getProtocol(), u.getHost(), u.getFile());
				System.out.println(e.text()+" "+u01.toURI().toString());
			}
		}
	}

	public static boolean checkUrl(String url) {
		if (url.startsWith("javascript:") || url.startsWith("#")) {
			return false;
		} else {
			return true;
		}
	}
}