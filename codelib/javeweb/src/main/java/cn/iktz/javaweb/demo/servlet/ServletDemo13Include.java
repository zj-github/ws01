package cn.iktz.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//������Դ  ��Դ����Ŀ�꣩
public class ServletDemo13Include extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2186572688566660772L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("I love ");
		RequestDispatcher rd = request.getRequestDispatcher("/servlet/ServletDemo6");
		rd.include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
