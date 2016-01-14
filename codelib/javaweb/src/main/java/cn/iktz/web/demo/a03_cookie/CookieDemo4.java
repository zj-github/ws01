package cn.iktz.web.demo.a03_cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6990752703305726169L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cs[] = request.getCookies();
		for(int i=0;cs!=null&&i<cs.length;i++){
			Cookie c = cs[i];
			if("dddd".equals(c.getName())){
				System.out.println("value:"+c.getValue());
				System.out.println("path:"+c.getPath());
				break;
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
