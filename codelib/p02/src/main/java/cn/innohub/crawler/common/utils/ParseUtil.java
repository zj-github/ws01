package cn.innohub.crawler.common.utils;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class ParseUtil {
	private static Logger logger = Logger.getLogger(ParseUtil.class);

	/**
	 * 
	 * @Description: 获取外链
	 * @author zhangjie
	 * @date 2016年1月7日 下午2:42:17
	 * @param url
	 * @param htmlContent
	 * @param reg
	 * @return
	 *
	 */
	public static List<URL> getOutLinks(String url, String htmlContent, String reg) {
		logger.info("get outlinks of " + url);
		Document doc = Jsoup.parse(htmlContent);
		Element body = doc.body();
		Elements es = body.select("a[href]");
		List<URL> list = new CopyOnWriteArrayList<>();
		logger.info("get outlinks >> child reg : " + reg);

		for (Iterator<Element> it = es.iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			String href = e.attr("href");
			if (checkHref(href)) {
				URL baseUrl;
				try {
					baseUrl = new URL(url);
					URL u = new URL(baseUrl, href.trim());
					URL u01 = new URL(u.getProtocol(), u.getHost(), u.getFile());
					list.add(u01);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return list;
	}

	private static boolean checkHref(String url) {
		if (url.startsWith("javascript:") || url.startsWith("#")) {
			return false;
		} else {
			return true;
		}
	}

	@Test
	public void test() {
		String u = "http://www.innohub.net/sciencemarket/article/detail.html?id=396";
		boolean matches = u.matches("^(http|https)://www.innohub.net/sciencemarket/article/detail.html\\?id=.*");
		System.out.println(matches);
	}

}
