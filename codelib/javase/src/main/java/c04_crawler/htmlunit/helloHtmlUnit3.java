package c04_crawler.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class helloHtmlUnit3{
    public static void main(String[] args) throws Exception{
        //����webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //htmlunit ��css��javascript��֧�ֲ��ã�������ر�֮
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        HtmlPage page = (HtmlPage)webClient.getPage("http://www.baidu.com/");
        //ͨ��id���"�ٶ�һ��"��ť
        HtmlInput btn = (HtmlInput)page.getHtmlElementById("su");
        System.out.println(btn.getDefaultValue());
        //�ر�webclient
        webClient.closeAllWindows();
    }
}