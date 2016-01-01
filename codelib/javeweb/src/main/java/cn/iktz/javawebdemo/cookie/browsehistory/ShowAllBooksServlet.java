package cn.iktz.javawebdemo.cookie.browsehistory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1、显示所有的商品，提供查看详细的链接
//2、显示最近的浏览记录
public class ShowAllBooksServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8546075974834367808L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1、显示所有的商品，提供查看详细的链接
		out.write("本站有以下好书：<br/>");
		Map<String, Book> books = BookDB.findAllBooks();
		for(Map.Entry<String,Book> me:books.entrySet()){
			out.write(me.getValue().getName()+"<a target='_blank' href='"+request.getContextPath()+"/servlet/ShowBookDetailServlet?id="+me.getKey()+"'>详细</a><br/>");
		}
		
		
		//2、显示最近的浏览记录
		out.write("<hr/>最近浏览记录：<a href='"+request.getContextPath()+"/servlet/ClearHistoryServlet'>清空</a><br/>");//  bookHistory=2-1-4
		Cookie cs[] = request.getCookies();
		for(int i=0;cs!=null&&i<cs.length;i++){
			Cookie c = cs[i];
			if("bookHistory".equals(c.getName())){
				String value = c.getValue();//  2-1-4
				String ids[] = value.split("\\-");
				for(String id:ids)
					out.write(BookDB.findBookById(id).getName()+"<br/>");
				break;
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
