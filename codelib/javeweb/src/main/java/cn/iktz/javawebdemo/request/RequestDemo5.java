package cn.iktz.javawebdemo.request;

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
//��ȡ���ñ��е�����
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
	//intpu type=radio/checkbox�ȵ�һЩ�ص�
	public void test4(HttpServletRequest request,HttpServletResponse response) {
		try {
			//String married = request.getParameter("married");
				//checkbox����û�û��ѡ�У����൱��û�и����������ѡ���ˣ�����ֵ��on����yes��
			//System.out.println(married);
			String hobbies[] = request.getParameterValues("hobbies");
			System.out.println(hobbies);
			if(hobbies!=null)
				System.out.println(Arrays.asList(hobbies));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//���get����ʽ�����Ĳ�������:ͳһ��ISO-8859-1:ǰ��form��ʹ��POST��ʽ
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
			request.setCharacterEncoding("UTF-8");//ֻ�����������ģ�POST��
			Student s = new Student();
			//�����������ת�����ˣ��Զ�������ת���������û����е����붼��String���ͣ��������͵Ļ��Զ�ת����
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
			
			//�����������ת�����ˣ��Զ�������ת���������û����е����붼��String���ͣ��������͵Ļ��Զ�ת����
			
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
