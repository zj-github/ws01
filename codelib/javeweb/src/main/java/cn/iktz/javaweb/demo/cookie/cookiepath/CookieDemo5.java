package cn.iktz.javaweb.demo.cookie.cookiepath;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo5 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5224866852258331276L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("dddd","");
		c.setMaxAge(0);
		c.setPath(request.getContextPath());
		response.addCookie(c);//֪ͨ�����дCookie��������Ӧ��Ϣͷ
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
