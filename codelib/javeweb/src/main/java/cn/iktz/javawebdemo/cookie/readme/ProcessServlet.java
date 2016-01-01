package cn.iktz.javawebdemo.cookie.readme;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1����֤�û����������Ƿ���ȷ
//2�������û��Ƿ��ס�û�����ѡ���Ƿ���ͻ���дCookie
public class ProcessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2291193036059344735L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1����֤�û����������Ƿ���ȷ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals(new StringBuffer(password).reverse().toString())){
			//˵����֤ͨ��
			out.write("��¼�ɹ���");
			//2�������û��Ƿ��ס�û�����ѡ���Ƿ���ͻ���дCookie
			String remember = request.getParameter("remember");
			Cookie c = new Cookie("loginInfo",username);
			c.setPath(request.getContextPath());
			if(null==remember){
				//����ס
				c.setMaxAge(0);
			}else{
				//��ס�û���
				c.setMaxAge(Integer.MAX_VALUE);
			}
			response.addCookie(c);
		}else{
			out.write("������û���������");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
