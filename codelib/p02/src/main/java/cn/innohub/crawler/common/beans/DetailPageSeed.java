package cn.innohub.crawler.common.beans;

import java.io.Serializable;

/**
 * @ClassName: DetailPageSeed
 * @Description: 详情页种子
 * @author zhangjie
 * @date 2015年12月31日 下午5:58:10
 *
 */
public class DetailPageSeed implements Serializable{

	private static final long serialVersionUID = 1163646469094121601L;
	private String url;// 种子
	private String responseClazz;// 抓取后返回的类。
	
	@Override
	public String toString() {
		return "DetailPageSeed [url=" + url + ", responseClazz=" + responseClazz + "]";
	}
	public DetailPageSeed( ){
	}
	public DetailPageSeed(String url,String responseClazz){
		this.url = url;
		this.responseClazz = responseClazz;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponseClazz() {
		return responseClazz;
	}

	public void setResponseClazz(String responseClazz) {
		this.responseClazz = responseClazz;
	}

}