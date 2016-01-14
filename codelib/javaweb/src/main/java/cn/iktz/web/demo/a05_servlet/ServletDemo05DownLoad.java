package cn.iktz.web.demo.a05_servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//文件下载头
public class ServletDemo05DownLoad extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795820809603780266L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//找到文件，构建输入流
		String filePath = getServletContext().getRealPath("/111.jpg");
		InputStream in = new FileInputStream(filePath);
		
		//通知浏览器请用下载的方式搞
		response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
		response.setHeader("Content-Type", "application/octet-stream");//图片只有Content-Disposition，第一次还下载，后来就可能直接打开了。
															//铁定下载
		
		//构建输出流
		OutputStream out = response.getOutputStream();
		//开始输出
		int len = -1;//当前读到的数据的长度
		byte b[] = new byte[1024];//缓存
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
