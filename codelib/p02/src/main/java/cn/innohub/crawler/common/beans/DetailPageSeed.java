package cn.innohub.crawler.common.beans;

import java.io.Serializable;

/**
 * @ClassName: DetailPageSeed
 * @Description: 详情页种子
 * @author zhangjie
 * @date 2015年12月31日 下午5:58:10
 *
 */
public class DetailPageSeed implements Serializable {

	private static final long serialVersionUID = 1163646469094121601L;
	private String url;// 种子
	private String detailId;

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	@Override
	public String toString() {
		return "DetailPageSeed [url=" + url + "]";
	}

	public DetailPageSeed() {
	}

	public DetailPageSeed(String url, String detailId) {
		this.url = url;
		this.detailId = detailId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
