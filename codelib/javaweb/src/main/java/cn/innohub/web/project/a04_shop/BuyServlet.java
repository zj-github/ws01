package cn.innohub.web.project.a04_shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//1、显示商品的详细内容；把商品放入购物车
//2、提供返回主页的链接
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1、显示商品的详细内容；把商品放入购物车
		String bookId = request.getParameter("id");
		Book book = BookDB.findBookById(bookId);
		
		HttpSession session = request.getSession();
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if(cart==null){
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
		//肯定有购物车
		cart.add(book);
		
		out.write(book.getName()+"已放入您的购物车！");
		
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
