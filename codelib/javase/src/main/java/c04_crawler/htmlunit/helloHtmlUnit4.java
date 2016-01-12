package c04_crawler.htmlunit;

import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class helloHtmlUnit4{
    public static void main(String[] args) throws Exception{
        //创建webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //htmlunit 对css和javascript的支持不好，所以请关闭之
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        HtmlPage page = (HtmlPage)webClient.getPage("http://www.baidu.com/");
        //查找所有div
        List<?> hbList = page.getByXPath("//div");
        HtmlDivision hb = (HtmlDivision)hbList.get(0);
        System.out.println(hb.toString());
        //查找并获取特定input
        List<?> inputList = page.getByXPath("//input[@id='su']");
        HtmlInput input = (HtmlInput)inputList.get(0);
        System.out.println(input.toString());
        //关闭webclient
        webClient.closeAllWindows();
    }
}