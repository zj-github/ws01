package cn.iktz.socket.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putptr/** 应该放在数组的哪个位置上 */
	, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();// 如果已经满了，就不能放了，就等待，直到有人取走（即take方法中的notFull.signal被执行），
			items[putptr] = x;// 放了一个数据，putptr要+1
			if (++putptr == items.length)
				putptr = 0;// 如果放满了，就把指针置为0
			++count;//
			notEmpty.signal();// 没满的线程启动
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();// 如果队列里没有了，取不到，就等待，直到put方法中的notEmpty.signal被执行。
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();// 取走了，告诉别人可以放了
			return x;
		} finally {
			lock.unlock();
		}
	}
}