package cn.iktz.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//°üº¬£ºÄ¿±ê
public class ServletDemo13IncludePage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6904313533037319792L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(" fengjie ");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
