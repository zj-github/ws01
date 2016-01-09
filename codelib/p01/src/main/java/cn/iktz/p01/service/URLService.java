package cn.iktz.p01.service;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cn.iktz.utils.JedisPoolUtil;

public class URLService {

	
	public static void acceptUrl(String url) throws Exception{
		//1、html title
		//2、h2 
		//3、content
//		String s = "http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&mid=403209303&idx=1&sn=f4fea7390b3a2c31e693189aee44af59&scene=0#wechat_redirect";
//		String s = "http://mp.weixin.qq.com/s?__biz=MzAwNjMxMTA5Mw==&mid=401497949&idx=1&sn=e446ea237172978120351eb1b83e06b4&scene=0#wechat_redirect";
		Document doc = Jsoup.connect(url).get();
		String title = doc.title();
		String h2 = doc.select("h2.rich_media_title").text();
		String content = doc.select("div.rich_media_content").html();

		String biz  = url.substring(url.indexOf("__biz=")+6, url.indexOf("&mid="));
		String sn = url.substring(url.indexOf("&sn=")+4,url.indexOf("&scene="));
		
		Map<String,String> m = new HashMap<>();
		m.put("h2",h2);
		m.put("biz",biz);
		m.put("sn",sn);
		m.put("title",title);
		m.put("content",content);
		JedisPoolUtil.set("wx_art:", m);
	}
	public static void acceptUrl(String ...urls){
		for (String url : urls) {
			try {
				acceptUrl(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
