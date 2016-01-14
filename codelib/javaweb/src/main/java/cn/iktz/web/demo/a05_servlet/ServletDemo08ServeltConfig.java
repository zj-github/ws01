package cn.iktz.web.demo.a05_servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//ServletConfig读取针对当前Servlet配置的参数信息
public class ServletDemo08ServeltConfig extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1688192654278299964L;
	private ServletConfig config;
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//用config对象
//		String value = config.getInitParameter("encoding");
		
		Enumeration<?> enu = config.getInitParameterNames();//得到所有参数的name
		while(enu.hasMoreElements()){
			String pName = (String)enu.nextElement();
			System.out.println(pName+"="+config.getInitParameter(pName));
		}
		
		
		//res.getWriter().write("shit"+value);
	}

	

}
