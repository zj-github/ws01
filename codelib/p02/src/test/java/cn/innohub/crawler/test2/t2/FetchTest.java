package cn.innohub.crawler.test2.t2;

import cn.innohub.crawler.crawl.fetch.FetchThreadContext;
import cn.innohub.crawler.crawl.firstlevel.seeds.extract.FisrtLevelSeedThreadContext;

/**
 * @ClassName: FetchThreadContext
 * @Description: 启动线程池
 * @author zhangjie
 * @date 2015年12月31日 下午4:15:06
 */
public class FetchTest {

	public static void main(String[] args) {

		try {
			Class.forName("cn.innohub.crawler.conf.ConfigurationLoader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new FisrtLevelSeedThreadContext().fetch();
		new FetchThreadContext().fetch();
	}

}