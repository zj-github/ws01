package cn.iktz.p01.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.iktz.p01.beans.ART;
import cn.iktz.p01.service.ARTService;

/**
 * Servlet Filter implementation class URLFilter
 */
public class URLFilter implements Filter {

    /**
     * Default constructor. 
     */
    public URLFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/**
		 * 拦截详情页连接，获取sn
		 */
		HttpServletRequest req =(HttpServletRequest ) request;
		String p = req.getServletPath();
		System.out.println(p);
		String sn = p.split("/")[2];
		req.setAttribute("sn", sn);
		//获取文章信息
		//跳转到详情页面
		ART art = new ARTService().getART(sn);
		req.setAttribute("art", art);
		req.getRequestDispatcher("/detail.jsp").forward(request, response);;
//		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
