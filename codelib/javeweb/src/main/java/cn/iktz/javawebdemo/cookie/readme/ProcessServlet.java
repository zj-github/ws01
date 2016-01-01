package cn.iktz.javawebdemo.cookie.readme;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1、验证用户名和密码是否正确
//2、根据用户是否记住用户名，选择是否给客户端写Cookie
public class ProcessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2291193036059344735L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1、验证用户名和密码是否正确
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals(new StringBuffer(password).reverse().toString())){
			//说明验证通过
			out.write("登录成功！");
			//2、根据用户是否记住用户名，选择是否给客户端写Cookie
			String remember = request.getParameter("remember");
			Cookie c = new Cookie("loginInfo",username);
			c.setPath(request.getContextPath());
			if(null==remember){
				//不记住
				c.setMaxAge(0);
			}else{
				//记住用户名
				c.setMaxAge(Integer.MAX_VALUE);
			}
			response.addCookie(c);
		}else{
			out.write("错误的用户名或密码");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
