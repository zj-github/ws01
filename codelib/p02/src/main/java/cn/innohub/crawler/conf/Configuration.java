package cn.innohub.crawler.conf;

import cn.innohub.crawler.core.Context;

public class Configuration {

	public static void setParams(String key,String value){
		Context.getInstance().setParam(key, value);
	}
	
	public static Object getParams(String key){
		return Context.getInstance().getParam(key);
	}
	
}