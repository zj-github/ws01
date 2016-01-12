package cn.iktz.javaweb.demo.session.appshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1����ʾ���е���Ʒ���ṩ��������
//2���ṩ�鿴���ﳵ������
public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.getSession();
		
		//1����ʾ���е���Ʒ���ṩ��������
		out.write("��վ�����º���:<br/>");
		Map<String, Book> books = BookDB.findAllBooks();
		for(Map.Entry<String, Book> me:books.entrySet()){
			String url1 = request.getContextPath()+"/servlet/BuyServlet?id="+me.getKey();
			url1 = response.encodeURL(url1);
			out.write(me.getValue().getName()+"<a href='"+url1+"'>����</a><br/>");
		}
		//2���ṩ�鿴���ﳵ������
		String url2 = request.getContextPath()+"/servlet/ShowCartServlet";
		url2 = response.encodeURL(url2);
		out.write("<a href='"+url2+"'>�鿴���ﳵ</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
