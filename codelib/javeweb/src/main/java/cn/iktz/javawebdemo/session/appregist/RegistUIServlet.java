package cn.iktz.javawebdemo.session.appregist;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistUIServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3416790338127824135L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//生成唯一的token
//		String token = System.currentTimeMillis()+""+new Random().nextLong();
		//UUID
//		String token = UUID.randomUUID().toString();//唯一的
		
		//Struts2中的
		String token = new BigInteger(165, new Random()).toString(36).toUpperCase();
		
		request.getSession().setAttribute("token", token);
		
		out.write("<form action='/day06_05_regist/servlet/RegistServlet' method='post'>");
		out.write("用户名：<input type='text' name='username'/><br/>");
		out.write("<input type='hidden' name='token' value='"+token+"'/><br/>");
		out.write("<input type='submit' value='go'/></form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
