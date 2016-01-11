//package cn.innohub.crawler.fetch;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import cn.innohub.crawler.common.beans.DetailPageSeed;
//
//public class SeedFeeder {
//	public static void main(String[] args) {
//		try {
//			new SeedFeeder().init();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public  List<DetailPageSeed> init()  throws Exception {
//		String url = "http://www.innohub.net/sciencemarket/article/index.html";
//		Document doc = null;
//		try {
//			doc = Jsoup.connect(url).get();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		Element body = doc.body();
//		Elements es = body.select("a[href]");
//		List<DetailPageSeed> list = new ArrayList<>();
//		String	responseClazz = "cn.innohub.crawler.beans.HtmlText";
//		for (Iterator<Element> it = es.iterator(); it.hasNext();) {
//			Element e = (Element) it.next();
//			String href = e.attr("href");
//			if (checkUrl(href)) {
//				URL baseUrl = new URL(url);
//				URL u = new URL(baseUrl, href);
//				URL u01 = new URL(u.getProtocol(), u.getHost(), u.getFile());
//				String u02 = u01.toURI().toString();
//				System.out.println("add url "+u02);
//				if(!list.contains(u02)){
//					list.add(new DetailPageSeed(  u02,  responseClazz));
//				}
//			}
//		}
//		return list;
//	}
//
//	private static boolean checkUrl(String url) {
//		if (url.startsWith("javascript:") || url.startsWith("#")) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//}
