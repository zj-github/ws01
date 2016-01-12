package cn.innohub.web.demo.a05_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//Servlet的生命周期
public class ServletDemo07LifeCycle extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6823596593607018722L;

	public ServletDemo07LifeCycle(){
		System.out.println("调用了构造方法");
	}
	public void destroy() {
		System.out.println("干掉了");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化了");
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service");
		response.getWriter().write("heihei");
	}

}
