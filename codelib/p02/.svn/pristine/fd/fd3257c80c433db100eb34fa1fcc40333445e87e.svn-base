package cn.innohub.crawler.parse.innohub;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupParseTest {

	public static void main(String[] args) throws Exception {
		String url = "http://www.innohub.net/sciencemarket/article/detail.html?id=226";
		Document doc = Jsoup.connect(url).get();
		// <h1 class="fw16" style="color: #000000; font-size: 16px; font-weight:
		// 900;"> 国内问世“仿真A320飞机乘务训练舱”进入世界前列 </h1>

		// String html = doc.html();
		// System.out.println(html);

		Elements select = doc.select("h1.fw16");

		System.out.println(select.html());
	}

	@Test
	public void test() {

		String html = "<div class=\"details-top-l\"><div class=\"details-l-img\"><img src=\"http://img2.renrentou.com/s/upload/project/2015/1222/0a349507707b74327adcae83f47e905d.jpg\" alt=\"锐恩英语绿宝广场店\"></div></div>";
		Document doc = Jsoup.parse(html);
		Elements e = doc.select("div.details-l-img > img[src]");
		System.out.println(e.attr("src"));
	}

	/**
	 * 
	 * @Description: 测试@符号
	 * @author zhangjie
	 * @date 2016年1月7日 上午11:44:52
	 *
	 */
	@Test
	public void test2() {
		String html = "<div class=\"attention-list\">" + "<p class=\"attention-p\"><i>项目地点：</i>四川省成都</p>"
				+ "<p class=\"attention-p\"><i>一句话介绍：</i>小餐饮·大梦想；一起来·更强大</p>" + "</div>";

		Document doc = Jsoup.parse(html);
		Elements e = doc.select("div.attention-list > p@0");

		System.out.println(e.text());
	}

	/**
	 * 
	 * @Description: 测试$符号
	 * @author zhangjie
	 * @date 2016年1月7日 上午11:19:12
	 *
	 */
	@Test
	public void testD() {
		String html = "<div class=\"attention-list\">" + "<p class=\"attention-p\"><i>项目地点：</i>四川省成都</p>" + "</div>";

		Document doc = Jsoup.parse(html);

		Elements e = doc.select("div.attention-list > p $1");

		System.out.println(e.text());
	}
	@Test
	public void test7() {
		String url = "http://www.renrentou.com/project/detail/project_id/15350";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements e = doc.select("dl.attention-dl>dd>b");
			System.out.println(e.text());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		String reg = "div.attention-list > p @ 1";
		int indexOf = reg.indexOf("@");
		String substring = reg.substring(indexOf + 1);
		System.out.println(substring.trim());
		System.out.println(indexOf);
	}

	@Test
	public void test5() {
		//@:取第几个元素
		//$：表示要取得是文本节点，并且标示了文本节点相对父节点所有点的索引
//		String reg = "div.attention-list > p @ 1 $1";
		String reg = "div.attention-list > p @3 ";
//		Pattern p = Pattern.compile(".*(\\@ *([0-9]{1}) *)");
		Pattern p = Pattern.compile(".*(\\@)([0-9]{1}) *(\\$) *([0-9]{1})");
		Matcher m = p.matcher(reg);
		while(m.find()){
//			for(int i=0;i<m.groupCount();i++){
//				System.out.println(m.group(i));
//			}
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
			System.out.println(m.group(3));
			System.out.println(m.group(4));
			System.out.println(m.group(5));
			System.out.println(m.group(6));
		}
		
	}
	public void test6(){
		String reg = "div.attention-list > p @3 ";
		
		
	}

}
