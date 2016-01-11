package cn.innohub.crawler.firstlevel;

import java.util.Iterator;
import java.util.TreeSet;


public class ETest {

	/**
	 * while(){
	 * 		1、获取nearly url u1。
	 * 		2、抓取u1
	 * 		3、设置u1的下次抓取时间（u1.setNextFetchTime(now+u.interval)）
	 * 		4、集合排序
	 * 		5、获取nearly url u2。
	 * 		6、算出休眠时间 t1= Set.getFirst.getNextFetchTime()
	 * 		7、sleep(t1) 
	 * }
	 * 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @author zhangjie
	 * @date 2016年1月5日 下午3:42:55 
	 * @param args
	 *
	 */
	static TreeSet<FirstLevelSeed> s = new TreeSet<>(new MyComparator());
	public static void main(String[] args) {
		
		FirstLevelSeed e = new FirstLevelSeed(2,20,"baidu");
		s.add(e);
		FirstLevelSeed e2 = new FirstLevelSeed(8,4,"sina");
		s.add(e2);
		FirstLevelSeed e3 = new FirstLevelSeed(10,9,"google");
		s.add(e3);
		
		while(true){
			iterator2();
		}
	}

	private static void iterator2() {
//			 * 		1、获取nearly url u1。
//			 * 		2、抓取u1
//			 * 		3、设置u1的下次抓取时间（u1.setNextFetchTime(now+u.interval)）
//			 * 		4、集合排序
//			 * 		5、获取nearly url u2。
//			 * 		6、算出休眠时间 t1= Set.getFirst.getNextFetchTime()
//			 * 		7、sleep(t1) 
		//1
		FirstLevelSeed cur = s.pollFirst();
		//TODO fetch
		fetch(cur);
		//3
		int fetchTime = cur.fetchTime;
		cur.fetchTime=fetchTime+cur.interval;
		//4、
		s.add(cur);
		FirstLevelSeed first = s.first();
		try {
			iterator(s);
			System.out.println();
			Thread.sleep((first.fetchTime-fetchTime)*1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void fetch(FirstLevelSeed cur){
		System.out.println("cur "+cur.toString());
		iterator(s);
	
		System.out.println("------------------------------");
	}
	
	private static void iterator(TreeSet<FirstLevelSeed> s) {
		Iterator<FirstLevelSeed> it = s.iterator();
		while(it.hasNext()){
			FirstLevelSeed next = it.next();
			System.out.println(next.toString());
		}
	}

}


