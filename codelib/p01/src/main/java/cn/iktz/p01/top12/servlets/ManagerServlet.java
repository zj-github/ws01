package cn.iktz.p01.top12.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.iktz.p01.top12.service.URLService;
import cn.iktz.utils.URLUtil;
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ManagerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlStr = request.getParameter("u");
		String[] urls = URLUtil.getUrlsByParams(urlStr);
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
