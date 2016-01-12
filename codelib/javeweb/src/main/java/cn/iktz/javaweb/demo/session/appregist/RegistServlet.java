package cn.iktz.javaweb.demo.session.appregist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

public class RegistServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4274575926583402660L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			HttpSession session = request.getSession();
			String ptoken = request.getParameter("token");
			String stoken = (String)session.getAttribute("token");
			
			if(ptoken.equals(stoken)){
				System.out.println("保存到数据库中了："+user.toString());
				session.removeAttribute("token");
			}else{
				System.out.println("您重复提交了，这样不好");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
