package cn.innohub.crawler.crawl.fetch.strategy;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.beans.DetailPageSeed;

public abstract class FetchStrategy {
	public abstract void fetchStrategy(DetailPageSeed detailPageSeed,CrawlDatum crawlDatum);
}
