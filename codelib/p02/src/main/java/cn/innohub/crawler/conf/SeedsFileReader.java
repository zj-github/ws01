package cn.innohub.crawler.conf;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.innohub.crawler.common.FileNameConstant;
import cn.innohub.crawler.common.api.SafeTreeSet;
import cn.innohub.crawler.common.beans.FirstLevelSeed;
import cn.innohub.crawler.common.utils.Dom4JUtil;
import cn.innohub.crawler.common.utils.Path;
import cn.innohub.crawler.core.Context;
import cn.innohub.crawler.core.ThreadLockController;

/**
 * @ClassName: SeedsFileReader
 * @Description: 读取种子文件
 * @author zhangjie
 * @date 2016年1月5日 上午9:00:47
 *
 */
public class SeedsFileReader {
	public static void main(String[] args) {
		new SeedsFileReader().update();
		SafeTreeSet firstLevelSeeds = Context.getInstance().getFirstLevelSeeds();
		Iterator<FirstLevelSeed> iterator = firstLevelSeeds.iterator();
		while(iterator.hasNext()){
			FirstLevelSeed next = iterator.next();
			System.out.println(next);
		}
	}
	// private Logger logger = Logger.getLogger(SeedsFileReader.class);

	public void update() {
		Context.getInstance().getFirstLevelSeeds().clear();
		String xmlFilePath = Path.getClassPath() + FileNameConstant.FIRST_LEVEL_SEEDS_XML;
		if (isUpdate(xmlFilePath)) {
			readFirstLevelSeedsXml(xmlFilePath);
		}
	}

	/**
	 * @Description: 1、判断种子文件是否更新
	 * @author zhangjie
	 * @date 2016年1月5日 上午10:27:59
	 * @param xmlFilePath
	 * @return
	 * @throws Exception
	 *
	 */
	private boolean isUpdate(String xmlFilePath) {
		// String xmlFilePath = Path.getClassPath() + "fields-extract-reg.xml";
		File f = new File(xmlFilePath);
		if (f.exists()) {
			Date seedsXMLLastModify = Context.getInstance().getSeedsXMLLastModify();// seedsxml的最后修改时间
			if (seedsXMLLastModify == null || seedsXMLLastModify.getTime() != f.lastModified()) {
				return true;
			}
		} else {
			throw new RuntimeException("file not exists");
		}
		return false;
	}

	/**
	 * 
	 * @Description: 2、读取种子文件中的种子，封装成对象，存入上下文中
	 * @author zhangjie
	 * @date 2016年1月5日 上午10:28:21
	 * @param fileName
	 * @return
	 *
	 */
	private void readFirstLevelSeedsXml(String xmlFilePath) {
		loadFirstLevelSeedsXml(xmlFilePath);
	}

	private void loadFirstLevelSeedsXml(String xmlFilePath) {

		try {
			Document doc = Dom4JUtil.getDocument(xmlFilePath);

			/** 1、读取host节点 */
			@SuppressWarnings("unchecked")
			List<Element> seedNodeList = doc.selectNodes("/first-level-seeds/seed");

			for (Element rule : seedNodeList) {
				FirstLevelSeed firstLevelSeed = new FirstLevelSeed();

				Node urlNode = rule.selectSingleNode("url");
				Node updateFrequencyNode = rule.selectSingleNode("updatefrequency");
				Node detailPageRuleNode = rule.selectSingleNode("detailpagerule");
				Node storagedNode = rule.selectSingleNode("storaged");
				
				String url = this.getText(urlNode);
				firstLevelSeed.setUrl(url);
				int interval = Integer.parseInt(this.getText(updateFrequencyNode));
				firstLevelSeed.setUpdateFrequency(interval);
//				firstLevelSeed.setNextFetchTime(new Date(new Date().getTime()+interval));
				firstLevelSeed.setDetailPageReg(this.getText(detailPageRuleNode));
				firstLevelSeed.setShouldStorage(Boolean.parseBoolean(this.getText(storagedNode)));
				this.addSeeds(firstLevelSeed);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getText(Node node) {
		return node.getText().trim();
	}

	/**
	 * 
	 * @Description: 新增一级种子。 遍历firstLevelSeedSet， 如果不存在，加入
	 *               如果存在了，判断是否更新，若更新了，删掉原来的，加入新的
	 * 
	 * @author zhangjie
	 * @date 2016年1月6日 上午9:41:02
	 * @param url
	 * @param firstLevelSeed
	 *
	 */
	private void addSeeds(FirstLevelSeed firstLevelSeed) {
		SafeTreeSet set = Context.getInstance().getFirstLevelSeeds();
		set.add(firstLevelSeed);
		ThreadLockController.getInstance().signalFirstLevelSeedExtractThread();
//		String url = firstLevelSeed.getUrl();
//		FirstLevelSeed existSeed = set.exist(url);
//		
//		if(existSeed==null){
//			
//		}else{
//			//如果更新了，则删除旧的，添加新的
//			if(!firstLevelSeed.getFeatures().equals(existSeed.getFeatures())){
//				set.remove(existSeed);
//				set.add(firstLevelSeed);
//			}
//		}
	}
//	private void addSeeds(FirstLevelSeed firstLevelSeed) {
//		SafeTreeSet set = Context.getInstance().getFirstLevelSeeds();
//		String url = firstLevelSeed.getUrl();
//		FirstLevelSeed existSeed = set.exist(url);
//		if(existSeed==null){
//			set.add(firstLevelSeed);
//		}else{
//			//如果更新了，则删除旧的，添加新的
//			if(!firstLevelSeed.getFeatures().equals(existSeed.getFeatures())){
//				set.remove(existSeed);
//				set.add(firstLevelSeed);
//			}
//		}
//	}


}
