package cn.innohub.crawler.common.utils;

public class Path {
	public static String getClassPath() {
		return Path.class.getClassLoader().getResource("").getPath();
	}
}
