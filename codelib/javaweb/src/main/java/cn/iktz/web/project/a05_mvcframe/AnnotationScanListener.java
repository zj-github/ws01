package cn.iktz.web.project.a05_mvcframe;

import java.net.URISyntaxException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.iktz.web.project.a05_mvcframe.utils.PackageScaner;

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
		// 读取配置文件，封装对象
		String xml = "cn/innohub/web/project/a05_mvcframe/mvc.xml";
		String path = null;
		try {
			path = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + xml;
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		MVCContext context = XmlUtil.fromXML(path, MVCContext.class);
		System.out.println(context.getScanPackage());
		try {
			new PackageScaner().scan(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
