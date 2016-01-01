package cn.iktz.javawebdemo.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//Servlet����������
public class ServletDemo07LifeCycle extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6823596593607018722L;

	public ServletDemo07LifeCycle(){
		System.out.println("�����˹��췽��");
	}
	public void destroy() {
		System.out.println("�ɵ���");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("��ʼ����");
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service");
		response.getWriter().write("heihei");
	}

}
