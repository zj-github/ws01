package cn.iktz.web.demo.a01_request;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
//获取常用表单中的数据
public class RequestDemo5 extends HttpServlet {

	/**
	 * 
	 */
	public static final long serialVersionUID = -3027917479942481870L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test5(request,response);
		
	}
	public void test5(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("GBK");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("name");
			out.write(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//intpu type=radio/checkbox等的一些特点
	public void test4(HttpServletRequest request,HttpServletResponse response) {
		try {
			//String married = request.getParameter("married");
				//checkbox如果用户没有选中，就相当于没有改输入域；如果选中了，它的值是on或者yes。
			//System.out.println(married);
			String hobbies[] = request.getParameterValues("hobbies");
			System.out.println(hobbies);
			if(hobbies!=null)
				System.out.println(Arrays.asList(hobbies));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//解决get请求方式的中文参数乱码:统一用ISO-8859-1:前期form请使用POST方式
	public void test3(HttpServletRequest request,HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("name");
			byte b[] = name.getBytes("ISO-8859-1");
			
			String value = new String(b,"UTF-8");
			out.write(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public void test2(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");//只针对请求的正文（POST）
			Student s = new Student();
			//如果遇到类型转换不了：自定义类型转换器。（用户所有的输入都是String类型；基本类型的会自动转换）
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(s, request.getParameterMap());
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public void test1(HttpServletRequest request) {
		try {
			Student s = new Student();
			
			//如果遇到类型转换不了：自定义类型转换器。（用户所有的输入都是String类型；基本类型的会自动转换）
			
			ConvertUtils.register(new Converter() {
				//String--->Date
				//Date--->String
				public Object convert(@SuppressWarnings("rawtypes") Class type, Object value) {
					try {
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						if(type==Date.class){
							//String--->Date
							String s = (String)value;
							return df.parse(s);
						}else if(type==String.class){
							//Date--->String
							Date data = (Date)value;
							return df.format(data);
						}else{
							return null;
						}
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
				}
			}, Date.class);
			BeanUtils.populate(s, request.getParameterMap());
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
