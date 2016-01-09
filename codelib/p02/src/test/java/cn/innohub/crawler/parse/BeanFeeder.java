package cn.innohub.crawler.parse;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.beans.HtmlText;
import cn.innohub.crawler.common.utils.JsoupUtil;

public class BeanFeeder {
	

	public static void main(String[] args) {
		try {
			new BeanFeeder().init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<CrawlDatum> init() throws Exception {
		String url = "http://www.innohub.net/sciencemarket/article/index.html";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Element body = doc.body();
		Elements es = body.select("a[href]");
		List<CrawlDatum> list = new ArrayList<>();
		for (Iterator<Element> it = es.iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			String href = e.attr("href");
			if (JsoupUtil.checkHref(href)) {
				URL baseUrl = new URL(url);
				URL u = new URL(baseUrl, href);
				URL u01 = new URL(u.getProtocol(), u.getHost(), u.getFile());
				String u02 = u01.toURI().toString();
				// System.out.println("add url "+u02);
				if (!list.contains(u02) &&checkReg(u02)) {
					/**
					 * 抓取 html内容 创建一个HtmlText对象，放入集合
					 */
//					System.out.println("jsoup fetch url " + u02);
					doc = Jsoup.connect(u02).get();
					String html = doc.html();
					HtmlText e2 = new HtmlText(u02, html);
//					System.out.println("html content queue add " + url);
					list.add(e2);
				}
			}
		}
		return list;
	}

//	http://www.innohub.net/sciencemarket/article/detail.html?id=396
	private Pattern p = Pattern.compile("^(http|https)://www.innohub.net/sciencemarket/article/detail.html\\?id=.*");
	public boolean checkReg(String url) {
		return p.matcher(url).matches();
	}
}