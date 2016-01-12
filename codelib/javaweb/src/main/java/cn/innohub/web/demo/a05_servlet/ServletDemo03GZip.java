package cn.innohub.web.demo.a05_servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//GZIP压缩
public class ServletDemo03GZip extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6671754652367947240L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		byte b[] = data.getBytes();
		System.out.println("压缩前大小："+b.length);
		
		//GZIP压缩
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//带有缓存的内存字节输出流
		GZIPOutputStream gout = new GZIPOutputStream(baos);
		gout.write(b);//就是压缩数据
		gout.close();
		
		b = baos.toByteArray();//取出缓存中的字节数据（压缩过的了）
		System.out.println("压缩后大小："+b.length);
		
		//通知浏览器数据的压缩方式和大小
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", b.length+"");
		
		response.getOutputStream().write(b);//打给浏览器
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
