package cn.iktz.javaweb.demo.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//作为主页:控制它的缓存时间
public class ResponseDemoExpires extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2456314073493113724L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		response.setDateHeader("Expires", System.currentTimeMillis()+1*60*60*1000);
		
		PrintWriter out = response.getWriter();
		out.write("我是主页");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
