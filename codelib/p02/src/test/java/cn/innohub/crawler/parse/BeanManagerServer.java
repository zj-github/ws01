package cn.innohub.crawler.parse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Queue;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.core.QueueManager;
import cn.innohub.crawler.crawl.parse.ParseCommonImpl;

/**
 * 接收到客户端发来的消息，就往集合中加入数据
 * 
 * @author oatt1
 *
 */
public class BeanManagerServer {
	public static boolean shutdown = false;

	public static void startServer(ParseCommonImpl parseCommonImp) throws Exception {
		System.out.println("server start");
		ServerSocket ss = new ServerSocket(10005);
		while (!shutdown) {
			Socket s = ss.accept();
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip + "....connected");
			BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			String line = null;
			while ((line = bufIn.readLine()) != null) {
				System.out.println(line);
				if("feedbeans".equals(line)){
					System.out.println("add beans");
					List<CrawlDatum> outLinks = new BeanFeeder().init();
					QueueManager.add(outLinks);
					System.out.println(QueueManager.beanDatumPool.size());
					parseCommonImp.signal();//唤醒解析线程
				}
				out.println(line.toUpperCase());
			}
			s.close();
		}
		ss.close();
	}
}