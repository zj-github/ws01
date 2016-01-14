package cn.innohub.web.project.a05_mvcframe;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.innohub.web.project.a05_mvcframe.utils.PackageScaner;
/**
 * @ClassName: DispatcherFilter 
 * @Description: 拦截所有的请求，截取路径， 
 * @author zhangjie
 * @date 2016年1月12日 下午4:27:21 
 *
 */
@WebListener
public class AnnotationScanListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			new PackageScaner().scan("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
