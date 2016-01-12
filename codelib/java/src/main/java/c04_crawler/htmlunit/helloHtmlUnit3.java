package c04_crawler.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class helloHtmlUnit3{
    public static void main(String[] args) throws Exception{
        //创建webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //htmlunit 对css和javascript的支持不好，所以请关闭之
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        HtmlPage page = (HtmlPage)webClient.getPage("http://www.baidu.com/");
        //通过id获得"百度一下"按钮
        HtmlInput btn = (HtmlInput)page.getHtmlElementById("su");
        System.out.println(btn.getDefaultValue());
        //关闭webclient
        webClient.closeAllWindows();
    }
}