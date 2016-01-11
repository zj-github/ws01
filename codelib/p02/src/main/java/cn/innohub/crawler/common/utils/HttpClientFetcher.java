package cn.innohub.crawler.common.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * @ClassName: HttpclientFetchStrategy
 * @Description: 使用Httpunit抓取网页
 * @author zhangjie
 * @date 2015年12月31日 下午1:37:50
 *
 */
public class HttpClientFetcher {
	private static Logger logger = Logger.getLogger(HttpClientFetcher.class);
	private static CloseableHttpClient httpclient = HttpClients.createDefault();
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000)
			.build();// 设置请求和传输超时时间

	public static String fetchHtmlContent(String url) {
		CloseableHttpResponse response = null;
		logger.debug(Thread.currentThread().getName() + "send get request fetch url >> " + url);
		logger.info(url);
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		try {
			response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				logger.debug("set htmlContent to HtmlText instance >> " + url);
				return EntityUtils.toString(entity);
			}
		} catch (ClientProtocolException e) {
			logger.debug("http request  error");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			logger.debug("parse enity error");
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
					logger.debug("close response >> " + url);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}