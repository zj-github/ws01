package cn.innohub.crawler.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class PhantomjsUtil {
	private static Logger logger = Logger.getLogger(HttpClientFetcher.class);

	public static String fetchHtmlContent(String url) {
		logger.info("PhantomjsUtil fetch "+url);
		try {
			Runtime rt = Runtime.getRuntime();
			Process p =  rt.exec(
					"E:\\devsf\\javadev\\phantomjs\\bin\\phantomjs.exe E:\\devsf\\javadev\\phantomjs\\bin\\test01.js "
							+ url);


			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuffer sbf = new StringBuffer();
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				sbf.append(tmp);
			}
			return sbf.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}