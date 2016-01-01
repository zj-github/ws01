package cn.iktz.thread.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest2 {

	public static void main(String[] args) {
		new LockTest2().init();
	}

	private void init() {
		Outputer outputer = new Outputer();
		new Thread(new MyRunnable(outputer, "1234567")).start();
		new Thread(new MyRunnable(outputer, "abcdefg")).start();
	}
}
class Outputer {
	Lock lock = new ReentrantLock();

	public void output(String name) {
		int len = name.length();
		lock.lock();
		try {
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		} finally {
			lock.unlock();
		}
	}
}
class MyRunnable implements Runnable {
	private Outputer outputer;
	private String name;

	public MyRunnable(Outputer outputer, String name) {
		this.outputer = outputer;
		this.name = name;
	}
	@Override
	public void run() {
		while (true) {
			outputer.output(name);
		}
	}
}
