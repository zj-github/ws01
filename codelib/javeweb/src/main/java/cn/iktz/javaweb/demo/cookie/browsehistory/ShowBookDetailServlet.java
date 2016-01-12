package cn.iktz.javaweb.demo.cookie.browsehistory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1、显示书籍的详细信息
//2、把最近访问的书籍的id以cookie的形式写给浏览器
public class ShowBookDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7386760723527146149L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1、显示书籍的详细信息
		String bookId = request.getParameter("id");
		Book book = BookDB.findBookById(bookId);
		out.write(book.toString());
		//2、把最近访问的书籍的id以cookie的形式写给浏览器
		//bookHistory
		/*
		 * Cookie cs[] = request.getCookies();
		 * 
		 * 原有id						当前访问的书的id                   应写回的id
		 * cs==null            			 1							1
		 * cs!=null但没有bookHistory		 1							1
		 * bookHistory=1				 2							2-1
		 * bookHistory=2-1               1                          1-2
		 * bookHistory=2-1               3                          3-2-1
		 * bookHistory=3-2-1			 4							4-3-2
		 * bookHistory=3-2-1			 2                          2-3-1
		 */
		String ids = makeIds(request,bookId);
		Cookie c = new Cookie("bookHistory", ids);
		c.setMaxAge(Integer.MAX_VALUE);
		c.setPath(request.getContextPath());
		response.addCookie(c);
	}
	//组织ID
	/**
	 * 
	 * @param request
	 * @param bookId 当前访问的书的id
	 * @return 组织好的id
	 */
	private String makeIds(HttpServletRequest request, String bookId) {
//		* 原有id						当前访问的书的id                   应写回的id
//		 * cs==null            			 1							1
		Cookie cs[] = request.getCookies();
		if(cs==null)
			return bookId;
//		 * cs!=null但没有bookHistory		 1							1
		Cookie bookHistoryCookie = null;
		for(Cookie c:cs){
			if("bookHistory".equals(c.getName())){
				bookHistoryCookie = c;
				break;
			}
		}
		if(bookHistoryCookie==null)
			return bookId;
//		 * bookHistory=1				 2							2-1
//		 * bookHistory=2-1               1                          1-2
//		 * bookHistory=2-1               3                          3-2-1
		
		String value = bookHistoryCookie.getValue();
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(value.split("\\-")));
		if(list.size()<3){
			if(list.contains(bookId))
				list.remove(bookId);
		}else{
		
//		 * bookHistory=3-2-1			 4							4-3-2
//		 * bookHistory=3-2-1			 2                          2-3-1
			if(list.contains(bookId)){
				list.remove(bookId);
			}else{
				list.removeLast();
			}
		}
		list.addFirst(bookId);
		
		StringBuffer sb = new StringBuffer();// 4 3 2--->4-3-2
		for(int i=0;i<list.size();i++){
			if(i>0)
				sb.append("-");
			sb.append(list.get(i));
		}
		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
