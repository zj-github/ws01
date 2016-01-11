package cn.innohub.crawler.conf.readxml;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

import cn.innohub.crawler.common.api.SafeTreeSet;
import cn.innohub.crawler.common.utils.Dom4JUtil;
import cn.innohub.crawler.common.utils.Path;
import cn.innohub.crawler.core.Context;
import cn.innohub.crawler.crawl.fetch.FetcherCommonImpl;

public class XMLReader {
	private Logger logger = Logger.getLogger(FetcherCommonImpl.class);
	public static void main(String[] args) throws Exception {
		new XMLReader().loadXML();
	}

	public void loadXML() {
		ConcurrentHashMap<String, DetailPage> detailPages = Context.getInstance().getDetailPages();
		detailPages.clear();
		SafeTreeSet firstLevelSeeds = Context.getInstance().getFirstLevelSeeds();
		firstLevelSeeds.clear();

		readXML();
		
		Iterator<Host> iterator = firstLevelSeeds.iterator();
		while(iterator.hasNext()){
			Host next = iterator.next();
			logger.info(" load conf >>  * " + next);
		}
		
		for (Entry<String, DetailPage> en : detailPages.entrySet()) {
			DetailPage value = en.getValue();
			logger.info(" * load conf >> " + value.toString());
		}
	}

	public void readXML() {
		try {
			String xmlFilePath = Path.getClassPath() + "crawlinfo.xml";
			System.out.println("crawlinfo.xml path " +xmlFilePath);
			// 1、封装host
			Document doc = Dom4JUtil.getDocument(xmlFilePath);

			@SuppressWarnings("unchecked")
			List<Element> seedNodeList = doc.selectNodes("/crawlinfo/host");

			for (Element hostElement : seedNodeList) {
				String name = hostElement.attribute("name").getValue();
				String url = hostElement.attribute("url").getValue();

				/** 1、封装host */
				Host host = new Host();
				host.setName(name);
				host.setUrl(url);
				String updatefrequency = hostElement.selectSingleNode("updatefrequency").getText();
				host.setUpdateFrequency(Long.parseLong(updatefrequency) * 1000);
				@SuppressWarnings("unchecked")
				List<Element> selectNodes = hostElement.selectNodes("detailpage");

				for (Element e : selectNodes) {

					String reg = e.attribute("reg").getValue();
					String id = e.attribute("id").getValue();
					// regGlobal += "(" + reg + ")|";

					/** 2、封装DetailPage start */
					DetailPage detailPage = new DetailPage();
					detailPage.setReg(reg);
					detailPage.setId(id);
					Node tableNameNode = e.selectSingleNode("tablename");
					detailPage.setTablename(tableNameNode.getText());

					@SuppressWarnings("unchecked")
					List<Element> selectNodes2 = e.selectNodes("fields/field");
					for (Element element : selectNodes2) {
						String columnname = element.selectSingleNode("columnname").getText();
						String element1 = element.selectSingleNode("element").getText();
						Node clazz = element.selectSingleNode("responseClazz");
						String responseClazz = "";
						if (clazz != null) {
							responseClazz = clazz.getText();
						}else{
							responseClazz="cn.innohub.crawler.common.beans.HtmlText";
						}
						detailPage.setResponseClazz(responseClazz);
						detailPage.setField(columnname, element1);
					}

					Context.getInstance().getDetailPages().put(id, detailPage);
					/** 2、封装DetailPage end */
				}
				Context.getInstance().getFirstLevelSeeds().add(host);// 添加host
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		String reg = "(.+www\\.baidu\\.com)|(.+www\\.163\\.com)|";
		reg = reg.substring(0, reg.length() - 1);
		System.out.println(reg);
		System.out.println("http://www.163.com".matches(reg));
	}

}
