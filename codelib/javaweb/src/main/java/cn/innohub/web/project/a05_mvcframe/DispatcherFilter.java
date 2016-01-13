package cn.innohub.web.project.a05_mvcframe;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * @ClassName: DispatcherFilter 
 * @Description: 拦截所有的请求，截取路径， 
 * @author zhangjie
 * @date 2016年1月12日 下午4:27:21 
 *
 */
public class DispatcherFilter implements Filter {
    public DispatcherFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
