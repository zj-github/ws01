package cn.innohub.crawler.conf.readxml;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: FirstLevelSeed
 * @Description: 一级种子：列表页
 * @author zhangjie
 * @date 2016年1月5日 上午9:34:52
 *
 */
public class Host implements Serializable{

	private static final long serialVersionUID = -4497653551732040362L;

	@Override
	public int hashCode() {
		return url.hashCode();
	};

	@Override
	public boolean equals(Object obj) {
		return (this .equals(obj));
	};
	
	private String name;
	private String url;
	private String detailPageReg;
	private long updateFrequency;
	private Date nextFetchTime;// 下次抓取时间
	private boolean shouldIndex;// 是否提交索引
	private boolean shouldStorage;// 是否存储
	private String listPageFetchTool;// 使用的抓取工具插件
	private String detailUrlFetchTool;// 详情页使用的抓取插件

	
	
	@Override
	public String toString() {
		return "Host [name=" + name + ", url=" + url + ", detailPageReg=" + detailPageReg + ", updateFrequency="
				+ updateFrequency + ", nextFetchTime=" + nextFetchTime +
				  "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDetailPageReg() {
		return detailPageReg;
	}

	public void setDetailPageReg(String detailPageReg) {
		this.detailPageReg = detailPageReg;
	}

	public long getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(long updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public Date getNextFetchTime() {
		return nextFetchTime;
	}

	public void setNextFetchTime(Date nextFetchTime) {
		this.nextFetchTime = nextFetchTime;
	}

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
	
	

}