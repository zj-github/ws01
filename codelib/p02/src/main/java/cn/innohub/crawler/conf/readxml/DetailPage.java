package cn.innohub.crawler.conf.readxml;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DetailPage implements Serializable {
	private static final long serialVersionUID = 1447187137776999799L;
	private String reg;
	private String tablename;
	private String id;
	private String responseClazz;
	private Map<String, String> fields;
	
	public DetailPage() {
		fields= new ConcurrentHashMap<>();
	}
	
	@Override
	public String toString() {
		return "\n DetailPage : "+ id
				+ "\n reg=" + reg + "\n tablename=" + tablename + "\n responseClazz=" + responseClazz
				+ " \n fields=" + fields ;
	}

	public String getResponseClazz() {
		return responseClazz;
	}

	public void setResponseClazz(String responseClazz) {
		this.responseClazz = responseClazz;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	public void setField(String columnname, String element) {
		this.fields.put(columnname, element);
	}

}