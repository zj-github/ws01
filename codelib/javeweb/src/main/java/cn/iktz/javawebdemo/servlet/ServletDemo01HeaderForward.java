package cn.iktz.javawebdemo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//���󣺽�Ǯ
public class ServletDemo01HeaderForward extends HttpServlet {
	private static final long serialVersionUID = -486550458789064475L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(302);//��ͻ���������Ӧ��
		response.setHeader("Location", "/day03_00_responseHeader/servlet/ServletDemo2");//��ͻ���������Ӧ��Ϣͷ
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
