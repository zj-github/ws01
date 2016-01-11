package cn.innohub.crawler.common.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: FirstLevelSeed
 * @Description: 一级种子：列表页
 * @author zhangjie
 * @date 2016年1月5日 上午9:34:52
 *
 */
public class Host implements Serializable{
	@Override
	public boolean equals(Object dps) {
		return this.getFeatures().equals(((Host) dps).getFeatures());
	}

	public String getFeatures(){
		return url+updateFrequency+detailPageReg+shouldIndex+shouldStorage+childDetailUrlNum+listPageFetchTool+detailUrlFetchTool;
	}
	private static final long serialVersionUID = -4497653551732040362L;

	public Host() {
	}

	public Host( int updateFrequency) {
		this.updateFrequency = updateFrequency;
	}
	
	public Host(String url, int updateFrequency, String detailPageUrlDigest, boolean shouldStorage) {
		this.url = url;
		this.updateFrequency = updateFrequency;
		this.detailPageReg = detailPageUrlDigest;
		this.shouldIndex = shouldStorage;
	}

	private String type;
	private String url;
	private long updateFrequency;
	private Date lastModifyTime;// 最后更新时间
	private Date lastFetchTime;// 最后更新时间
	private Date nextFetchTime;// 下次抓取时间
	private String detailPageUrlDigest;// 上次抽取的列表页url的签名值// （拼接所有url转换成一个String文本，使用md5获取签名）
	private List<String> detailUrlList;// 上次抽取的详情页外链集合
	private String detailPageReg;// 抽取规则
	private boolean shouldIndex;// 是否提交索引
	private boolean shouldStorage;// 是否存储
	private int childDetailUrlNum;// 详情页数据限制
	private String listPageFetchTool;// 使用的抓取工具插件
	private String detailUrlFetchTool;// 详情页使用的抓取插件

	public String getDetailPageReg() {
		return detailPageReg;
	}

	public void setDetailPageReg(String detailPageReg) {
		this.detailPageReg = detailPageReg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(long updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Date getNextFetchTime() {
		return nextFetchTime;
	}

	public void setNextFetchTime(Date nextFetchTime) {
		this.nextFetchTime = nextFetchTime;
	}

	public String getDetailPageUrlDigest() {
		return detailPageUrlDigest;
	}

	public void setDetailPageUrlDigest(String detailPageUrlDigest) {
		this.detailPageUrlDigest = detailPageUrlDigest;
	}

	public List<String> getDetailUrlList() {
		return detailUrlList;
	}

	public void setDetailUrlList(List<String> detailUrlList) {
		this.detailUrlList = detailUrlList;
	}

	// public List<ExtractRule> getExtractRule() {
	// return extractRule;
	// }
	// public void setExtractRule(List<ExtractRule> extractRule) {
	// this.extractRule = extractRule;
	// }
	public boolean isShouldIndex() {
		return shouldIndex;
	}

	public void setShouldIndex(boolean shouldIndex) {
		this.shouldIndex = shouldIndex;
	}

	public boolean isShouldStorage() {
		return shouldStorage;
	}

	public void setShouldStorage(boolean shouldStorage) {
		this.shouldStorage = shouldStorage;
	}

	public int getChildDetailUrlNum() {
		return childDetailUrlNum;
	}

	public void setChildDetailUrlNum(int childDetailUrlNum) {
		this.childDetailUrlNum = childDetailUrlNum;
	}

	public String getListPageFetchTool() {
		return listPageFetchTool;
	}

	public void setListPageFetchTool(String listPageFetchTool) {
		this.listPageFetchTool = listPageFetchTool;
	}

	public String getDetailUrlFetchTool() {
		return detailUrlFetchTool;
	}

	public void setDetailUrlFetchTool(String detailUrlFetchTool) {
		this.detailUrlFetchTool = detailUrlFetchTool;
	}

	public Date getLastFetchTime() {
		return lastFetchTime;
	}

	public void setLastFetchTime(Date lastFetchTime) {
		this.lastFetchTime = lastFetchTime;
	}

	@Override
	public String toString() {
		return " [url=" + url + ", detailPageReg=" + detailPageReg + "]";
	}

}
