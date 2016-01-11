package cn.innohub.crawler.crawl.parse.strategy;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.beans.FieldBean;
import cn.innohub.crawler.common.beans.HtmlText;
import cn.innohub.crawler.conf.readxml.DetailPage;
import cn.innohub.crawler.core.Context;
import cn.innohub.crawler.core.QueueManager;

/**
 * @ClassName: JsoupParseStrategy
 * @Description: 使用Jsoup解析html,获取对应的数据
 * @author zhangjie
 * @date 2016年1月4日 上午9:15:21
 */
public class JsoupParseStrategy extends ParseStrategy {
	private Logger logger = Logger.getLogger(JsoupParseStrategy.class);

	Pattern p = Pattern.compile("a*b");

	/**
	 * 解析组件的策略方法。 将HtmlText对象中的 HtmlContent中的对应的字段抽取出来。
	 */
	@Override
	public Object parseStrategy(CrawlDatum crawlDatum) {
		if (crawlDatum instanceof HtmlText) {
			return parse(crawlDatum);
		}
		return null;
	}

	private Object parse(CrawlDatum crawlDatum) {
		// 1、根据域名获取对应的抽取规则
		// 2、抽取网页中对应的字段信息
		// 3、将抽取到的字段信息封装成对象，return。

		HtmlText ht = (HtmlText) crawlDatum;
		String htmlContent = ht.getHtmlContent();
		Document doc = Jsoup.parse(htmlContent);
		try {
			
			String detailId = ht.getDetailId();
			DetailPage detailPage = Context.getInstance().getDetailPage(detailId);
			
			Map<String, String> fields = detailPage.getFields();
			FieldBean fb = new FieldBean();
			fb.setTableName(detailPage.getTablename());
			fb.setDetailId(detailId);
			
			for (Entry<String, String> en : fields.entrySet()) {
				String column = en.getKey();
				
				String reg = en.getValue();
				
				Elements select = doc.select(reg);//
				String value = select.text();
				logger.info(" reg : "+reg +" value : "+value );
				fb.add(column, value);
			}
			QueueManager.add(fb);
			return fb;
		} catch (Exception e2) {
			logger.warn("parse bean failed");
			e2.printStackTrace();
		}
		return null;
		
	}


}