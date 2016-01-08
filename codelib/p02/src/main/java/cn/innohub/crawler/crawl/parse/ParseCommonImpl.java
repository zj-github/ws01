package cn.innohub.crawler.crawl.parse;

import java.util.concurrent.ArrayBlockingQueue;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.beans.BeanDatum;
import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.core.QueueManager;
import cn.innohub.crawler.core.ThreadLockController;
import cn.innohub.crawler.crawl.parse.strategy.ParseStrategy;

/**
 * @ClassName: ParseCommonImpl
 * @Description: 解析策略的执行者 解析html，封装成对象，加入CrawlDatum队列。
 * @author zhangjie
 * @date 2016年1月4日 上午10:39:54
 *
 */
public class ParseCommonImpl implements Parser {
	private Logger logger = Logger.getLogger(ParseCommonImpl.class);
	private ParseStrategy strategy;

	private ThreadLockController lock = ThreadLockController.getInstance();

	public ParseCommonImpl(ParseStrategy strategy) {
		this.strategy = strategy;
	}

	private ArrayBlockingQueue<CrawlDatum> crawlDatumList = QueueManager.crawlDatumPool;

	/**
	 * 1、从队列中获取CrawlDatum，若队列为null，则等待 2、通过crawlDatum取得htmlContent，
	 * 3、调用解析策略方法，获取解析后的实体类
	 */

	@Override
	public BeanDatum parse() {
		CrawlDatum crawlDatum = null;
		try {
			logger.debug("detail page queue size >> " + crawlDatumList.size());
			while (crawlDatumList.size() == 0) { // 队列中没有htmlContent以后，线程等待
				logger.debug("no html content in crawl datum queue," + Thread.currentThread().getName()
						+ " will await until queue feed");
				long currentTimeMillis = System.currentTimeMillis();
				Long long1 = ParseTask.tl.get();
				logger.debug("thread has run " + (currentTimeMillis - long1) + " m ");
				this.await();
			}
			crawlDatum = crawlDatumList.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ********* 从队列中取出一个网页，解析 **********
		return (BeanDatum) strategy.parseStrategy(crawlDatum);
	}

	public void signal() {
		lock.signalParseThread();
	}

	public void await() {
		lock.parseThreadAwait();
	}
}