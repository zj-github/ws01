package cn.innohub.crawler.crawl.parse.strategy;

import java.lang.reflect.Field;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import cn.innohub.crawler.common.beans.CrawlDatum;
import cn.innohub.crawler.common.beans.ExtractField;
import cn.innohub.crawler.common.beans.ExtractRule;
import cn.innohub.crawler.common.beans.HtmlText;
import cn.innohub.crawler.common.beans.TextNode;
import cn.innohub.crawler.common.beans.innohub.CCFAProjectInfo;
import cn.innohub.crawler.core.Context;

/**
 * @ClassName: JsoupParseStrategy
 * @Description: 使用Jsoup解析html,获取对应的数据
 * @author zhangjie
 * @date 2016年1月4日 上午9:15:21
 */
public class JsoupParseStrategy extends ParseStrategy {
	private Logger logger = Logger.getLogger(JsoupParseStrategy.class);

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
		//1、根据域名获取对应的抽取规则
		//2、抽取网页中对应的字段信息
		//3、将抽取到的字段信息封装成对象，return。
		
		HtmlText ht = (HtmlText) crawlDatum;
		String htmlContent = ht.getHtmlContent();
		Document doc = Jsoup.parse(htmlContent);
		Object o = null;
		try {
			URL url = null;
			Class<?> clazz = null;
			if (StringUtils.isNotEmpty(ht.getUrl())) {
				url = new URL(ht.getUrl());
			}
			String hostName = url.getHost();
			
			// 根据域名获取ExtractRule
			ExtractRule rule = this.getRule(hostName);

			clazz = Class.forName(rule.getClazz());
			o = clazz.newInstance();
//			System.out.println(htmlContent);
			for (ExtractField extractField : rule.getFields()) {
				
				TextNode txt = extractField.getTxt();
				String element = txt.getElement();
				String attr = txt.getAttr();
				Elements e = doc.select(element);
				String text = "";
				
				if(StringUtils.isNotEmpty(attr)){//目标是元素的属性
					text = e.attr(attr);
				}else{//目标是元素
					if (e.hasText()) {
						text = e.text();// 获取节点的文本内容
					}	
				}
				
				String name = extractField.getName();
				try {
					Field field = clazz.getDeclaredField(name);
					field.setAccessible(true);
					field.set(o, text);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			CCFAProjectInfo i = (CCFAProjectInfo)o;
			logger.info(url+"  "+i.toString());
		} catch (Exception e2) {
			logger.warn("parse bean failed");
			e2.printStackTrace();
		}
		return o;
	}

	private ExtractRule getRule(String hostName) {
		return Context.getInstance().getRule(hostName);
	}
}