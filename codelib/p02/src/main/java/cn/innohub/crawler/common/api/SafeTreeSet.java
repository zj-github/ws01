package cn.innohub.crawler.common.api;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cn.innohub.crawler.conf.readxml.Host;
import cn.innohub.crawler.conf.readxml.SeedComparator;

/**
 * @ClassName: SafeTreeSet
 * @Description: 线程安全的set集合
 * @author zhangjie
 * @date 2016年1月6日 上午9:31:34
 *
 */
public class SafeTreeSet {
	private final TreeSet<Host> ts;

	public SafeTreeSet(SeedComparator comp) {
		ts = new TreeSet<>(comp);
	}

	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	public int size(){
		r.lock();
		try {
			return ts.size();
		} finally {
			r.unlock();
		}
	}
    public Iterator<Host> iterator() {
    	w.lock();
		try {
			return ts.iterator();
		} finally {
			w.unlock();
		}
    }
	public Host pollFirst() {
		w.lock();
		try {
			return ts.pollFirst();
		} finally {
			w.unlock();
		}
	}

	public Host first() {
		r.lock();
		try {
			return ts.first();
		} finally {
			r.unlock();
		}
	}

	public void add(Host t) {
		w.lock();
		try {
			ts.add(t);
		} finally {
			w.unlock();
		}
	}

	public void addAll(List<Host> list) {
		w.lock();
		try {
			ts.addAll(list);
		} finally {
			w.unlock();
		}
	}
	public Host exist(String url) {
		w.lock();
		try {
			Iterator<Host> iterator = ts.iterator();
			while (iterator.hasNext()) {
				Host seed = iterator.next();
				if (seed.getUrl().equals(url)) {
					return seed;
				}
			}
			return null;
		} finally {
			w.unlock();
		}
	}

	public boolean remove(Host firstLevelSeed) {
		w.lock();
		try {
			return ts.remove(firstLevelSeed);
		} finally {
			w.unlock();
		}
	}
    public void clear() {
    	w.lock();
		try {
			ts.clear();
		} finally {
			w.unlock();
		}
    }

	public CopyOnWriteArrayList<Host> removeOutTimeSeed(Date now) {
		w.lock();
		CopyOnWriteArrayList<Host> outTimeSeed = new CopyOnWriteArrayList<>();
		try {
			Iterator<Host> iterator = ts.iterator();
			while (iterator.hasNext()) {
				Host seed = iterator.next();
				Date nextFetchTime = seed.getNextFetchTime();
				if (nextFetchTime == null||nextFetchTime.before(now) || nextFetchTime.getTime() == now.getTime()) {// 超时的
					outTimeSeed.add(seed);
					iterator.remove();
//					ts.remove(seed);
				}
			}
			return outTimeSeed;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			w.unlock();
		}
		return outTimeSeed;
	}

}