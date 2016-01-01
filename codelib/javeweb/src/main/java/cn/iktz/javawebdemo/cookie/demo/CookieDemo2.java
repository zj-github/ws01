package cn.iktz.javawebdemo.cookie.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//É¾³ýCookie
public class CookieDemo2 extends HttpServlet {

	private static final long serialVersionUID = 297977246940011061L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("lastAccessTime","");// /day06_00_cookieApp1/servlet
		c.setMaxAge(0);
		c.setPath(request.getContextPath());
		response.addCookie(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
