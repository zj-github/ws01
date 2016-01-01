package cn.iktz.javawebdemo.session.appshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//1����ʾ���ﳵ�е���Ʒ
//2���ṩ������ҳ������
public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1����ʾ���ﳵ�е���Ʒ
		HttpSession session = request.getSession(false);
		if(null==session){
			out.write("����δ������,session��û�д���");
			return;
		}
		
		List<Book> books = (List<Book>)session.getAttribute("cart");
		if(books==null||books.size()<1){
			out.write("����δ������,�й��ﳵ����û�ж���");
			return;
		}
		
		out.write("��������������£�<br/>");
		for(Book b:books)
			out.write(b.getName()+"<br/>");
		String url1 = request.getContextPath()+"/servlet/ClearCartServlet";
		url1 = response.encodeURL(url1);
		out.write("<a href='"+url1+"'>��չ��ﳵ</a>");
		
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
