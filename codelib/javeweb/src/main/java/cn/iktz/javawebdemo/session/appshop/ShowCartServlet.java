package cn.iktz.javawebdemo.session.appshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//1、显示购物车中的商品
//2、提供返回主页的链接
public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1、显示购物车中的商品
		HttpSession session = request.getSession(false);
		if(null==session){
			out.write("您还未曾购物,session都没有创建");
			return;
		}
		
		List<Book> books = (List<Book>)session.getAttribute("cart");
		if(books==null||books.size()<1){
			out.write("您还未曾购物,有购物车，但没有东东");
			return;
		}
		
		out.write("您购买的烂书如下：<br/>");
		for(Book b:books)
			out.write(b.getName()+"<br/>");
		String url1 = request.getContextPath()+"/servlet/ClearCartServlet";
		url1 = response.encodeURL(url1);
		out.write("<a href='"+url1+"'>清空购物车</a>");
		
		//2、提供返回主页的链接
		String url2 = request.getContextPath()+"/servlet/IndexServlet";
		url2 = response.encodeURL(url2);
		out.write("<a href='"+url2+"'>继续购物</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
