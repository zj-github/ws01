package mydemo;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.*;

public class ProducerConsumerDemo4 {
	public static void main(String[] args) {

		Queue q = new Queue();
		QueueFeeder qf = new QueueFeeder(q);
		Fetcher f= new Fetcher(q);

		Thread t1 = new Thread(qf);
		Thread t3 = new Thread(f);
		Thread t4 = new Thread(f);

		t1.start();
		t3.start();
		t4.start();

	}
}

/*
 * JDK1.5 中提供了多线程升级解决方案。 将同步Synchronized替换成现实Lock操作。 将Object中的wait，notify
 * notifyAll，替换了Condition对象。 该对象可以Lock锁 进行获取。 该示例中，实现了本方只唤醒对方操作。
 * 
 * Lock:替代了Synchronized lock unlock newCondition()
 * 
 * Condition：替代了Object wait notify notifyAll await(); signal(); signalAll();
 */
class Queue1 {
	private CopyOnWriteArrayList<String> urlList = new CopyOnWriteArrayList<>();
//	private boolean flag = false;
	// t1 t2
	private Lock lock = new ReentrantLock();

//	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();

	public void addUrl(String url) throws InterruptedException {
		lock.lock();
		try {		
			
//			while (flag)//真（有种子）：等待
//				condition_pro.await();// t1,t2
			
			while(urlList.size()==0){
				urlList.add(url);	
			}
			
//			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + "...添加.." + url);
//			flag = false;
			condition_con.signal();
		} finally {
			lock.unlock();// 释放锁的动作一定要执行。
		}
	}

	// t3 t4
	public void fetch() throws InterruptedException {
		lock.lock();
		try {
			
			while (urlList.size()==0){//假、没有种子了，要等待
				System.out.println("没有种子了");
				condition_con.await();
			}
				
			String firstUrl = urlList.remove(0);
			System.out.println(Thread.currentThread().getName() + "...抓取........." + firstUrl);
//			flag = false;
//			condition_pro.signal();
		} finally {
			lock.unlock();
		}

	}
}

class QueueFeeder1 implements Runnable {
	private Queue queue;

	QueueFeeder1(Queue queue) {
		this.queue = queue;
	}
	
	public void run() {
		while (true) {
			try {
				queue.addUrl(new Random().nextInt()+"");
			} catch (InterruptedException e) {
			}
		}
	}
}

class Fetcher1 implements Runnable {
	private Queue queue;

	Fetcher1(Queue queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				queue.fetch();;
			} catch (InterruptedException e) {
			}
		}
	}
}