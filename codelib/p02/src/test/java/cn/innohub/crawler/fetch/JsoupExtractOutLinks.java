//package cn.innohub.crawler.fetch;
//
//import cn.innohub.crawler.crawl.fetch.FetchThreadContext;
//import cn.innohub.crawler.crawl.fetch.FetcherCommonImpl;
//import cn.innohub.crawler.crawl.fetch.strategy.HttpClientFetchStrategy;
//
//public class JsoupExtractOutLinks {
//	public static void main(String[] args) throws Exception {
//	
//		//1、启动抓取线程
//		FetchThreadContext ftc = new FetchThreadContext();
//		final FetcherCommonImpl fetcherCommonImpl = new FetcherCommonImpl(new HttpClientFetchStrategy());
////		fetcherCommonImpl.setLock(new ThreadController());
////		FetchTask fetchTask = new FetchTask(fetcherCommonImpl);
//		ftc.fetch();
//		
//		//2、启动种子feeder的服务端和客户单
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					SeedManagerServer.startServer(fetcherCommonImpl);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//		t.start();
//	}
//}