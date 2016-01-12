package c04_crawler.httpunit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;


public class httpUnitTestSample {

	/**
	 * ҳ�����ݲ���
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	@Test
	public  void testGetHtmlContent() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("ֱ�ӻ�ȡ��ҳ���ݣ�");
		// ����һ��WebConversationʵ��
		WebConversation wc = new WebConversation();
		HttpUnitOptions.setScriptingEnabled(true);
		// ��ָ����URL�������󣬻�ȡ��Ӧ
		WebResponse wr = wc.getResponse("http://news.sina.com.cn/c/2016-01-12/doc-ifxnkkuv4419839.shtml");
		// ��getText������ȡ��Ӧ��ȫ������
		IOUtils.write(wr.getText(), new FileWriter(new File("E:\\T2.HTML")));
		System.out.println(wr.getText());
	}

	/**
	 * ��get������ȡҳ������
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testGetMethod() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("��������������ݣ�Ȼ���ȡ��ҳ���ݣ�");
		// ����һ��WebConversationʵ��
		WebConversation wc = new WebConversation();
		// ��ָ����URL��������
		WebRequest req = new GetMethodWebRequest(
				"http://localhost:8080/test.html");
		// ��������ϲ���
		req.setParameter("query", "���Ȼ�̼");
		// ��ȡ��Ӧ����
		WebResponse resp = wc.getResponse(req);

		// ��getText������ȡ��Ӧ��ȫ������
		// ��System.out.println����ȡ�����ݴ�ӡ�ڿ���̨��
		System.out.println(resp.getText());

	}

	/**
	 * ��post������ȡҳ������
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testPostMethod() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("ʹ��Post��ʽ��������������ݣ�Ȼ���ȡ��ҳ���ݣ�");
		// ����һ��WebConversationʵ��
		WebConversation wc = new WebConversation();
		// ��ָ����URL��������
		WebRequest req = new PostMethodWebRequest(
				"http://localhost:8080/test.html");
		// ��������ϲ���
		req.setParameter("user_name", "test");
		req.setParameter("password", "111111");
		// ��ȡ��Ӧ����
		WebResponse resp = wc.getResponse(req);

		// ��getText������ȡ��Ӧ��ȫ������
		// ��System.out.println����ȡ�����ݴ�ӡ�ڿ���̨��
		System.out.println(resp.getText());
	}

	
	/**
	 * ��ȡҳ�����Ӳ�ģ����
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testClickLink() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("��ȡҳ��������ָ��ҳ������ݣ�");
		// ����һ��WebConversationʵ��
		WebConversation wc = new WebConversation();
		// ��ȡ��Ӧ����
		WebResponse resp = wc.getResponse("http://www.265.com/");
		// ���ҳ�����Ӷ���
		WebLink link = resp.getLinkWith("�ٶ�");
		// ģ���û������¼�
		link.click();
		// ��õ�ǰ����Ӧ����
		WebResponse nextLink = wc.getCurrentPage();

		// ��getText������ȡ��Ӧ��ȫ������
		// ��System.out.println����ȡ�����ݴ�ӡ�ڿ���̨��
		System.out.println(nextLink.getText());

	}

	/**
	 * ��ȡҳ�����ݵ�table����
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testTableContent() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("��ȡҳ���б������ݣ�");
		// ����һ��WebConversationʵ��
		WebConversation wc = new WebConversation();
		// ��ȡ��Ӧ����
		WebResponse resp = wc
				.getResponse("http://www.w3school.com.cn/tiy/loadtext.asp?f=html_table_test");

		System.out.println(resp.getText());
		// ��ö�Ӧ�ı�����
		WebTable webTable = resp.getTables()[0];
		// ������������ݴ��ݸ��ַ�������
		String[][] datas = webTable.asText();
		// ѭ����ʾ�������
		int i = 0, j = 0;
		int m = datas[0].length;
		int n = datas.length;
		while (i < n) {
			j = 0;
			while (j < m) {
				System.out.println("����е�" + (i + 1) + "�е�" + (j + 1) + "�е������ǣ�"
						+ datas[i][j]);
				++j;
			}
			++i;
		}
	}

	/**
	 * ��ȡҳ��ı��ؼ�����
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testHtmlContentForm() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("��ȡҳ���б������ݣ�");
		// ����һ��WebConversationʵ��
		WebConversation wc = new WebConversation();
		// ��ȡ��Ӧ����
		WebResponse resp = wc.getResponse("http://www.baidu.com");

		System.out.println(resp.getText());
		// ��ö�Ӧ�ı�����
		WebForm webForm = resp.getForms()[0];
		// ��ñ������пؼ�������
		String[] pNames = webForm.getParameterNames();
		int i = 0;
		int m = pNames.length;
		// ѭ����ʾ�������пؼ�������
		while (i < m) {
			System.out.println("��" + (i + 1) + "���ؼ���������" + pNames[i] + "�������������"
					+ (webForm.getParameterValues(pNames[i])));
			++i;
		}
	}

	public static void main(String[] args) throws MalformedURLException,
			IOException, SAXException {
		// testGetHtmlContent();
		// testGetMethod();
		// testPostMethod();
		// testClickLink();
		// testTableContent();
		testHtmlContentForm();
	}

}
