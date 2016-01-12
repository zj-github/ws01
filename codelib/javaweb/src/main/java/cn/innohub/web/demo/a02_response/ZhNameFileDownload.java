package cn.innohub.web.demo.a02_response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//中文文件的文件下载
public class ZhNameFileDownload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4751673061276516347L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = getServletContext().getRealPath("/霉女.jpg");//  c:\sdf\sdfs\2.jpg
		
		//截取文件名
		String fileName = path.substring(path.lastIndexOf("\\")+1);
		
		
		InputStream in = new FileInputStream(path);
		OutputStream out = response.getOutputStream();
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));//IE浏览器是可以的
																						//FireFox:Base64
		response.setHeader("Content-Type", "application/octet-stream");
		
		int len = -1;
		byte b[] = new byte[1024];
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		in.close();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
