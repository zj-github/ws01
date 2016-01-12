package cn.iktz.javaweb.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//请求转发：源
public class ServletDemo11RequestForward extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1350954969037460576L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/servlet/ServletDemo5");//目标路径。必须以"/"开头，该"/"就代表当前应用 /day04_01_servletContext
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
