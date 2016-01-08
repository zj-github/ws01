package cn.innohub.crawler.conf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConfLoadRPCServer {

	public void startServer() {
		ExecutorService t = Executors.newSingleThreadExecutor();
		t.submit(new ConfLoadTask());
		
	}
	
//	public void fetch() {
//		ExecutorService pool = Executors.newSingleThreadExecutor();
//		pool.submit(new FisrtLevelSeedWorkShop());
//	}
	public static void main(String[] args) {
		new ConfLoadRPCServer().startServer();
	}
}

