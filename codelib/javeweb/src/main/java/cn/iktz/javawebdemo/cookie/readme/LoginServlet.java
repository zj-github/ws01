package cn.iktz.javawebdemo.cookie.readme;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1���ṩ�û�ʹ�õ�form��
//2����cookie�ж�ȡ��ס���û���
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7675552979250618441L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//2����cookie�ж�ȡ��ס���û���
		String username = "";
		String checked = "";
		Cookie cs [] = request.getCookies();
		for(int i=0;cs!=null&&i<cs.length;i++){
			Cookie c = cs[i];
			if("loginInfo".equals(c.getName())){
				username = c.getValue();
				checked = "checked='checked'";
				break;
			}
		}
		
		//1���ṩ�û�ʹ�õ�form��
		out.write("<form action='"+request.getContextPath()+"/servlet/ProcessServlet' method='post'>");
		out.write("�û�����<input type='text' name='username' value='"+username+"'/><br/>");
		out.write("���룺<input type='password' name='password' value=''/><br/>");
		out.write("<input type='checkbox' name='remember' "+checked+"/>��ס�û���<br/>");
		out.write("<input type='submit' value='��¼'/></form>");
		
	}	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
