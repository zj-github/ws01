package cn.iktz.javaweb.demo.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemoPrintWriter extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1083169305843109289L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		OutputStream out1 = response.getOutputStream();
		PrintWriter out2 = response.getWriter();
		
//		out1.write("a".getBytes());
		out2.write("b");//不是直接打给浏览器的。PrintWriter内部有一个缓存。
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
