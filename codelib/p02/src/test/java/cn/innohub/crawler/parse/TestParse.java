package cn.innohub.crawler.parse;

import cn.innohub.crawler.crawl.parse.ParseCommonImpl;
import cn.innohub.crawler.crawl.parse.ParseThreadContext;
import cn.innohub.crawler.crawl.parse.strategy.JsoupParseStrategy;

public class TestParse {
	public static void main(String[] args) throws Exception {
	
		//1、启动解析线程
		ParseThreadContext ftc = new ParseThreadContext();
		final ParseCommonImpl parseCommonImpl = new ParseCommonImpl(new JsoupParseStrategy());
//		fetcherCommonImpl.setLock(new ThreadController());
//		ParseTask fetchTask = new ParseTask(parseCommonImpl);
		ftc.parse();
		
		//2、启动一个线程，往bean集合中放测试数据
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					BeanManagerServer.startServer(parseCommonImpl);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
}