package c04_crawler.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupTest {

	public static void main(String[] args) throws IOException {
		String s = "http://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&mid=403209303&idx=1&sn=f4fea7390b3a2c31e693189aee44af59&scene=0#wechat_redirect";
//		String s = "http://mp.weixin.qq.com/s?__biz=MzAwNjMxMTA5Mw==&mid=401497949&idx=1&sn=e446ea237172978120351eb1b83e06b4&scene=0#wechat_redirect";
		Document doc = Jsoup.connect(s).get();
		
//		Elements select = doc.select("div.rich_media_content");
//		select.re
		
		String html = doc.html();
		
		
//		String html = doc.body().html();
		System.out.println(html);
	}
}
