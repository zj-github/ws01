package cn.innohub.crawler.readxml;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.innohub.crawler.common.beans.ExtractField;
import cn.innohub.crawler.common.beans.ExtractRule;
import cn.innohub.crawler.common.utils.Dom4JUtil;
import cn.innohub.crawler.conf.ConfigurationLoader;

public class ReadXmlTest2 {
	private final String FIELD = "field";
	private final String HOSTNAME = "hostname";

	/**
	 * @Description: 读取配置文件 fields-extract-reg.xml 1、读取host节点 2、创建Rule对象
	 *               ############# 3、获取host节点上的hostname、clazz设值rule值 4、获取field节点
	 *               ############# 5、封装Field对象 6、将Field对象设值到Rule对象上
	 * @author zhangjie
	 * @date 2016年1月4日 下午4:26:08
	 *
	 */
	public void loadFieldsExtractRegXml() {
		InputStream is = ReadXmlTest2.class.getClassLoader().getResourceAsStream("fields-extract-reg.xml");

		try {
			Document doc = Dom4JUtil.getDocument(is);

			/** 1、读取host节点 */
			@SuppressWarnings("unchecked")
			List<Element> hostNode = doc.selectNodes("/extract-reg/host");
			for (Element host : hostNode) {
				/** 2、创建Rule对象 */
				// 封装ExtractRule 对象
				ExtractRule rule = new ExtractRule();
				String hostName = "";
				Class<? extends ExtractRule> ruleClazz = rule.getClass();
				
				
				@SuppressWarnings("unchecked")
				List<Element> ruleFieldNodeList = host.elements();
				for (Element ruleFieldNode : ruleFieldNodeList) {
					String name = ruleFieldNode.getName();
					Field field = ruleClazz.getDeclaredField(name);
					
					if (!name.equals(FIELD)) {
//						if(){
//							
//						}
						
						/** 3、获取host节点上的hostname、clazz设值rule值 */
						if (field != null) {
							field.setAccessible(true);
							field.set(rule, ruleFieldNode.getText());
						}
					} else {

						/** 4、获取field节点 */
						// 获取子节点，创建ExtractField对象
						/**
						 * 1、创建一个ExtractField对象 2、获取name、method、reg等值
						 * 3、为ExtractField对象设值
						 */

						@SuppressWarnings("unchecked")
						List<Element> fieldNodeList = ruleFieldNode.elements();
						ExtractField extractField = new ExtractField();
						/** 5、封装Field对象 */
						for (Element fieldNode : fieldNodeList) {
							String fieldNodeName = fieldNode.getName();
							Field extractFieldField = extractField.getClass().getDeclaredField(fieldNodeName);//字段对象的class中的字段
							if (extractFieldField != null) {
								extractFieldField.setAccessible(true);
								extractFieldField.set(extractField, fieldNode.getText());
								rule.getFields().add(extractField);
							}
						}
					}
				}
				
//				Configuration.addRule("", extractRule);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
