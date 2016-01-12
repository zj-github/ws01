package cn.innohub.web.project.a01_login_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -7950605823944647054L;
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//1、验证码对不对
		String pcode = request.getParameter("code");//表单用户输入的验证码
		String scode = (String)session.getAttribute("code");//放到session中的那个码
		if(!pcode.equals(scode)){
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.html");
			out.write("验证码有误，2秒后会自动转向登录页面");
			return;
		}
		//2、验证用户名和密码
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!user.getUsername().equals("wzthing")||!user.getPassword().equals("sorry")){
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.html");
			out.write("错误的用户名或密码，2秒后会自动转向登录页面");
			return;
		}
		//3、登录成功
		
		session.setAttribute("user", user);
		
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
		out.write("登录成功！2秒后转向主页");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
