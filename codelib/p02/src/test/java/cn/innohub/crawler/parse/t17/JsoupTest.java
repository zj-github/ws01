package cn.innohub.crawler.parse.t17;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.utils.JsoupUtil;

public class JsoupTest {

	@Test
	public void test(){
		String d = "<p class=\"attention-p\"><i>项目地点：</i>辽宁省大连</p>";
		Document doc = Jsoup.parse(d);
		Elements select = doc.select("p.attention-p$1");
		System.out.println(select.text());
		
		
	}
	/**
	 * 
	 * @Description: 获取人人投的详情页链接
	 * @author zhangjie
	 * @date 2016年1月7日 下午1:29:18
	 *
	 */
	@Test
	public void getOutLink() {
		try {
			String url = "http://www.renrentou.com/";
			Document doc = null;
//			doc = Jsoup.parse(FileUtils.readFileToString(new File("e:\\rrt.html")));
			doc = Jsoup.parse(HttpUtils.getCotnent(url));
//			doc = Jsoup.connect(url).get();
			Element body = doc.body();
			Elements es = body.select("a[href]");
			List<CrawlDatum> list = new ArrayList<>();
			for (Iterator<Element> it = es.iterator(); it.hasNext();) {
				Element e = (Element) it.next();
				String href = e.attr("href");
//				System.out.println(href);
				if (JsoupUtil.checkHref(href)) {
					URL baseUrl = new URL(url);
					URL u = new URL(baseUrl, href);
					URL u01 = new URL(u.getProtocol(), u.getHost(), u.getFile());
					String u02 = u01.toURI().toString();
					if (!list.contains(u02) && u02.matches("http://www.renrentou.com/project/detail/project_id/.*")) {
						System.out.println("* outlinks " + u02);
						// System.out.println("jsoup fetch url " + u02);
						// doc = Jsoup.connect(u02).get();
						// String html = doc.html();
						// HtmlText e2 = new HtmlText(u02, html);
						// // System.out.println("html content queue add " +
						// url);
						// list.add(e2);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
