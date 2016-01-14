package cn.iktz.web.project.a02_history;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearHistoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9080292291449224179L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie c = new Cookie("bookHistory", "");
		c.setMaxAge(0);
		c.setPath(request.getContextPath());
		response.addCookie(c);
		response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/servlet/ShowAllBooksServlet");
		out.write("清理成功！2秒后返回主页");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
