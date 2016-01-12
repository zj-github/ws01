package cn.iktz.javaweb.demo.session.appshop;

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
//1����ʾ��Ʒ����ϸ���ݣ�����Ʒ���빺�ﳵ
//2���ṩ������ҳ������
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1����ʾ��Ʒ����ϸ���ݣ�����Ʒ���빺�ﳵ
		String bookId = request.getParameter("id");
		Book book = BookDB.findBookById(bookId);
		
		HttpSession session = request.getSession();
		List<Book> cart = (List<Book>)session.getAttribute("cart");
		if(cart==null){
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
		//�϶��й��ﳵ
		cart.add(book);
		
		out.write(book.getName()+"�ѷ������Ĺ��ﳵ��");
		
		//2���ṩ������ҳ������
		String url2 = request.getContextPath()+"/servlet/IndexServlet";
		url2 = response.encodeURL(url2);
		out.write("<a href='"+url2+"'>��������</a>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
