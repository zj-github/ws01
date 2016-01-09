package cn.iktz.p01.service;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.iktz.p01.beans.Constant;
import cn.iktz.utils.ImgUtil;
import cn.iktz.utils.JedisPoolUtil;
import cn.iktz.utils.MD5Util;

public class URLService {

	
	public static void acceptUrl(String url) throws Exception{
		Document doc = Jsoup.connect(url).get();
		
		String title = doc.title();
		String h2 = doc.select("h2.rich_media_title").text();
		
		
		Elements contentElement = doc.select("div.rich_media_content");
		String content = contentElement.html();
		
		
		Elements select = contentElement.select("img[data-src]");
		for (Element element : select) {
			String imgsrc = element.attr("data-src");
			String imgfmt = imgsrc.substring(imgsrc.indexOf("?wx_fmt=")).trim();
			try {
				Map<String,String> imgmap = new HashMap<>();
				imgmap.put("imgbytearr", ImgUtil.down(imgsrc));
				imgmap.put("imgurl",imgsrc);
				imgmap.put("arturl",url);
				imgmap.put("imgfmt",imgfmt);
				String encoderByMd5 = MD5Util.encoderByMd5(imgsrc);
				content = content.replace(imgsrc, "/img/"+encoderByMd5);
				System.out.println("save img >> "+imgsrc);
				JedisPoolUtil.set(Constant.IMG_KEY+encoderByMd5, imgmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String biz  = url.substring(url.indexOf("__biz=")+6, url.indexOf("&mid="));
		String sn = url.substring(url.indexOf("&sn=")+4,url.indexOf("&scene="));
		
		Map<String,String> m = new HashMap<>();
		m.put("h2",h2);
		m.put("biz",biz);
		m.put("sn",sn);
		m.put("title",title);
		m.put("content",content);
		System.out.println(url);
		JedisPoolUtil.set(Constant.ART_KEY, m);
	}
	public static void acceptUrl(String ...urls){
		for (String url : urls) {
			try {
				acceptUrl(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void saveimg(Element contentElement,String imgurl,String arturl){
		
	}
	
}
