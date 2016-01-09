package cn.innohub.crawler.crawl.storage;

import java.util.concurrent.ArrayBlockingQueue;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.beans.BeanDatum;
import cn.innohub.crawler.core.QueueManager;
import cn.innohub.crawler.core.ThreadLockController;
import cn.innohub.crawler.crawl.storage.strategy.StorateStrategy;

/**
 * @ClassName: ParseCommonImpl
 * @Description: 解析策略的执行者 解析html，封装成对象，加入CrawlDatum队列。
 * @author zhangjie
 * @date 2016年1月4日 上午10:39:54
 *
 */
public class StoragerCommonImpl implements Storager {
	private Logger logger = Logger.getLogger(StoragerCommonImpl.class);
	private StorateStrategy strategy;

	private ThreadLockController lock = ThreadLockController.getInstance();

	public StoragerCommonImpl(StorateStrategy strategy) {
		this.strategy = strategy;
	}

	private ArrayBlockingQueue<BeanDatum> crawlDatumList = QueueManager.beanDatumPool;

	/**
	 * 1、从队列中获取CrawlDatum，若队列为null，则等待 2、通过crawlDatum取得htmlContent，
	 * 3、调用解析策略方法，获取解析后的实体类
	 */

	@Override
	public void storage() {
		BeanDatum beanDatum = null;
		try {
			logger.debug("detail page queue size >> " + crawlDatumList.size());
			while (crawlDatumList.size() == 0) { // 队列中没有htmlContent以后，线程等待
				logger.debug("no beans in queue," + Thread.currentThread().getName()
						+ " will await until queue feed");
				long currentTimeMillis = System.currentTimeMillis();
				Long long1 = StorageTask.tl.get();
				logger.debug("thread has run " + (currentTimeMillis - long1) + " m ");
				this.await();
			}
			beanDatum = crawlDatumList.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ********* 从队列中取出一个实体类，存储到mysql **********
		
		strategy.storateStrategy(beanDatum);
		
	}

	public void signal() {
		lock.signalStoreThread();
	}

	public void await() {
		lock.awaitStoreThread();
	}
}