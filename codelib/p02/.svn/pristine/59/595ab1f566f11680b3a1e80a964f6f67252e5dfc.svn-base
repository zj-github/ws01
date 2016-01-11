package cn.innohub.crawler.conf;

import cn.innohub.crawler.rpc.RPCServer;

public class ConfLoadTask implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			new RPCServer().accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}