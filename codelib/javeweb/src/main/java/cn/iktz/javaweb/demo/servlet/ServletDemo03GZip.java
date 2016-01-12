package cn.iktz.javaweb.demo.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//GZIPѹ��
public class ServletDemo03GZip extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6671754652367947240L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		byte b[] = data.getBytes();
		System.out.println("ѹ��ǰ��С��"+b.length);
		
		//GZIPѹ��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//���л�����ڴ��ֽ������
		GZIPOutputStream gout = new GZIPOutputStream(baos);
		gout.write(b);//����ѹ������
		gout.close();
		
		b = baos.toByteArray();//ȡ�������е��ֽ����ݣ�ѹ�������ˣ�
		System.out.println("ѹ�����С��"+b.length);
		
		//֪ͨ��������ݵ�ѹ����ʽ�ʹ�С
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", b.length+"");
		
		response.getOutputStream().write(b);//��������
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
