package cn.innohub.web.demo.a01_request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//获取请求正文内容
public class RequestDemo4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8843453746594679518L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletInputStream in = request.getInputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=in.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
