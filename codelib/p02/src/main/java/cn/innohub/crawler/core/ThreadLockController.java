package cn.innohub.crawler.core;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockController {

	private static final ThreadLockController threadController = new ThreadLockController();

	private ThreadLockController() {
	}

	public static ThreadLockController getInstance() {
		return threadController;
	}

	private Lock lock = new ReentrantLock();
	private Condition fetchCondition = lock.newCondition();
	private Condition parseCondition = lock.newCondition();
	private Condition firstLevelSeedExtractCondition = lock.newCondition();
	private Condition storeCondition = lock.newCondition();

	public void awaitStoreThread() {
		lock.lock();
		try {
			storeCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalStoreThread() {
		lock.lock();
		try {
			storeCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void awaitFirstLevelSeedExtractThread() {
		lock.lock();
		try {
			firstLevelSeedExtractCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalFirstLevelSeedExtractThread() {
		lock.lock();
		try {
			firstLevelSeedExtractCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void parseThreadAwait() {
		lock.lock();
		try {
			parseCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalParseThread() {
		lock.lock();
		try {
			parseCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void fetchThreadAwait() {
		lock.lock();
		try {
			fetchCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalFetchThread() {
		lock.lock();
		try {
			fetchCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}
}