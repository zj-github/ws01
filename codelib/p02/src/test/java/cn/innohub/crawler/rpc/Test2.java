package cn.innohub.crawler.rpc;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import cn.innohub.crawler.common.api.SafeTreeSet;
import cn.innohub.crawler.common.beans.ExtractRule;
import cn.innohub.crawler.common.beans.FirstLevelSeed;
import cn.innohub.crawler.core.Context;

public class Test2 {
	public static void display() {
		ConcurrentHashMap<Object, Object> params = Context.getInstance().getParams();
		Set<Entry<Object, Object>> entrySet = params.entrySet();
		for (Entry<Object, Object> e : entrySet) {
			Object value = e.getValue();
			Object key = e.getKey();
			System.out.println("params>>k " + key);
			System.out.println("params>>k " + value);

		}

		SafeTreeSet firstLevelSeeds = Context.getInstance().getFirstLevelSeeds();
		Iterator<FirstLevelSeed> it = firstLevelSeeds.iterator();
		while (it.hasNext()) {
			FirstLevelSeed next = it.next();
			System.out.println(next.toString());
		}

		ConcurrentHashMap<String, ExtractRule> ruleMap = Context.getInstance().getRuleMap();
		Set<Entry<String, ExtractRule>> entrySet2 = ruleMap.entrySet();
		for (Entry<String, ExtractRule> e : entrySet2) {
			Object value = e.getValue();
			Object key = e.getKey();
			System.out.println(key.toString());
			System.out.println(value.toString());
		}

	}
}
