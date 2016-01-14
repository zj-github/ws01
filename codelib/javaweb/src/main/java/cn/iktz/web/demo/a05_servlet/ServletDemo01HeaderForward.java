package cn.iktz.web.demo.a05_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//董泽：借钱
public class ServletDemo01HeaderForward extends HttpServlet {
	private static final long serialVersionUID = -486550458789064475L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(302);//向客户端设置响应码
		response.setHeader("Location", "/day03_00_responseHeader/servlet/ServletDemo2");//向客户端设置响应消息头
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
