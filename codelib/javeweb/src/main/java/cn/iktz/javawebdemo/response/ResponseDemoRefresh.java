package cn.iktz.javawebdemo.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 指定时间转向另一站点
 * @author oatt1
 *
 */
public class ResponseDemoRefresh extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8988330495643868877L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		response.setHeader("Refresh", "2;URL=/day05_00_response/index.html");
		PrintWriter out = response.getWriter();
		out.write("恭喜你，登陆成功！2秒后自动转向主页，如果没有发生跳转，请猛点<a href='/day05_00_response/index.html'>这里</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
