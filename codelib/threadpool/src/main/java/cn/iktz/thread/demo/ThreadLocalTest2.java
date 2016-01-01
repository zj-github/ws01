package cn.iktz.thread.demo;

import java.util.Random;

public class ThreadLocalTest2 {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new ThreadLocalTestSetData()).start();
		}
	}
}

class Object1 {
	public void get(ThreadLocal<Integer> x) {
		System.out.println("A from " + Thread.currentThread().getName() + " get data :" + x.get());
	}
}

class ThreadLocalTestSetData implements Runnable {
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	@Override
	public void run() {
		int data = new Random().nextInt();
		System.out.println(Thread.currentThread().getName() + " has put data :" + data);
		threadLocal.set(data);// x用来存储数据，存储的数据与当前线程有关的而非全局的
		MyThreadScopeData.getThreadInstance().setName("name" + data);
		MyThreadScopeData.getThreadInstance().setAge(data);
		new Object1().get(threadLocal);
	}
}
