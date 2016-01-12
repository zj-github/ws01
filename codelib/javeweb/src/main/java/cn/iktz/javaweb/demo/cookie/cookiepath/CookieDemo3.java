package cn.iktz.javaweb.demo.cookie.cookiepath;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7081026380910930989L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		
		Cookie c = new Cookie("dddd","eeee");
		c.setPath(request.getContextPath());//意味着当前应用下的任何资源都能得到该Cookie
		c.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(c);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
