package cn.innohub.web.project.a01_login_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//模拟主页
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = -7950605823944647054L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//判断用户是否登录，没有登录提供登录链接；登陆了，欢迎XXX，提供注销链接
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			out.write("<a href='"+request.getContextPath()+"/login.html'>登录</a>");
		}else{
			out.write("欢迎您："+user.getNickname()+"<a href='"+request.getContextPath()+"/servlet/LogoutServlet'>注销</a>");
		}
		
		out.write("<hr/>这是主页");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
