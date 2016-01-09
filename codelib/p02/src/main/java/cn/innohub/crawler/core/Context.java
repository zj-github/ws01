package cn.innohub.crawler.core;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.innohub.crawler.common.api.SafeTreeSet;
import cn.innohub.crawler.common.beans.ExtractRule;
import cn.innohub.crawler.common.beans.FirstLevelSeed;
import cn.innohub.crawler.crawl.firstlevel.seeds.extract.SeedComparator;

public class Context {
	/** 单例部分 start */
	private static Context context = new Context();
	private Map<String, String> columnMapping;

	private Context() {
		columnMapping = new ConcurrentHashMap<>();
		params = new ConcurrentHashMap<>();
		firstLevelSeedSet = new SafeTreeSet(new SeedComparator());
		init();
	}

	public Map<String, String> getColumnMapping() {
		return columnMapping;
	}

	public void setColumnMapping(Map<String, String> columnMapping) {
		this.columnMapping = columnMapping;
	}

	private ConcurrentHashMap<Object, Object> params;

	public ConcurrentHashMap<Object, Object> getParams() {
		return params;
	}

	public static Context getInstance() {
		return context;
	}

	public void setParam(String key, String value) {
		params.put(key, value);
	}

	public long getLongParams(String key) {
		return (long) params.get(key);
	}

	/** 单例部分 end */

	public void init() {
		// params.put(InitParamsConstant.DEFAULT_INTERVAL, 2 * 60 * 60 *
		// 1000);// 设置默认的一级种子抓取间隔2小时
		// (2*60*60*1000)
	}

	private Date seedsXMLLastModify;

	public void setSeedsXMLLastModify(Date seedsXMLLastModify) {
		this.seedsXMLLastModify = seedsXMLLastModify;
	}

	public Date getSeedsXMLLastModify() {
		return seedsXMLLastModify;
	}

	/**
	 * 一级种子集合 start
	 */
	private SafeTreeSet firstLevelSeedSet;

	public void addFirstLevelSeed(FirstLevelSeed firstLevelSeed) {
		firstLevelSeedSet.add(firstLevelSeed);
	}

	public SafeTreeSet getFirstLevelSeeds() {
		return firstLevelSeedSet;
	}
	/**
	 * 一级种子集合 end
	 */

	/**
	 * 抽取规则 start
	 */
	private ConcurrentHashMap<String, ExtractRule> ruleMap = new ConcurrentHashMap<>(); // 抽取规则

	/**
	 * @Description: 读取xml fields-extract-reg 封装成对象，放入ruleMap中
	 * @author zhangjie
	 * @date 2016年1月4日 下午1:52:19
	 */
	public void addRule(String hostName, ExtractRule extractRule) {
		ruleMap.put(hostName, extractRule);
	}

	public ExtractRule getRule(String hostName) {
		return ruleMap.get(hostName);
	}

	public ConcurrentHashMap<String, ExtractRule> getRuleMap() {
		return ruleMap;
	}

	/**
	 * 抽取规则 end
	 */
	public Object getParam(String key) {
		return params.get(key);
	}
}
