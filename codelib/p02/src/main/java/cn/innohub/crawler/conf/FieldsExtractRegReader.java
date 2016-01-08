package cn.innohub.crawler.conf;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.innohub.crawler.common.FileNameConstant;
import cn.innohub.crawler.common.beans.ExtractField;
import cn.innohub.crawler.common.beans.ExtractRule;
import cn.innohub.crawler.common.beans.TextNode;
import cn.innohub.crawler.common.utils.Dom4JUtil;
import cn.innohub.crawler.common.utils.Path;
import cn.innohub.crawler.core.Context;

/**
 * @ClassName: CrawlConf 
 * @Description: 配置文件上下文 
 * @author zhangjie
 * @date 2016年1月4日 上午10:19:28 
 *
 */
public class FieldsExtractRegReader  {

	public void initConf() {
		Context.getInstance().getRuleMap().clear();//清空以前的内容
		String xmlFilePath = Path.getClassPath() + FileNameConstant.FIELDS_EXTRACT_REG_XML;
		this.loadFieldsExtractRegXml(xmlFilePath);
	}
	
	private  void loadFieldsExtractRegXml(String fieldsExtractRegXmlPath) {
		try {
			Document doc = Dom4JUtil.getDocument(fieldsExtractRegXmlPath);

			/** 1、读取host节点 */
			@SuppressWarnings("unchecked")
			List<Element> ruleNodeList = doc.selectNodes("/extract-rules/rule");
			for (Element rule : ruleNodeList) {
				ExtractRule extractRule = new ExtractRule();

				Node hostname = rule.selectSingleNode("hostname");
				Node clazz = rule.selectSingleNode("clazz");
				extractRule.setHostName(hostname.getText().trim());
				extractRule.setClazz(clazz.getText().trim());

				@SuppressWarnings("unchecked")
				List<Node> fields = rule.selectNodes("field");
				if (fields != null && fields.size() != 0) {
					List<ExtractField> extractFieldsNode = extractFieldsNode(fields);
					extractRule.setFields(extractFieldsNode);
				}
				Context.getInstance().addRule(hostname.getText().trim(), extractRule);
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
	private   List<ExtractField> extractFieldsNode(List<Node> fields) {
		List<ExtractField> extractFieldList = new ArrayList<ExtractField>();
		for (Node node : fields) {
			ExtractField extractField = new ExtractField();
			Node nameNode = node.selectSingleNode("name");
			System.err.println(nameNode.getText());
			Node methodNode = node.selectSingleNode("method");
			Node eleNode = node.selectSingleNode("element");
			Node attrNode = node.selectSingleNode("attr");
		
			if(nameNode!=null&&StringUtils.isNotEmpty(nameNode.getText())){
				extractField.setName(nameNode.getText().trim());
			}
			if(methodNode!=null&&StringUtils.isNotEmpty(methodNode.getText())){
				extractField.setMethod(methodNode.getText().trim());
			}
			if(eleNode!=null&&StringUtils.isNotEmpty(eleNode.getText())){
				
				String eleStr = eleNode.getText().trim();
				TextNode txt = new TextNode();
				txt.setElement(eleStr);
				if(attrNode!=null&&StringUtils.isNotEmpty(attrNode.getText())){
					String attrStr = attrNode.getText().trim();		
					txt.setAttr(attrStr);
				}
				extractField.setTxt(txt);
			}
			System.out.println(extractField.getTxt().toString());
			extractFieldList.add(extractField);
		}
		return extractFieldList;
	}
}
