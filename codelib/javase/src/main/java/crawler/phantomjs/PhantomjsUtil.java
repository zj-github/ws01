package crawler.phantomjs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PhantomjsUtil {

	public static String fetchHtmlContent(String url) {
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
			e.printStackTrace();
		} 
		return null;
	}
}
