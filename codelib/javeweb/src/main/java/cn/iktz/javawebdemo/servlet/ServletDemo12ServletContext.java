package cn.iktz.javawebdemo.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//配置全局参数及参数的获取
public class ServletDemo12ServletContext extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8487705439709411092L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * 获取ServletContext
		 * 1、getServletContext方法
		 * 2、通过ServletConfig
		 * 
		 * ServletContext设置值
		 */
		ServletContext context = getServletContext();
		String encoding = context.getInitParameter("encoding");
		System.out.println(encoding);
		context.setAttribute("key01", "value01");
		
		ServletConfig config = getServletConfig();
		context = config.getServletContext();
		String value = (String)context.getAttribute("key01");
		System.out.println("ServletDemo1:"+value);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
