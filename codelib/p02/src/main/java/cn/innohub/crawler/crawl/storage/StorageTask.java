package cn.innohub.crawler.crawl.storage;

import org.apache.log4j.Logger;

/**
 * @ClassName: FetchTask
 * @Description: 实现run方法，启动while循环，抓取网页
 * @author zhangjie
 * @date 2015年12月31日 下午3:42:45
 *
 */
public class StorageTask implements Runnable {
	private Logger logger = Logger.getLogger(StorageTask.class);
	public static ThreadLocal<Long> tl = new ThreadLocal<>();
	private Storager storager;

	public StorageTask(Storager storager) {
		this.storager = storager;
	}

	@Override
	public void run() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + " start at " + currentTimeMillis);

		tl.set(currentTimeMillis);
		while (true) {
			try {
				logger.debug("storage method will be executed");
				storager.storage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
