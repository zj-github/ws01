package cn.iktz.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void testThreadPool() {
		// ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// ExecutorService threadPool = Executors.newCachedThreadPool();
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("task execute");
			}
		});
		threadPool.shutdownNow();
	}

	public void test02() {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(6);
		newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("di da !");
			}
		}, 6, // �೤ʱ���Ժ�ը
				2, // ÿ�����ըһ��
				TimeUnit.SECONDS);
	}

}
