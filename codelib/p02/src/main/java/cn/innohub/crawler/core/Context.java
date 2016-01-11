package cn.innohub.crawler.core;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import cn.innohub.crawler.common.api.SafeTreeSet;
import cn.innohub.crawler.conf.readxml.DetailPage;
import cn.innohub.crawler.conf.readxml.Host;
import cn.innohub.crawler.conf.readxml.SeedComparator;

public class Context {
	private Date seedsXMLLastModify;
	private ConcurrentHashMap<String,DetailPage> detailPages;
	private SafeTreeSet firstLevelSeedSet;

	/** 单例部分 start */
	private static Context context = new Context();
	private Context() {
		detailPages=new ConcurrentHashMap<>();
		firstLevelSeedSet = new SafeTreeSet(new SeedComparator());
	}
	public static Context getInstance() {
		return context;
	}
	/** 单例部分 end */
	
	public void addFirstLevelSeed(Host firstLevelSeed) {
		firstLevelSeedSet.add(firstLevelSeed);
	}
	public SafeTreeSet getFirstLevelSeeds() {
		return firstLevelSeedSet;
	}
	public void setSeedsXMLLastModify(Date seedsXMLLastModify) {
		this.seedsXMLLastModify = seedsXMLLastModify;
	}
	public Date getSeedsXMLLastModify() {
		return seedsXMLLastModify;
	}
	public ConcurrentHashMap<String,DetailPage> getDetailPages() {
		return detailPages;
	}
	public void setDetailPage(String key, DetailPage detailPages) {
		this.detailPages.put(key, detailPages);
	}
	public DetailPage getDetailPage(String key) {
		return this.detailPages.get(key);
	}
	

}
