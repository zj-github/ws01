package cn.iktz.javaweb.demo.cookie.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��ʾ�û������һ�ε�¼ʱ�䣺��Cookie����ʵ��   lastAccessTime=237493287493284392(����ֵ)
public class CookieDemo1 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028005712663624157L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("���ϴη��ʵ�ʱ���ǣ�<br/>");
		//��ȡ�û�����ķ���ʱ��
		Cookie cs[] = request.getCookies();
		for(int i=0;cs!=null&&i<cs.length;i++){
			Cookie cookie = cs[i];
			if("lastAccessTime".equals(cookie.getName())){
				String value = cookie.getValue();//ʱ��
				long time = Long.parseLong(value);
				@SuppressWarnings("deprecation")
				String s = new Date(time).toLocaleString();
				out.write(s);
				break;
			}
		}
		
		//�ѵ�ǰʱ��д��ȥ
		Cookie c = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		response.addCookie(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
