package cn.iktz.thread.demo;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class CallableAndFuture2 {

	class MyCallable1 implements Callable<String> {
		public String call() throws Exception {
			return " method call is running";
		};
	}
	@Test
	public void test01() throws Exception {
		// 1、创建线程池
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		// 2、提交任务、获取返回值
		Future<String> future = threadPool.submit(new MyCallable1());
		//3、输出返回值
		System.out.println(future.get());
		threadPool.shutdown();
	}
	class MyCallable2 implements Callable<Integer>  {
		private int seq ;
		public MyCallable2(int seq){
			this.seq = seq;
		}
		@Override
		public Integer call() throws Exception {
			Thread.sleep(new Random().nextInt(5000));
			return seq;
		}
	}
	@Test
	public void test02() throws Exception {
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
		for (int i = 1; i <= 10; i++) {
			completionService.submit(new MyCallable2(i));
		}
		for (int i = 0; i < 12; i++) {
			System.out.println("start >> "+i);
			System.out.println(completionService.take().get());
			System.out.println("end >> "+i);
			//如果没有拿到结果，会阻塞在那里。
		}
		threadPool2.shutdown();
	}

}
