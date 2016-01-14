package cn.iktz.web.demo.a05_servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//定时刷新
public class ServletDemo04Refresh extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6949169752519358696L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Refresh", 2+"");
		response.getWriter().write(new Random().nextInt()+"");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
