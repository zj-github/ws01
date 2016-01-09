package cn.innohub.crawler.crawl.firstlevel.seeds.extract;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.innohub.crawler.common.beans.DetailPageSeed;
import cn.innohub.crawler.core.QueueManager;

public class FisrtLevelSeedThreadContext {
	
	public void fetch() {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.submit(new FisrtLevelSeedWorkShop());
	}
	public static void main(String[] args) {
		try {
			Class.forName("cn.innohub.crawler.conf.ConfigurationLoader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new FisrtLevelSeedThreadContext().fetch();
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------------------------------------------");
		ArrayBlockingQueue<DetailPageSeed> detailPageQueue = QueueManager.detailPageQueue;
		Iterator<DetailPageSeed> iterator = detailPageQueue.iterator();
		while(iterator.hasNext()){
			DetailPageSeed next = iterator.next();
			System.out.println(next);
		}
		
	}
	
}