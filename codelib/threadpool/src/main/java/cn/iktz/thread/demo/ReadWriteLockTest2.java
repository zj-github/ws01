package cn.iktz.thread.demo;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest2 {
	public static void main(String args[])  {
		final ThreadData threadData = new ThreadData();
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					while (true) {
						try {
							threadData.get();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			}.start();

			new Thread() {
				public void run(){
					while (true) {
						try {
							threadData.put(new Random().nextInt(10000));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			}.start();
		}
	}

	static class ThreadData {
		private Object data = null;
		ReadWriteLock rwl = new ReentrantReadWriteLock();

		public void get() throws Exception {
			rwl.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + " --- get method start >>");
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println(Thread.currentThread().getName() + " --- get method end >> data :" + data);
			} finally {
				rwl.readLock().unlock();
			}
		}

		public void put(Object data) throws Exception {
			rwl.writeLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + " ||| put method start >>");
				Thread.sleep((long) (Math.random() * 1000));
				this.data = data;
				System.out.println(Thread.currentThread().getName() + " ||| put method end >> data :" + data);
			} finally {
				rwl.writeLock().unlock();
			}
		}
	}
}
