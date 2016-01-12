package c04_crawler.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class helloHtmlUnit5{
    public static void main(String[] args) throws Exception{
        //����webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //htmlunit ��css��javascript��֧�ֲ��ã�������ر�֮
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        HtmlPage page = (HtmlPage)webClient.getPage("http://www.baidu.com/");
        //��ȡ����������ύ��������
        HtmlInput input = (HtmlInput)page.getHtmlElementById("kw");
        System.out.println(input.toString());
        input.setValueAttribute("����");
        System.out.println(input.toString());
        //��ȡ������ť�����
        HtmlInput btn = (HtmlInput)page.getHtmlElementById("su");
        HtmlPage page2 = btn.click();
        //�����ҳ����ı�
        System.out.println(page2.asText());
    }
}