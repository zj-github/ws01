package cn.iktz.thread.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
	private Map<String, Object> cache = new HashMap<String, Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public Object getData(String key) {
		rwl.readLock().lock();
		Object obj = null;
		try {
			obj = cache.get(key);
			if (obj == null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if (obj == null) {
						// ²éÑ¯Êý¾Ý¿â£¬
					}
				} finally {
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} finally {
			rwl.readLock().unlock();
		}
		return obj;
	}
}
