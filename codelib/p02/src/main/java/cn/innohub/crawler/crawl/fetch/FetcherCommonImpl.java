package cn.innohub.crawler.crawl.fetch;

import java.util.concurrent.ArrayBlockingQueue;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.beans.DetailPageSeed;
import cn.innohub.crawler.core.QueueManager;
import cn.innohub.crawler.core.ThreadLockController;
import cn.innohub.crawler.crawl.fetch.strategy.FetchStrategy;

/**
 * @ClassName: FetcherCommomImpl
 * @Description: 策略执行者
 * @author zhangjie
 * @date 2015年12月31日 下午3:59:04
 *
 */
public class FetcherCommonImpl implements Fetcher {
	private Logger logger = Logger.getLogger(FetcherCommonImpl.class);
	private FetchStrategy strategy;

	private ThreadLockController lock = ThreadLockController.getInstance();

//	public void setLock(ThreadController lock) {
//		this.lock = lock;
//	}

	public FetcherCommonImpl(FetchStrategy strategy) {
		this.strategy = strategy;
	}

	private ArrayBlockingQueue<DetailPageSeed> urlList = QueueManager.detailPageQueue;
	// private Lock lock = new ReentrantLock();
	// private Condition fetchCondition = lock.newCondition();

	/**
	 * 从队列中获取一个url抓取，若队列中没有url，则该线程等待
	 * 
	 * @return
	 */
	public CrawlDatum fetch() {
		CrawlDatum crawlDatum = null;
		DetailPageSeed firstUrl = null;
		// lock.lock();
		try {
			logger.debug("detail page queue size >> " + urlList.size());
			while (urlList.size() == 0) {// 没有种子以后线程等待
				logger.debug("no seed in detail page queue," + Thread.currentThread().getName()
						+ " will await until queue feed");
				long currentTimeMillis = System.currentTimeMillis();
				Long long1 = FetchTask.tl.get();
				logger.debug("thread has run " + (currentTimeMillis - long1) + " m ");
				// fetchCondition.await();
				this.await();
			}
			firstUrl = urlList.remove();

			Object newInstance = Class.forName(firstUrl.getResponseClazz()).newInstance();
			crawlDatum = (CrawlDatum) newInstance;

		} catch (Exception e) {
			e.printStackTrace();
		}
		// finally {
		// lock.unlock();
		// }
		// ********* 抓取网页 **********
		strategy.fetchStrategy(firstUrl.getUrl(), crawlDatum);
		return crawlDatum;
	}

	public void await() {
		lock.fetchThreadAwait();
	}
	
	public void signal(){
		lock.signalFetchThread();
	}
}