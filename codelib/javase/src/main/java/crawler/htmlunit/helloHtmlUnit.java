package crawler.htmlunit;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlBody;
import java.util.List;

public class helloHtmlUnit{
    public static void main(String[] args) throws Exception{
        String str;
        //����һ��webclient
        WebClient webClient = new WebClient();
        //htmlunit ��css��javascript��֧�ֲ��ã�������ر�֮
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        //��ȡҳ��
        HtmlPage page = webClient.getPage("http://www.baidu.com/");
        //��ȡҳ���TITLE
        str = page.getTitleText();
        System.out.println(str);
        //��ȡҳ���XML����
        str = page.asXml();
        System.out.println(str);
        //��ȡҳ����ı�
        str = page.asText();
        System.out.println(str);
        //�ر�webclient
        webClient.closeAllWindows();
    }
}