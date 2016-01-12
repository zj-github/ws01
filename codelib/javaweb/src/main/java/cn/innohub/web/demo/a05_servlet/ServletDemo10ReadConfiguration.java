package cn.innohub.web.demo.a05_servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//读取各种配置信息文件
public class ServletDemo10ReadConfiguration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 335345187488065643L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test32(request, response);
	}
	// 用类加载器读取.333
	public void test32(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassLoader cl = ServletDemo10ReadConfiguration.class.getClassLoader();// 只能加在classpath下
		URL url = cl.getResource("com/itheima/servlet/cfg.properties");
		String realPath = url.getPath();//文件的真实路径
		System.out.println(realPath);
		Properties props = new Properties();
		props.load(new FileInputStream(realPath));
		System.out.println(props.get("hello"));
	}
	// 用类加载器读取.3333
	public void test31(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassLoader cl = ServletDemo10ReadConfiguration.class.getClassLoader();// 只能加在classpath下
		InputStream in = cl.getResourceAsStream("com/itheima/servlet/cfg.properties");
		Properties props = new Properties();
		props.load(in);
		System.out.println(props.get("hello"));
	}

	// 用类加载器读取.22222
	public void test30(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassLoader cl = ServletDemo10ReadConfiguration.class.getClassLoader();// 只能加在classpath下
		InputStream in = cl.getResourceAsStream("cfg.properties");
		Properties props = new Properties();
		props.load(in);
		System.out.println(props.get("hello"));
	}

	// 如果读的是properties文件.3333
	public void test21(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResourceBundle rb = ResourceBundle.getBundle("com.itheima.servlet.cfg");
		System.out.println(rb.getString("hello"));
	}

	// 如果读的是properties文件.2222
	public void test20(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResourceBundle rb = ResourceBundle.getBundle("cfg");
		System.out.println(rb.getString("hello"));
	}

	// 读取hello=3333的那个配置文件（src\包下的那个）
	public void test12(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String path = sc
				.getRealPath("/WEB-INF/classes/com/itheima/servlet/cfg.properties");
		InputStream inStream = new FileInputStream(path);

		Properties props = new Properties();
		props.load(inStream);
		System.out.println(props.get("hello"));
	}

	// 读取hello=222的那个配置文件（src下的那个）
	public void test11(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/WEB-INF/classes/cfg.properties");
		InputStream inStream = new FileInputStream(path);

		Properties props = new Properties();
		props.load(inStream);
		System.out.println(props.get("hello"));
	}

	// 读取hello=111的那个配置文件（webroot下的那个）
	public void test10(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/cfg.properties");
		InputStream inStream = new FileInputStream(path);

		Properties props = new Properties();
		props.load(inStream);
		System.out.println(props.get("hello"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
