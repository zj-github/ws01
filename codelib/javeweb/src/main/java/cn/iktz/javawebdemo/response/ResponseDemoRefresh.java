package cn.iktz.javawebdemo.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ָ��ʱ��ת����һվ��
 * @author oatt1
 *
 */
public class ResponseDemoRefresh extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8988330495643868877L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		response.setHeader("Refresh", "2;URL=/day05_00_response/index.html");
		PrintWriter out = response.getWriter();
		out.write("��ϲ�㣬��½�ɹ���2����Զ�ת����ҳ�����û�з�����ת�����͵�<a href='/day05_00_response/index.html'>����</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
