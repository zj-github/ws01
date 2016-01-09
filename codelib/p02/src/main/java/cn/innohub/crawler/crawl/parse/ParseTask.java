package cn.innohub.crawler.crawl.parse;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.beans.BeanDatum;
import cn.innohub.crawler.core.QueueManager;
import cn.innohub.crawler.core.ThreadLockController;

/**
 * @ClassName: FetchTask
 * @Description: 实现run方法，启动while循环，抓取网页
 * @author zhangjie
 * @date 2015年12月31日 下午3:42:45
 *
 */
public class ParseTask implements Runnable {
	private Logger logger = Logger.getLogger(ParseTask.class);
	public static ThreadLocal<Long> tl = new ThreadLocal<>();
	private Parser parser;

	public ParseTask(Parser parser) {
		this.parser = parser;
	}

	@Override
	public void run() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " start at " + currentTimeMillis);

		tl.set(currentTimeMillis);
		while (true) {
			
			try {
				logger.debug("parse method will be executed");
				BeanDatum bean = parser.parse();
				QueueManager.add(bean);
				ThreadLockController.getInstance().signalStoreThread();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
