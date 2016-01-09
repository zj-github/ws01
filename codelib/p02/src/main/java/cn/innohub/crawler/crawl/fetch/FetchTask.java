package cn.innohub.crawler.crawl.fetch;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.core.QueueManager;
import cn.innohub.crawler.core.ThreadLockController;

/**
 * @ClassName: FetchTask
 * @Description: 实现run方法，启动while循环，抓取网页
 * @author zhangjie
 * @date 2015年12月31日 下午3:42:45
 *
 */
public class FetchTask implements Runnable{
	private boolean stop = false;
	private Logger logger = Logger.getLogger(FetchTask.class);
	public static ThreadLocal<Long> tl = new ThreadLocal<>();
	private Fetcher fetcher;

	public FetchTask(Fetcher fetcher) {
		this.fetcher = fetcher;
	}

	@Override
	public void run() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+" start at "+currentTimeMillis);
		
		tl.set(currentTimeMillis);
		while (!stop) {
			try {
				logger.debug("fetch method will be executed");
				CrawlDatum webPage = fetcher.fetch();
				QueueManager.crawlDatumPool.add(webPage);
				ThreadLockController.getInstance().signalParseThread();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
