package c04_crawler.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class helloHtmlUnit2 {
	public static void main(String[] args) throws Exception {
		String str;
		// 使用FireFox读取网页
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_31);
		// htmlunit 对css和javascript的支持不好，所以请关闭之
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		HtmlPage page = webClient.getPage("http://www.baidu.com/");
		str = page.getTitleText();
		System.out.println(str);
		// 关闭webclient
		webClient.closeAllWindows();
	}
}