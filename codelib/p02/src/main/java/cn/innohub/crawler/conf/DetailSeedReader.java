package cn.innohub.crawler.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import cn.innohub.crawler.common.FileNameConstant;
import cn.innohub.crawler.common.InitParamsConstant;
import cn.innohub.crawler.common.utils.Path;
import cn.innohub.crawler.core.Context;

/**
 * @ClassName: DetailSeedReader
 * @Description: 读取 detail-seed.properties
 * @author zhangjie
 * @date 2016年1月6日 上午11:13:25
 *
 */
public class DetailSeedReader {

	public void read() {
		Context.getInstance().getParams().clear();//清空以前的内容
		try {
		InputStream is = new FileInputStream(new File(Path.getClassPath()+FileNameConstant.DETAIL_SEED_PROPERTIES)) ;
		Properties p = new Properties();
			p.load(is);
			Set<Entry<Object, Object>> entrySet = p.entrySet();
			for (Entry<Object, Object> en : entrySet) {
				String value = (String)en.getValue();
				String  key = (String)en.getKey();
				Context.getInstance().setParam(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Context.getInstance().getParams().put(InitParamsConstant.DEFAULT_INTERVAL, 60000);
	}

}
