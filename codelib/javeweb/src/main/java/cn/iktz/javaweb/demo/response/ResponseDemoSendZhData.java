package cn.iktz.javaweb.demo.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���ַ��������������
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
		String data = "��ð���";
		response.setContentType("text/html;charset=UTF-8");//֪ͨ�ͻ��˲��ĸ����Tomcat��ʵ���л�����ַ���������
		PrintWriter out = response.getWriter();//��Ĳ��Ǳ���Ĭ�ϵģ�����ISO-8859-1��Servlet�淶Ҫ��ģ�
		out.write(data);
	}
	public void test2(HttpServletResponse response) throws IOException {
		String data = "��ð�";
		response.setHeader("Content-Type", "text/html;charset=UTF-8");//֪ͨ�ͻ��˲��ĸ����Tomcat��ʵ���л�����ַ���������
		PrintWriter out = response.getWriter();//��Ĳ��Ǳ���Ĭ�ϵģ�����ISO-8859-1��Servlet�淶Ҫ��ģ�
		out.write(data);
	}

	public void test1(HttpServletResponse response) throws IOException {
		String data = "TM��";
		response.setCharacterEncoding("UTF-8");//����Ĭ�ϵı���
		//֪ͨ��������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();//��Ĳ��Ǳ���Ĭ�ϵģ�����ISO-8859-1��Servlet�淶Ҫ��ģ�
		out.write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
