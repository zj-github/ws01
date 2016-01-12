package cn.innohub.web.demo.a05_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//包含：源  （源包含目标）
public class ServletDemo5 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3043148700913922092L;

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
