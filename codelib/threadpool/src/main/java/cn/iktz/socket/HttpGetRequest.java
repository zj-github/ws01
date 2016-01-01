package cn.iktz.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpGetRequest {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 200; i++) {
			System.out.println(doGet()+" >> "+i);
			Thread.sleep(1000);
		}
	}
	public static String doGet() throws Exception {
		
		URL localURL = new URL("http://blog.csdn.net/iktz_cn/article/details/50110467");
		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
/*
Accept:
Accept-Encoding:gzip, deflate, sdch
Accept-Language:zh-CN,zh;q=0.8
Cache-Control:max-age=0
Connection:keep-alive
Cookie:CNZZDATA3357085=cnzz_eid%3D1071939806-1448175151-null%26ntime%3D1448175151; __gads=ID=891b03824aa94446:T=1448634262:S=ALNI_MbcUFMSmgigDyZKG6c4AimypbelAw; __utma=226521935.1794711462.1448678098.1448678098.1448678098.1; __utmz=226521935.1448678098.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; CNZZDATA1254603060=1828629413-1448702511-null%7C1448702511
Host:www.cnblogs.com
If-Modified-Since:Wed, 02 Dec 2015 04:46:03 GMT
Upgrade-Insecure-Requests:1
User-Agent:Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36
 */
		httpURLConnection.setRequestProperty("Accept-Charset", "gbk");
		httpURLConnection.setRequestProperty("Cache-Control", "max-age=0");
		httpURLConnection.setRequestProperty("Connection", "keep-alive");
		httpURLConnection.setRequestProperty("Host", "blog.csdn.net");
		httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		//httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
		httpURLConnection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		if (httpURLConnection.getResponseCode() >= 300) {
			throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
		}

		try {
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				//resultBuffer.append(tempLine+"\n");
			}

		} finally {

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}

		return resultBuffer.toString();
	}

}
