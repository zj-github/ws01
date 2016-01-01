package cn.iktz.javawebdemo.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * //httpservlet不能覆盖service方法
 * @author oatt1
 *
 */
public class ServletDemo09GenericServlet extends GenericServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9041309899457059263L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化了");
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("haha");
	}

}
