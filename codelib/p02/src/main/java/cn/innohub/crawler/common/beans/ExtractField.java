package cn.innohub.crawler.common.beans;

public class ExtractField {
	private String name;// 此规则的名称
	private String method;// 调用哪个类.方法 //默认为Jsoup的select
	private TextNode txt;
	
	public TextNode getTxt() {
		return txt;
	}
	public void setTxt(TextNode txt) {
		this.txt = txt;
	}
	public ExtractField() {
	}
	public ExtractField(String name,String method,TextNode txt) {
		this.name = name;
		this.method = method;
		this.txt = txt;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ExtractField [name=" + name + ", method=" + method + ", txt=" + txt + "]";
	}
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
