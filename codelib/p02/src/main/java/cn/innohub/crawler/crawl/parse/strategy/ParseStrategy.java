package cn.innohub.crawler.crawl.parse.strategy;

import cn.innohub.crawler.common.beans.CrawlDatum;

public abstract class ParseStrategy {
	public abstract Object parseStrategy(CrawlDatum crawlDatum);
}