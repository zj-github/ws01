package crawler.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {


	@Test
	public void get() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
//		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60000);  
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();//设置请求和传输超时时�?
		
		try {
			HttpGet httpGet = new HttpGet("http://www.innohub.net/sciencemarket/article/detail.html?id=1298");
			httpGet.setConfig(requestConfig);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					System.out.println("Response content: " + EntityUtils.toString(entity));
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}