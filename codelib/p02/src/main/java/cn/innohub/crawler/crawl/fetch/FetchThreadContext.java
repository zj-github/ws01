package cn.innohub.crawler.crawl.fetch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.innohub.crawler.crawl.fetch.strategy.HttpClientFetchStrategy;

/**
 * @ClassName: FetchThreadContext
 * @Description: 启动线程池
 * @author zhangjie
 * @date 2015年12月31日 下午4:15:06
 */
public class FetchThreadContext {
	
	public static void main(String[] args) {
		
		
		
		FetchThreadContext ftc = new FetchThreadContext();
		ftc.fetch();
		
		
	}
	public void fetch() {
		
		int fetchThreadNum = 5; // 抓取线程数
		ExecutorService fetchThreadPool = Executors.newFixedThreadPool(fetchThreadNum);
	
		FetchTask fetchTask = new FetchTask(new FetcherCommonImpl(new HttpClientFetchStrategy()));
		for (int i = 0; i < fetchThreadNum; i++) {
			fetchThreadPool.submit(fetchTask);
		}
	}
	
	
}