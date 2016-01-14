package cn.iktz.web.demo.a02_response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//定时刷新自己
public class ResponseDemoTimingRefresh extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3824937627822585869L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random();
		
		//设置定时刷新
//		response.setHeader("Refresh", 1+"");
		response.setIntHeader("Refresh", 1);
		PrintWriter out = response.getWriter();
		out.write(r.nextInt()+"");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
