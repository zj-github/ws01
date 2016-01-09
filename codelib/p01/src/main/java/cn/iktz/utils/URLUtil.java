package cn.iktz.utils;

public class URLUtil {
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
