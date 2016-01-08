package cn.innohub.crawler.common.utils;

import java.util.regex.Pattern;

public class JsoupUtil {
	public static boolean checkHref(String url) {
		if (url.startsWith("tel:")||url.startsWith("javascript:") || url.startsWith("#")) {
			return false;
		} else {
			return true;
		}
	}
	
//	http://www.innohub.net/sciencemarket/article/detail.html?id=396
	private Pattern p = Pattern.compile("^(http|https)://www.innohub.net/sciencemarket/article/detail.html\\?id=.*");
	public boolean checkReg(String url) {
		return p.matcher(url).matches();
	}
}
