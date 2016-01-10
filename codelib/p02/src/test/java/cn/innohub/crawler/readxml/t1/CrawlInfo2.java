package cn.innohub.crawler.readxml.t1;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CrawlInfo2 {

	private String host;
	private String url;
	private String updatefrequency;
	private Map<String, DetailType> detailTypes;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUpdatefrequency() {
		return updatefrequency;
	}

	public void setUpdatefrequency(String updatefrequency) {
		this.updatefrequency = updatefrequency;
	}

	public DetailType getDetailTypes(String key) {
		return detailTypes.get(key);
	}

	public void setDetailTypes(String key, DetailType value) {
		this.detailTypes.put(key, value);
	}

	public Map<String, DetailType> getDetailTypes() {
		return detailTypes;
	}

	public void setDetailTypes(Map<String, DetailType> detailTypes) {
		this.detailTypes = detailTypes;
	}

}
