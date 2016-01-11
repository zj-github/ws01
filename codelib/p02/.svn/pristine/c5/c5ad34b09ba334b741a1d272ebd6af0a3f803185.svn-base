package cn.innohub.crawler.common.api;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cn.innohub.crawler.common.beans.FirstLevelSeed;
import cn.innohub.crawler.crawl.firstlevel.seeds.extract.SeedComparator;

/**
 * @ClassName: SafeTreeSet
 * @Description: 线程安全的set集合
 * @author zhangjie
 * @date 2016年1月6日 上午9:31:34
 *
 */
public class SafeTreeSet {
	private final TreeSet<FirstLevelSeed> ts;

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
    public Iterator<FirstLevelSeed> iterator() {
    	w.lock();
		try {
			return ts.iterator();
		} finally {
			w.unlock();
		}
    }
	public FirstLevelSeed pollFirst() {
		w.lock();
		try {
			return ts.pollFirst();
		} finally {
			w.unlock();
		}
	}

	public FirstLevelSeed first() {
		r.lock();
		try {
			return ts.first();
		} finally {
			r.unlock();
		}
	}

	public void add(FirstLevelSeed t) {
		w.lock();
		try {
			ts.add(t);
		} finally {
			w.unlock();
		}
	}

	public void addAll(List<FirstLevelSeed> list) {
		w.lock();
		try {
			ts.addAll(list);
		} finally {
			w.unlock();
		}
	}
	public FirstLevelSeed exist(String url) {
		w.lock();
		try {
			Iterator<FirstLevelSeed> iterator = ts.iterator();
			while (iterator.hasNext()) {
				FirstLevelSeed seed = iterator.next();
				if (seed.getUrl().equals(url)) {
					return seed;
				}
			}
			return null;
		} finally {
			w.unlock();
		}
	}

	public boolean remove(FirstLevelSeed firstLevelSeed) {
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

	public CopyOnWriteArrayList<FirstLevelSeed> removeOutTimeSeed(Date now) {
		w.lock();
		CopyOnWriteArrayList<FirstLevelSeed> outTimeSeed = new CopyOnWriteArrayList<>();
		try {
			Iterator<FirstLevelSeed> iterator = ts.iterator();
			while (iterator.hasNext()) {
				FirstLevelSeed seed = iterator.next();
				Date nextFetchTime = seed.getNextFetchTime();
				if (nextFetchTime == null||nextFetchTime.before(now) || nextFetchTime.getTime() == now.getTime()) {// 超时的
					outTimeSeed.add(seed);
					ts.remove(seed);
				}
			}
			return outTimeSeed;
		} finally {
			w.unlock();
		}
	}

}