package cn.innohub.crawler.readxml.t1;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CrawlInfo {

	private String host;
	private String url;
	private String updatefrequency;
	private List<DetailType> detailTypes;
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
	public List<DetailType> getDetailTypes() {
		return detailTypes;
	}
	public void setDetailTypes(List<DetailType> detailTypes) {
		this.detailTypes = detailTypes;
	}


}
