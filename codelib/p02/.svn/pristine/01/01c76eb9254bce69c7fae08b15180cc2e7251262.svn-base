package cn.innohub.crawler.crawl.fetch.strategy;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.beans.DetailPageSeed;
import cn.innohub.crawler.common.beans.HtmlText;
import cn.innohub.crawler.common.utils.HttpClientFetcher;

/**
 * @ClassName: HttpclientFetchStrategy
 * @Description: 使用Httpunit抓取网页
 * @author zhangjie
 * @date 2015年12月31日 下午1:37:50
 *
 */
public class HttpClientFetchStrategy extends FetchStrategy {
	private Logger logger = Logger.getLogger(HttpClientFetchStrategy.class);
	@Override
	public void fetchStrategy(DetailPageSeed detailPageSeed, CrawlDatum crawlDatum) {
		
		String url = detailPageSeed.getUrl();
		String htmlContent = HttpClientFetcher.fetchHtmlContent(url);
		if (crawlDatum instanceof HtmlText) {
			HtmlText htmlText = (HtmlText) crawlDatum;
			logger.debug("set htmlContent to HtmlText instance >> " + url);
			htmlText.setHtmlContent(htmlContent);
			htmlText.setUrl(url);
			htmlText.setDetailId(detailPageSeed.getDetailId());
		}
	
	}
}