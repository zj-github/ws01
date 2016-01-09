package cn.innohub.crawler.crawl.storage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.innohub.crawler.crawl.storage.strategy.JDBCStorateStrategy;

/**
 * @ClassName: FetchThreadContext
 * @Description: 启动线程池
 * @author zhangjie
 * @date 2015年12月31日 下午4:15:06
 */
public class StorateThreadContext {

	public static void main(String[] args) {
		StorateThreadContext ftc = new StorateThreadContext();
		ftc.storate();
	}

	public void storate() {
		StorageTask parseTask = new StorageTask(new StoragerCommonImpl(new JDBCStorateStrategy()));
		int parseThreadNum = 5; // 抓取线程数
		ExecutorService parseThreadPool = Executors.newFixedThreadPool(parseThreadNum);

		for (int i = 0; i < parseThreadNum; i++) {
			parseThreadPool.submit(parseTask);
		}
	}
}
