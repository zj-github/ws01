package cn.iktz.web.demo.a04_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7950605823944647054L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//得到HttpSession对象
		HttpSession session = request.getSession();
		String value = request.getParameter("username");
		if(value==null){
			out.write("访问地址是：http://192.168.1.100:8080/day06_02_session/servlet/SessionDemo1?username=your username");
			return;
		}
		System.out.println(session.getId());
		session.setAttribute("p", value);
		out.write("放了<a href='"+request.getContextPath()+"/servlet/SessionDemo2'>看看</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
