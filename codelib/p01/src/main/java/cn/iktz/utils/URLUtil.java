package cn.iktz.utils;

public class URLUtil {
	public static String[] getUrlsByParams(String str) {
		String[] urls = str.substring(4).split("http");
		if(urls.length>1){
			for (int i = 0; i < urls.length; i++) {
				urls[i]="http"+urls[i];
			}
		}else{
			urls[0]=str;
		}
		return urls;
	}
//	@Test
//	public void test(){
//		String s = "http://mp.weixin.qq.com/s?__biz=MzAwNjMxMTA5Mw==&mid=401497949&idx=1&sn=e446ea237172978120351eb1b83e06b4&scene=0#wechat_redirect";
//
//		String biz  = s.substring(s.indexOf("__biz=")+6, s.indexOf("&mid="));
//		System.out.println(biz);
//		
//		String sn = s.substring(s.indexOf("&sn=")+4,s.indexOf("&scene="));
//		System.out.println(sn);
//		
//	}
}
