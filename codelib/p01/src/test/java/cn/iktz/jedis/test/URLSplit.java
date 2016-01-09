package cn.iktz.jedis.test;

public class URLSplit {

	public static void main(String[] args) {
		String urls = "http://www.baidu.comhttp:163.com";
		String[] split = urls.substring(4).split("http");
		if(split.length>1){
			for (int i = 0; i < split.length; i++) {
				split[i]="http"+split[i];
				System.out.println(split[i]);
			}
		}
	}
	public static String[] getUrlsByParams(String str) {
		String[] urls = str.substring(4).split("http");
		if(urls.length>1){
			for (int i = 0; i < urls.length; i++) {
				urls[i]="http"+urls[i];
			}
		}
		return urls;
	}
}
