package cn.iktz.javawebdemo.session.applogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//ģ����ҳ
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = -7950605823944647054L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//�ж��û��Ƿ��¼��û�е�¼�ṩ��¼���ӣ���½�ˣ���ӭXXX���ṩע������
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			out.write("<a href='"+request.getContextPath()+"/login.html'>��¼</a>");
		}else{
			out.write("��ӭ����"+user.getNickname()+"<a href='"+request.getContextPath()+"/servlet/LogoutServlet'>ע��</a>");
		}
		
		out.write("<hr/>������ҳ");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
