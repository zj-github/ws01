package cn.iktz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.iktz.p01.service.URLService;
import cn.iktz.utils.URLUtil;
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ManagerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] urls = URLUtil.getUrlsByParams(request.getParameter("u"));
		try {
			URLService.acceptUrl(urls);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
