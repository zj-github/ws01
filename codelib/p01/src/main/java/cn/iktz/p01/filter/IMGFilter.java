package cn.iktz.p01.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import cn.iktz.p01.beans.Constant;
import cn.iktz.utils.Base64Util;
import cn.iktz.utils.JedisPoolUtil;

/**
 * Servlet Filter implementation class IMGFilter
 */
public class IMGFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public IMGFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String p = req.getServletPath();
		System.out.println(p);
		String id = p.split("/")[2];

		String imgbytearr = JedisPoolUtil.get(Constant.IMG_KEY + id, "imgbytearr").get(0);

		ServletOutputStream outputStream = response.getOutputStream();
		IOUtils.write(Base64Util.decode(imgbytearr), outputStream);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
