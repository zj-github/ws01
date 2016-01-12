package cn.iktz.javaweb.demo.cookie.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//显示用户最近的一次登录时间：用Cookie技术实现   lastAccessTime=237493287493284392(毫秒值)
public class CookieDemo1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028005712663624157L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("您上次访问的时间是：<br/>");
		//获取用户最近的访问时间
		Cookie cs[] = request.getCookies();
		for(int i=0;cs!=null&&i<cs.length;i++){
			Cookie cookie = cs[i];
			if("lastAccessTime".equals(cookie.getName())){
				String value = cookie.getValue();//时间
				long time = Long.parseLong(value);
				@SuppressWarnings("deprecation")
				String s = new Date(time).toLocaleString();
				out.write(s);
				break;
			}
		}
		
		//把当前时间写回去
		Cookie c = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		response.addCookie(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
