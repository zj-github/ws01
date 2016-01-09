package cn.innohub.crawler.common.beans;

public class HtmlText extends CrawlDatum {

	public HtmlText(){
	}
	public HtmlText(String url,String htmlContent){
		this.htmlContent = htmlContent;
		this.url = url;
	}
	private String htmlContent;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HtmlText(String htmlContent){
		this.htmlContent = htmlContent;
	}
	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	
}
