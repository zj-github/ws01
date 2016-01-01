package cn.iktz.javawebdemo.session.applogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -7950605823944647054L;
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//1����֤��Բ���
		String pcode = request.getParameter("code");//���û��������֤��
		String scode = (String)session.getAttribute("code");//�ŵ�session�е��Ǹ���
		if(!pcode.equals(scode)){
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.html");
			out.write("��֤������2�����Զ�ת���¼ҳ��");
			return;
		}
		//2����֤�û���������
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!user.getUsername().equals("wzthing")||!user.getPassword().equals("sorry")){
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.html");
			out.write("������û��������룬2�����Զ�ת���¼ҳ��");
			return;
		}
		//3����¼�ɹ�
		
		session.setAttribute("user", user);
		
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
		out.write("��¼�ɹ���2���ת����ҳ");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
