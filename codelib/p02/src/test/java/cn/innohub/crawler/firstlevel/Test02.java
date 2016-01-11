package cn.innohub.crawler.firstlevel;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class Test02 {

	public static void main(String[] args) {
		TreeMap<String, Integer> tmap = new TreeMap<>();
		tmap.put("a", 4);
		tmap.put("b", 6);
		
		NavigableSet<String> navigableKeySet = tmap.navigableKeySet();
		
//		Collection<Integer> values = tmap.values();
		
		Iterator<String> iterator = navigableKeySet.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			System.out.println(next);
		}
		
		System.out.println(navigableKeySet);
		
		
		
		
	}
}
