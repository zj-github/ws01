package cn.innohub.crawler.readxml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.innohub.crawler.common.beans.ExtractField;
import cn.innohub.crawler.common.beans.ExtractRule;
import cn.innohub.crawler.common.utils.Dom4JUtil;

public class ReadXmlTest {
	public static void main(String[] args) {
		new ReadXmlTest().loadFieldsExtractRegXml(); 
//		System.out.println(Configuration.getRule("www.innohub.net"));
	}
	

	/**
	 * @Description: 读取配置文件 fields-extract-reg.xml 1、读取host节点 2、创建Rule对象
	 *               ############# 3、获取host节点上的hostname、clazz设值rule值 4、获取field节点
	 *               ############# 5、封装Field对象 6、将Field对象设值到Rule对象上
	 * @author zhangjie
	 * @date 2016年1月4日 下午4:26:08
	 *
	 */
	public void loadFieldsExtractRegXml() {
		
		InputStream is = ReadXmlTest.class.getClassLoader().getResourceAsStream("fields-extract-reg.xml");

		try {
			Document doc = Dom4JUtil.getDocument(is);

			/** 1、读取host节点 */
			@SuppressWarnings("unchecked")
			List<Element> ruleNodeList = doc.selectNodes("/extract-rules/rule");
			for (Element rule : ruleNodeList) {
				ExtractRule extractRule = new ExtractRule();
				
				Node hostname = rule.selectSingleNode("hostname");
				Node clazz =  rule.selectSingleNode("clazz");
				extractRule.setHostName(hostname.getText().trim());
				extractRule.setClazz(clazz.getText().trim());
				
				@SuppressWarnings("unchecked")
				List<Node> fields =  rule.selectNodes("field");
				if(fields!=null&&fields.size()!=0){
					List<ExtractField> extractFieldsNode = extractFieldsNode(fields);
					extractRule.setFields(extractFieldsNode);
				}
//				Configuration.addRule(hostname.getText().trim(), extractRule);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @Description: 抽取Field 
	 * @author zhangjie
	 * @date 2016年1月4日 下午5:11:29 
	 *
	 */
	private List<ExtractField> extractFieldsNode(List<Node> fields){
		List<ExtractField> extractFieldList = new ArrayList<ExtractField>();
		for(Node node : fields){
			ExtractField extractField = new ExtractField();
			Node name = node.selectSingleNode("name");
			Node method = node.selectSingleNode("method");
			Node reg = node.selectSingleNode("reg");
			
			extractField.setMethod(method.getText().trim());
			extractField.setName(name.getText().trim());
//			extractField.setReg(reg.getText().trim());
			
			extractFieldList.add(extractField);
		}
		return extractFieldList;
	}

}
