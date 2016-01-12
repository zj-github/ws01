package c04_crawler.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class helloHtmlUnit2 {
	public static void main(String[] args) throws Exception {
		String str;
		// ʹ��FireFox��ȡ��ҳ
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_31);
		// htmlunit ��css��javascript��֧�ֲ��ã�������ر�֮
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		HtmlPage page = webClient.getPage("http://www.baidu.com/");
		str = page.getTitleText();
		System.out.println(str);
		// �ر�webclient
		webClient.closeAllWindows();
	}
}