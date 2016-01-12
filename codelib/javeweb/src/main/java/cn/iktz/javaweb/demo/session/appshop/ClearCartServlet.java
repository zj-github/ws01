package cn.iktz.javaweb.demo.session.appshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClearCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
//		session.invalidate();//立刻干掉内存中的那个HttpSession对象
		session.removeAttribute("cart");
		
		//2、提供返回主页的链接
		String url2 = request.getContextPath()+"/servlet/IndexServlet";
		url2 = response.encodeURL(url2);
		out.write("清除成功<a href='"+url2+"'>继续购物</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
