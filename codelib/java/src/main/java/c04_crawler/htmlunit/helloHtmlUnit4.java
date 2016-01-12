package c04_crawler.htmlunit;

import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class helloHtmlUnit4{
    public static void main(String[] args) throws Exception{
        //����webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //htmlunit ��css��javascript��֧�ֲ��ã�������ر�֮
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        HtmlPage page = (HtmlPage)webClient.getPage("http://www.baidu.com/");
        //��������div
        List<?> hbList = page.getByXPath("//div");
        HtmlDivision hb = (HtmlDivision)hbList.get(0);
        System.out.println(hb.toString());
        //���Ҳ���ȡ�ض�input
        List<?> inputList = page.getByXPath("//input[@id='su']");
        HtmlInput input = (HtmlInput)inputList.get(0);
        System.out.println(input.toString());
        //�ر�webclient
        webClient.closeAllWindows();
    }
}