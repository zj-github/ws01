package cn.iktz.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
		for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					while (true) {
						try {
							// 放数据
							queue.put(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}

			}.start();
		}

		new Thread() {
			public void run() {
				while (true) {
					try {
						// 取数据
						queue.take();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
