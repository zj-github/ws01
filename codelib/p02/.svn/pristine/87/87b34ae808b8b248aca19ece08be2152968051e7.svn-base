package cn.innohub.crawler.crawl.storage.strategy;

import org.apache.log4j.Logger;

import cn.innohub.crawler.common.beans.BeanDatum;
import cn.innohub.crawler.common.beans.FieldBean;
import cn.innohub.crawler.common.dbassist.DBAssist;
import cn.innohub.crawler.common.dbassist.TransactionManager;

/**
 * @ClassName: JDBCStorateStrategy
 * @Description: 具体的存储策略
 * @author zhangjie
 * @date 2016年1月8日 上午9:59:34
 *
 */
public class JDBCStorateStrategy extends StorateStrategy {

	private Logger logger = Logger.getLogger(JDBCStorateStrategy.class);

	/**
	 * 解析组件的策略方法。 将HtmlText对象中的 HtmlContent中的对应的字段抽取出来。
	 */
	@Override
	public void storateStrategy(BeanDatum beanDatum) {
		storate(beanDatum);
	}

	DBAssist db = new DBAssist();

	private Object storate(BeanDatum beanDatum) {
		logger.info("insert beandatum");
		if(beanDatum instanceof FieldBean){
			FieldBean fb = (FieldBean)beanDatum;
			String insertSQL = fb.createInsertSQL();
			db.update(TransactionManager.getConnection(), insertSQL, (Object[])fb.getValues());
		}
		return null;
	}

}