package cn.innohub.crawler.common.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cn.innohub.crawler.common.beans.FirstLevelSeed;
import cn.innohub.crawler.crawl.firstlevel.seeds.extract.SeedComparator;
/**
 * @ClassName: SeedsTreeSetHashMap 
 * @Description: 包含一个map、一个set
 * 
 *  map的作用：在添加一级种子的时候，需要判断这个种子是否存在或者是否更新了，需要获取这个种子，所以
 *  
 * @author zhangjie
 * @date 2016年1月6日 上午9:28:39 
 *
 */
public class SeedsTreeSetHashMap {
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	private HashMap<String, FirstLevelSeed> hashMap = new HashMap<>();
	private TreeSet<FirstLevelSeed> treeSet = new TreeSet<>(new SeedComparator());
	private List<String> pollList = new ArrayList<>();

	public void add(String key, FirstLevelSeed value) {
		w.lock();
		try {
			hashMap.put(key, value);
			treeSet.add(value);
		} finally {
			w.unlock();
		}
	}

	public void add(FirstLevelSeed value) {
		w.lock();
		try {
			String url = value.getUrl();

			FirstLevelSeed firstLevelSeed = hashMap.get(url);
			if (firstLevelSeed == null) {
				pollList.remove(url);
				treeSet.add(value);
			} else {
				throw new RuntimeException("connot add this value ,because it is already in HashMap");
			}
		} finally {
			w.unlock();
		}
	}

	public FirstLevelSeed get(String key) {
		r.lock();
		try {
			return hashMap.get(key);
		} finally {
			r.unlock();
		}
	}

	public FirstLevelSeed first() {
		r.lock();
		try {
			return treeSet.first();
		} finally {
			r.unlock();
		}
	}

	public FirstLevelSeed pollFirst() {
		w.lock();
		try {
			FirstLevelSeed pollFirst = treeSet.pollFirst();
			pollList.add(pollFirst.getUrl());
			return pollFirst;
		} finally {
			w.unlock();
		}
	}

	public void remove(String key) {
		w.lock();
		try {
			if (!pollList.contains(key)) {
				hashMap.remove(key);
				Iterator<FirstLevelSeed> it = treeSet.iterator();
				while (it.hasNext()) {
					FirstLevelSeed next = it.next();
					if (next.getUrl().equals(key)) {
						treeSet.remove(next);
						break;
					}
				}
			} else {
				throw new RuntimeException("cannot remove the key");
			}

		} finally {
			w.unlock();
		}
	}
}