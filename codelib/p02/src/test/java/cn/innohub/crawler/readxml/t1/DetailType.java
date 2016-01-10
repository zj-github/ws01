package cn.innohub.crawler.readxml.t1;

import java.util.Map;

class DetailType{
	private String urlreg;
	private String tablename;
	private Map<String,String> fields;
	public String getUrlreg() {
		return urlreg;
	}
	
	public void setUrlreg(String urlreg) {
		this.urlreg = urlreg;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getField(String key) {
		return fields.get(key);
	}
	public void setField(String key,String value) {
		this.fields.put(key, value);
	}
	
}