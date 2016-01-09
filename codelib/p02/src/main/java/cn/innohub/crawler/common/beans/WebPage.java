package cn.innohub.crawler.common.beans;

import java.io.Serializable;

public class WebPage implements Serializable{
	private static final long serialVersionUID = 864741710642688244L;
	
	public WebPage(String url,String htmlContent) {
		this.url = url;
		this.htmlContent= htmlContent;
	}
	
	private String url;//该网页的url
	private String htmlContent;//该网页的完整的html内容
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHtmlContent() {
		return htmlContent;
	}
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
}
