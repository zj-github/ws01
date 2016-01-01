package cn.iktz.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// ExecutorService threadPool = Executors.newCachedThreadPool();
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 1; j <= 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(
								Thread.currentThread().getName() + " is looping of " + j + " for  task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed! ");
		// threadPool.shutdownNow();

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
