package cn.innohub.crawler.crawl.firstlevel.seeds.extract;

import java.net.URL;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.api.SafeTreeSet;
import cn.innohub.crawler.common.beans.DetailPageSeed;
import cn.innohub.crawler.common.utils.HttpClientFetcher;
import cn.innohub.crawler.common.utils.ParseUtil;
import cn.innohub.crawler.common.utils.PhantomjsUtil;
import cn.innohub.crawler.conf.readxml.DetailPage;
import cn.innohub.crawler.conf.readxml.Host;
import cn.innohub.crawler.core.Context;
import cn.innohub.crawler.core.QueueManager;
import cn.innohub.crawler.core.ThreadLockController;
import cn.innohub.crawler.crawl.fetch.FetchTask;

/**
 * @ClassName: FisrtLevelSeedWorkShop
 * @Description: 启动抓取算法
 * @author zhangjie
 * @date 2016年1月6日 上午9:20:21
 *
 */
public class FisrtLevelSeedWorkShop implements Runnable {

	@Override
	public void run() {
		logger.info("FisrtLevelSeedWorkShop run");
		work();
	}

	/**
	 * while(){ 1、获取nearly url u1。 2、抓取u1
	 * 3、设置u1的下次抓取时间（u1.setNextFetchTime(now+u.interval)） 4、集合排序 5、获取nearly url
	 * u2。 6、算出休眠时间 t1= Set.getFirst.getNextFetchTime() 7、sleep(t1) }
	 * 
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @author zhangjie
	 * @date 2016年1月5日 下午3:42:55
	 * @param args
	 *
	 */
	private SafeTreeSet seeds = Context.getInstance().getFirstLevelSeeds();
	private boolean stop = false;
	private Logger logger = Logger.getLogger(FisrtLevelSeedWorkShop.class);

	public void work() {
		while (!stop) {
			while (seeds.size() == 0) {// 没有种子以后线程等待
				logger.debug("no seed in first leve seed set collection," + Thread.currentThread().getName()
						+ " will await until queue feed");
				long currentTimeMillis = System.currentTimeMillis();
				Long long1 = FetchTask.tl.get();
				logger.debug("thread has run " + (currentTimeMillis - long1) + " m ");
				// fetchCondition.await();
				ThreadLockController.getInstance().awaitFirstLevelSeedExtractThread();
			}
			iterator();
		}
	}

	private void iterator() {
		// * 1、弹出nearly url u1。
		// * 2、抓取u1
		// * 3、设置u1的下次抓取时间（u1.setNextFetchTime(now+u.interval)）
		// * 4、集合排序
		// * 5、获取nearly url u2。
		// * 6、算出休眠时间 t1= Set.getFirst.getNextFetchTime()
		// * 7、sleep(t1)
		// 1
		// FirstLevelSeed cur = seeds.pollFirst();
		CopyOnWriteArrayList<Host> outTimeSeed = getOutTimeSeed();

		// 2、3、
		this.fetchAndExtract(outTimeSeed);

		// 4、
		seeds.addAll(outTimeSeed);// 会从新排序
		// 5、

		Host first = seeds.first();
		try {
			// 6、休眠时间：下次抓取时间最近的种子的下次抓取时间-到现在的时间
			long sleepInterval = first.getNextFetchTime().getTime() - new Date().getTime();
			if (sleepInterval < 0) {
				throw new RuntimeException("next fetch time not allow");
			}
			// 7、
			logger.info("firstLevel seed work shop will spleep " + sleepInterval);
			Thread.sleep(sleepInterval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void outTime() {

	}

	/**
	 * 
	 * @Description: 抓取一级种子，抽取外链，加入详情页种子队列
	 * @author zhangjie
	 * @date 2016年1月6日 上午11:33:56
	 * @param outTimeSeed
	 *
	 */
	public void fetchAndExtract(List<Host> outTimeSeed) {
		for (Host seed : outTimeSeed) {

			// String htmlContent =
			// HttpClientFetcher.fetchHtmlContent(seed.getUrl());
			logger.info("PhantomjsUtil running");
			String seedurl = seed.getUrl();
			String htmlContent ="";
			if(seedurl.equals("http://news.163.com/")){
				htmlContent = HttpClientFetcher.fetchHtmlContent(seedurl);
			}else{
				htmlContent = PhantomjsUtil.fetchHtmlContent(seedurl);
			}
			
			logger.info("PhantomjsUtil over");
			List<URL> outLinks = ParseUtil.getOutLinks(seedurl, htmlContent, seed.getDetailPageReg());// 抽取外链
			logger.info("get outlinks " + outLinks.size());
			Set<DetailPageSeed> urlSet = new TreeSet<>(new SeedComparator());

			for (URL url : outLinks) {// 加入队列
				String detailId = "";
				ConcurrentHashMap<String, DetailPage> detailPages = Context.getInstance().getDetailPages();
				boolean flag = false;
				w: for (DetailPage detailPage : detailPages.values()) {
					String reg = detailPage.getReg();
					if (url.toString().matches(reg)) {
						detailId = detailPage.getId();
						flag = true;
						break w;
					}
				}
				if (flag) {
					logger.info("* outlink " + url);
					urlSet.add(new DetailPageSeed(url.toString(), detailId));
				}
			}
			QueueManager.addSeeds(urlSet);

			ThreadLockController.getInstance().signalFetchThread();// 通知抓取线程
			this.setNextFetchTime(seed);// 抓取完成后设置下次抓取时间
		}

	}

	class SeedComparator implements Comparator<DetailPageSeed> {
		@Override
		public int compare(DetailPageSeed o1, DetailPageSeed o2) {
			String u = o1.getUrl();
			String u2 = o2.getUrl();
			return u.compareTo(u2);
		}

	}

	private void setNextFetchTime(Host cur) {
		try {
			long interval = cur.getUpdateFrequency();
			Date nextFetchTime = new Date(new Date().getTime() + interval);
			cur.setNextFetchTime(nextFetchTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @Description:获取 待抓取时间早于当前时间的种子
	 * @author zhangjie
	 * @date 2016年1月6日 上午10:29:14
	 *
	 */
	private CopyOnWriteArrayList<Host> getOutTimeSeed() {
		return seeds.removeOutTimeSeed(new Date());
	}

}
