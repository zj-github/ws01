package cn.innohub.crawler.core;

import cn.innohub.crawler.conf.ConfLoadRPCServer;
import cn.innohub.crawler.crawl.fetch.FetchThreadContext;
import cn.innohub.crawler.crawl.firstlevel.seeds.extract.FisrtLevelSeedThreadContext;
import cn.innohub.crawler.crawl.parse.ParseThreadContext;

public class Crawler {
	public static void main(String[] args) {
		// 1、加载一级种子文件，加载抽取规则配置文件
		// 2、启动线程，监听来自客户端的请求（加载一级种子文件的请求）
		// 3、启动抽取一级种子的详情页的线程
		// 4、启动抓取线程
		// 5、启动解析线程
		// 6、启动存储线程
		try {
			Class.forName("cn.innohub.crawler.conf.ConfigurationLoader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ConfLoadRPCServer().startServer();
		new FisrtLevelSeedThreadContext().fetch();
		new FetchThreadContext().fetch();
		new ParseThreadContext().parse();
		
	}
}