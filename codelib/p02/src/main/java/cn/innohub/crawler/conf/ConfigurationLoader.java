package cn.innohub.crawler.conf;

import org.apache.log4j.Logger;

import cn.innohub.crawler.conf.readxml.XMLReader;

public class ConfigurationLoader {
	static {
		Logger.getLogger(ConfigurationLoader.class).info("load configuration");
		try {
			new XMLReader().loadXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		new FieldsExtractRegReader().initConf();
//		new SeedsFileReader().update();// 加载一级种子文件
//		new DetailSeedReader().read();
//		new DBMappingSeedReader().read();
//		Test2.display();
	}
	
	public static void main(String[] args) {
		try {
			Class.forName("cn.innohub.crawler.conf.ConfigurationLoader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
