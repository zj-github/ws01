package cn.innohub.crawler.crawl.parse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.innohub.crawler.crawl.parse.strategy.JsoupParseStrategy;

/**
 * @ClassName: FetchThreadContext
 * @Description: 启动线程池
 * @author zhangjie
 * @date 2015年12月31日 下午4:15:06
 */
public class ParseThreadContext {

	public static void main(String[] args) {
		ParseThreadContext ftc = new ParseThreadContext();
		ftc.parse();
	}

	public void parse() {
		ParseTask parseTask = new ParseTask(new ParseCommonImpl(new JsoupParseStrategy()));
		int parseThreadNum = 5; // 抓取线程数
		ExecutorService parseThreadPool = Executors.newFixedThreadPool(parseThreadNum);

		for (int i = 0; i < parseThreadNum; i++) {
			parseThreadPool.submit(parseTask);
		}
	}
}