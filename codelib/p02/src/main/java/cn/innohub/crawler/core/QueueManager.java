package cn.innohub.crawler.core;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import cn.innohub.crawler.common.beans.BeanDatum;
import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.beans.DetailPageSeed;

public class QueueManager {

	public static ArrayBlockingQueue<String> seedsQueue = new ArrayBlockingQueue<>(1000);
	public static ArrayBlockingQueue<DetailPageSeed> detailPageQueue = new ArrayBlockingQueue<>(1000);// 详情页队列
	public static ArrayBlockingQueue<CrawlDatum> crawlDatumPool = new ArrayBlockingQueue<>(10000);// 抓取后封装的实体类
	public static ArrayBlockingQueue<BeanDatum> beanDatumPool = new ArrayBlockingQueue<>(10000);// 解析后封装的实体类

	public static void add(CrawlDatum webPage) {
		try {
			crawlDatumPool.put(webPage);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void add(List<CrawlDatum> webPage) {
		crawlDatumPool.addAll(webPage);
	}

	public static void add(BeanDatum webPage) {
		try {
			beanDatumPool.put(webPage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void add(String url) {
		try {
			seedsQueue.put(url);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addSeeds(Collection<DetailPageSeed> urlList) {
		detailPageQueue.addAll(urlList);
	}

}
