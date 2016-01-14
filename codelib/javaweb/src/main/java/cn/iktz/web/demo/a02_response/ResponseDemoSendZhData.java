package cn.iktz.web.demo.a02_response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//以字符流输出中文数据
public class ResponseDemoSendZhData extends HttpServlet {

	/**
	 * 
	 */
	public static final long serialVersionUID = 8795216075612034L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test4(response);
	}
	public void test4(HttpServletResponse response) throws IOException {
		int i=97;
		response.getOutputStream().write((i+"").getBytes());
	}
	public void test3(HttpServletResponse response) throws IOException {
		String data = "你好啊啊";
		response.setContentType("text/html;charset=UTF-8");//通知客户端查哪个码表（Tomcat的实现中还会改字符流查的码表）
		PrintWriter out = response.getWriter();//查的不是本地默认的，而是ISO-8859-1（Servlet规范要求的）
		out.write(data);
	}
	public void test2(HttpServletResponse response) throws IOException {
		String data = "你好啊";
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//通知客户端查哪个码表（Tomcat的实现中还会改字符流查的码表）
		PrintWriter out = response.getWriter();//查的不是本地默认的，而是ISO-8859-1（Servlet规范要求的）
		out.write(data);
	}

	public void test1(HttpServletResponse response) throws IOException {
		String data = "TM的";
		response.setCharacterEncoding("UTF-8");//覆盖默认的编码
		//通知浏览器码表
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();//查的不是本地默认的，而是ISO-8859-1（Servlet规范要求的）
		out.write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
