package cn.iktz.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//֪ͨ�ͻ��˲�Ҫ��������
public class ServletDemo06Headers extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -778195347585869272L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Expires", "-1");//���ƻ���ʱ��
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.getWriter().write("I love UUUU!");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
