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
	 * 页面内容测试
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	@Test
	public  void testGetHtmlContent() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("直接获取网页内容：");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		HttpUnitOptions.setScriptingEnabled(true);
		// 向指定的URL发出请求，获取响应
		WebResponse wr = wc.getResponse("http://news.sina.com.cn/c/2016-01-12/doc-ifxnkkuv4419839.shtml");
		// 用getText方法获取相应的全部内容
		IOUtils.write(wr.getText(), new FileWriter(new File("E:\\T2.HTML")));
		System.out.println(wr.getText());
	}

	/**
	 * 用get方法获取页面内容
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testGetMethod() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("向服务器发送数据，然后获取网页内容：");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		// 向指定的URL发出请求
		WebRequest req = new GetMethodWebRequest(
				"http://localhost:8080/test.html");
		// 给请求加上参数
		req.setParameter("query", "四氯化碳");
		// 获取响应对象
		WebResponse resp = wc.getResponse(req);

		// 用getText方法获取相应的全部内容
		// 用System.out.println将获取的内容打印在控制台上
		System.out.println(resp.getText());

	}

	/**
	 * 用post方法获取页面内容
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testPostMethod() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("使用Post方式向服务器发送数据，然后获取网页内容：");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		// 向指定的URL发出请求
		WebRequest req = new PostMethodWebRequest(
				"http://localhost:8080/test.html");
		// 给请求加上参数
		req.setParameter("user_name", "test");
		req.setParameter("password", "111111");
		// 获取响应对象
		WebResponse resp = wc.getResponse(req);

		// 用getText方法获取相应的全部内容
		// 用System.out.println将获取的内容打印在控制台上
		System.out.println(resp.getText());
	}

	
	/**
	 * 获取页面链接并模拟点击
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testClickLink() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("获取页面中链接指向页面的内容：");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		// 获取响应对象
		WebResponse resp = wc.getResponse("http://www.265.com/");
		// 获得页面链接对象
		WebLink link = resp.getLinkWith("百度");
		// 模拟用户单击事件
		link.click();
		// 获得当前的响应对象
		WebResponse nextLink = wc.getCurrentPage();

		// 用getText方法获取相应的全部内容
		// 用System.out.println将获取的内容打印在控制台上
		System.out.println(nextLink.getText());

	}

	/**
	 * 获取页面内容的table内容
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testTableContent() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("获取页面中表格的内容：");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		// 获取响应对象
		WebResponse resp = wc
				.getResponse("http://www.w3school.com.cn/tiy/loadtext.asp?f=html_table_test");

		System.out.println(resp.getText());
		// 获得对应的表格对象
		WebTable webTable = resp.getTables()[0];
		// 将表格对象的内容传递给字符串数组
		String[][] datas = webTable.asText();
		// 循环显示表格内容
		int i = 0, j = 0;
		int m = datas[0].length;
		int n = datas.length;
		while (i < n) {
			j = 0;
			while (j < m) {
				System.out.println("表格中第" + (i + 1) + "行第" + (j + 1) + "列的内容是："
						+ datas[i][j]);
				++j;
			}
			++i;
		}
	}

	/**
	 * 获取页面的表单控件内容
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testHtmlContentForm() throws MalformedURLException,
			IOException, SAXException {
		System.out.println("获取页面中表单的内容：");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		// 获取响应对象
		WebResponse resp = wc.getResponse("http://www.baidu.com");

		System.out.println(resp.getText());
		// 获得对应的表单对象
		WebForm webForm = resp.getForms()[0];
		// 获得表单中所有控件的名字
		String[] pNames = webForm.getParameterNames();
		int i = 0;
		int m = pNames.length;
		// 循环显示表单中所有控件的内容
		while (i < m) {
			System.out.println("第" + (i + 1) + "个控件的名字是" + pNames[i] + "，里面的内容是"
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
