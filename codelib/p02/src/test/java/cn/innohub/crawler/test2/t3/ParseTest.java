package cn.innohub.crawler.test2.t3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.innohub.crawler.crawl.fetch.FetchThreadContext;
import cn.innohub.crawler.crawl.firstlevel.seeds.extract.FisrtLevelSeedThreadContext;
import cn.innohub.crawler.crawl.parse.ParseThreadContext;

/**
 * @ClassName: FetchThreadContext
 * @Description: 启动线程池
 * @author zhangjie
 * @date 2015年12月31日 下午4:15:06
 */
public class ParseTest {

	public static void main(String[] args) {

		try {
			Class.forName("cn.innohub.crawler.conf.ConfigurationLoader");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new FisrtLevelSeedThreadContext().fetch();
		new FetchThreadContext().fetch();
		new ParseThreadContext().parse();
		long d = 0;
		while(true){
			try {
				Thread.sleep(10000);
				d+=10000;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(d+"^^^^^^^^^^^^^^^^^^^");
		}
	}
	
	@Test
	public void test(){
		String u="http://www.renrentou.com/project/detail/project_id/16106";
		String u1="http://www.renrentou.com/project/detail/project_id/16106";
//		String u2="http://www.renrentou.com/project/detail/project_id/15301";
//		String u3="http://www.renrentou.com/project/detail/project_id/15301";
//		String u4="http://www.renrentou.com/project/detail/project_id/15293";
//		String u5="http://www.renrentou.com/project/detail/project_id/15293";
//		String u6="http://www.renrentou.com/project/detail/project_id/15296";
//		String u7="http://www.renrentou.com/project/detail/project_id/15296";
//		String u8="http://www.renrentou.com/project/detail/project_id/15350";
//		String u9="http://www.renrentou.com/project/detail/project_id/15350";
//		String u10="http://www.renrentou.com/project/detail/project_id/15930";
//		String u11="http://www.renrentou.com/project/detail/project_id/15930";
//		String u12="http://www.renrentou.com/project/detail/project_id/16429";
//		String u13="http://www.renrentou.com/project/detail/project_id/16429";
//		String u14="http://www.renrentou.com/project/detail/project_id/16379";
//		String u15="http://www.renrentou.com/project/detail/project_id/16379";
//		String u16="http://www.renrentou.com/project/detail/project_id/16240";
//		String u17="http://www.renrentou.com/project/detail/project_id/16240";
//		String u="http://www.renrentou.com/project/detail/project_id/15056";
//		String u="http://www.renrentou.com/project/detail/project_id/15056";
//		String u="http://www.renrentou.com/project/detail/project_id/14626";
//		String u="http://www.renrentou.com/project/detail/project_id/14626";
//		String u="http://www.renrentou.com/project/detail/project_id/14703";
//		String u="http://www.renrentou.com/project/detail/project_id/14703";
//		String u="http://www.renrentou.com/project/detail/project_id/14193";
//		String u="http://www.renrentou.com/project/detail/project_id/14193";
//		String u="http://www.renrentou.com/project/detail/project_id/14294";
//		String u="http://www.renrentou.com/project/detail/project_id/14294";
//		String u="http://www.renrentou.com/project/detail/project_id/8008";
		
		List<String> ss = new ArrayList<>();
		ss.add(u1);
		if(!ss.contains(u)){
			System.out.println("d");
		}
		
	}

}
