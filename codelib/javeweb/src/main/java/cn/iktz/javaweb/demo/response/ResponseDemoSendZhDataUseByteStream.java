package cn.iktz.javaweb.demo.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�ֽ��������������
public class ResponseDemoSendZhDataUseByteStream extends HttpServlet {

	/**
	 * 
	 */
	public static final long serialVersionUID = 7034956579192278008L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test4(response);		
	}
	public void test4(HttpServletResponse response) throws IOException {
		String data = "��֪���Ű�֥�͹�ϣ";
		response.setContentType("text/html;charset=UTF-8");
		response.getOutputStream().write(data.getBytes("UTF-8"));
	}
	public void test3(HttpServletResponse response) throws IOException {
		String data = "��֪���Ű�֥�Ͱ���";
		//֪ͨ�ͻ��˽��뷽ʽ�����Ǹ����
		ServletOutputStream out = response.getOutputStream();
		out.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes());
		out.write(data.getBytes("UTF-8"));
	}
	public void test2(HttpServletResponse response) throws IOException {
		String data = "��֪���Ű�֥111";
		
		//֪ͨ�ͻ��˽��뷽ʽ�����Ǹ����
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		ServletOutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}
	public void test1(HttpServletResponse response) throws IOException {
		String data = "��֪��������";
		ServletOutputStream out = response.getOutputStream();
		out.write(data.getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
