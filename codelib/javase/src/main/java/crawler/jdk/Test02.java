package crawler.jdk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class Test02 {

	@Test
	public void test01() throws Exception {
//		URL url = new URL("http://www.innohub.net/sciencemarket/article/detail.html?id=1298");
//						   http://news.163.com/16/0112/02/BD3JQQBO00014AED.html
		URL url = new URL("http://news.163.com/16/0112/02/BD3JQQBO00014AED.html");
		URLConnection rulConnection = url.openConnection();
		HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
		httpUrlConnection.setDoOutput(true);
		httpUrlConnection.setDoInput(true);
		httpUrlConnection.setUseCaches(false);
		httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");
//		httpUrlConnection.setRequestMethod("POST");
		httpUrlConnection.connect();
		
//		OutputStream outStrm = httpUrlConnection.getOutputStream();
//		ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm);
//		objOutputStrm.writeObject(new String("���ǲ������?));
//		objOutputStrm.flush();
//		objOutputStrm.close();
		BufferedReader is = new BufferedReader(new InputStreamReader( httpUrlConnection.getInputStream()));
		String line="";
		StringBuilder sb = new StringBuilder();
		while ((line=is.readLine())!=null) {
			sb.append(line+"\n");
//			System.out.println(new String(line.getBytes(),"iso-8859-1"));
		}
		IOUtils.write(sb, new FileOutputStream(new File("e:\\t1.html")));
		
	}
}
