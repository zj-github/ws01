package cn.iktz.javaweb.demo.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�ļ�����ͷ
public class ServletDemo05DownLoad extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795820809603780266L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ҵ��ļ�������������
		String filePath = getServletContext().getRealPath("/111.jpg");
		InputStream in = new FileInputStream(filePath);
		
		//֪ͨ������������صķ�ʽ��
		response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
		response.setHeader("Content-Type", "application/octet-stream");//ͼƬֻ��Content-Disposition����һ�λ����أ������Ϳ���ֱ�Ӵ��ˡ�
															//��������
		
		//���������
		OutputStream out = response.getOutputStream();
		//��ʼ���
		int len = -1;//��ǰ���������ݵĳ���
		byte b[] = new byte[1024];//����
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
