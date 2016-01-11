//package cn.innohub.crawler.firstlevel;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;
//
//import org.junit.Test;
//
//import cn.innohub.crawler.beans.FirstLevelSeed;
//import cn.innohub.crawler.common.FileNameConstant;
//import cn.innohub.crawler.firstlevel.seeds.manager.SeedsFileReader;
//import cn.innohub.crawler.utils.Path;
//
//public class TestFirstLevel {
//
//	public void test( ) {
//		List<String> list1 = new ArrayList<>();
//		list1.add("1111");
//		list1.add("2222");
//		list1.add("3333");
//
//		List<String> list2 = new ArrayList<>();
//		list2.add("3333");
//		list2.add("4444");
//		list2.add("5555");
//
//		// 无重复并集
//		list2.removeAll(list1);
//		list1.addAll(list2);
//
//		System.out.println(Arrays.toString(list1.toArray()));
//	}
//
//	@Test
//	public void test01() {
//		SeedsFileReader sfr = new SeedsFileReader();
//		List<FirstLevelSeed> readSeedsFile = sfr
//				.readSeedsFile(Path.getClassPath() + FileNameConstant.FIRST_LEVEL_SEEDS_XML);
//		System.out.println(Arrays.toString(readSeedsFile.toArray()));
//	}
//
//	public static void main(String[] args) {
//		FirstLevelSeed f1 = new FirstLevelSeed("http://www.innohub.net/sciencemarket/article/index.html", 2,
//				"f1", true);
//		FirstLevelSeed f2 = new FirstLevelSeed("http://www.innohub.net/sciencemarket/article/index.html", 2,
//				"f2", true);
//		FirstLevelSeed f3 = new FirstLevelSeed("http://www.innohub.net/sciencemarket/article/index3.html", 2,
//				"f3", true);
//
////		List<FirstLevelSeed> list1 = new ArrayList<>();
////		list1.add(f1);
////		list1.add(f2);
////
////		List<FirstLevelSeed> list2 = new ArrayList<>();
////		list2.add(f2);
////		list2.add(f3);
////		
////		// 无重复并集
////		list2.removeAll(list1);
////		list1.addAll(list2);
//		
//		Set<FirstLevelSeed> set1 = new TreeSet<>();
//		set1.add(f1);
//		set1.add(f2);
//		
//		System.out.println(Arrays.toString(set1.toArray()));
//
//	}
//
//	@Test
//	public void mian() {
//		String s1 = "aaaa1";
//		String s2 = "aaaa1";
//		int compareTo = s1.compareTo(s2);
//		System.out.println(compareTo);
//	}
//	
//}