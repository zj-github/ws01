package cn.innohub.crawler.test2.t4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.innohub.crawler.crawl.fetch.FetchThreadContext;
import cn.innohub.crawler.crawl.firstlevel.seeds.extract.FisrtLevelSeedThreadContext;
import cn.innohub.crawler.crawl.parse.ParseThreadContext;
import cn.innohub.crawler.crawl.storage.StorageTask;
import cn.innohub.crawler.crawl.storage.StoragerCommonImpl;
import cn.innohub.crawler.crawl.storage.StorateThreadContext;
import cn.innohub.crawler.crawl.storage.strategy.JDBCStorateStrategy;

/**
 * @ClassName: FetchThreadContext
 * @Description: 启动线程池
 * @author zhangjie
 * @date 2015年12月31日 下午4:15:06
 */
public class StorateTest{

	public static void main(String[] args) {
//		Map<String, String> m = Context.getInstance().getColumnMapping();
//		m.put("project_name","projectName");
//		m.put("project_logo","projectLogo");
//		m.put("city","city");
//		m.put("contact_name","contactName");
//		m.put("description","description");
//		m.put("introduction","introduction");
//		
//		CCFAProjectInfo c1 = new CCFAProjectInfo();
//		c1.setProjectName("重庆石锅鱼北京天通苑分店");
//
//		CCFAProjectInfo c2 = new CCFAProjectInfo();
//		c2.setProjectName("北京华悦幼儿教育乐园");
//		c2.setProjectLogo("http://huayue.com/pic1.jpg");
//		
//		try {
//			QueueManager.beanDatumPool.put(c1);
//			QueueManager.beanDatumPool.put(c2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Class.forName("cn.innohub.crawler.conf.ConfigurationLoader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new FisrtLevelSeedThreadContext().fetch();
		new FetchThreadContext().fetch();
		new ParseThreadContext().parse();
		new StorateThreadContext().storate();;

		long d = 0;
		while(true){
			try {
				Thread.sleep(10000);
				d+=10000;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(d+"^^^^^^^^^^^^^^^^^^^");
		}
	}

	public void parse() {
		StorageTask parseTask = new StorageTask(new StoragerCommonImpl(new JDBCStorateStrategy()));
		int parseThreadNum = 1; // 抓取线程数
		ExecutorService parseThreadPool = Executors.newFixedThreadPool(parseThreadNum);

		for (int i = 0; i < parseThreadNum; i++) {
			parseThreadPool.submit(parseTask);
		}
	}
}
