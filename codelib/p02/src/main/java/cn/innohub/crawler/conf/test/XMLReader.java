package cn.innohub.crawler.conf.test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.innohub.crawler.common.utils.Dom4JUtil;
import cn.innohub.crawler.common.utils.Path;

public class XMLReader {

	// 2、遍历所有元素节点并打印其名称
	public static void main(String[] args) throws Exception {
		 String xmlFilePath = Path.getClassPath() + "NewFile.xml";
		 Document document = Dom4JUtil.getDocument(xmlFilePath);
		 // 得到根元素
		 Element root = document.getRootElement();
		 treeWalk(root);

	}

	private static void treeWalk(Element e) throws Exception {
		//1
		String tagName = e.getName();
		System.out.println(tagName);
		System.out.println(e.getText());
		
		
		int childCount = e.nodeCount();// 孩子的个数
		for (int i = 0; i < childCount; i++) {
			Node node = e.node(i);
			if (node instanceof Element) {
				treeWalk((Element) node);
			}
		}
	}
//	private static void treeWalk(Element e, Class<?> clazz,Object o) throws Exception {
//		//1
//		String tagName = e.getName();
//		//2
//		Field declaredField = clazz.getDeclaredField(tagName);
//		Class<?> type = declaredField.getType();
//		
//		if(isBaseDataType(type)){
//			declaredField.setAccessible(true);
//			declaredField.set(o,);
//		}
//		
//		int childCount = e.nodeCount();// 孩子的个数
//		for (int i = 0; i < childCount; i++) {
//			Node node = e.node(i);
//			if (node instanceof Element) {
//				treeWalk((Element) node, clazz);
//			}
//		}
//	}

	public static void t() {
		/**
		 * 1、根据标签名获取class中的字段 2、获取字段的类型 1、看是不是基本类型，如果是基本类型，直接获取class中的对应字段赋值
		 * 2、如果不是基本类型，获取对应的类，创建对象，遍历子节点，并取得相应的字段赋值
		 */

		// if(){
		//
		// }

	}

	private static boolean isBaseDataType(Class<?> clazz) throws Exception {
		return (clazz.equals(String.class) || 
				
				clazz.equals(Integer.class) || clazz.equals(int.class)
				|| clazz.equals(Byte.class)	|| clazz.equals(byte.class)
				|| clazz.equals(Long.class) || clazz.equals(long.class)
				|| clazz.equals(Double.class) || clazz.equals(double.class)
				|| clazz.equals(Float.class)|| clazz.equals(float.class)
				|| clazz.equals(Character.class) || clazz.equals(char.class)
				|| clazz.equals(Short.class) || clazz.equals(short.class)
				|| clazz.equals(BigDecimal.class)
				|| clazz.equals(BigInteger.class) 
				|| clazz.equals(Boolean.class) || clazz.equals(boolean.class)
				);
	}

	// private static boolean isBaseDataType(Class<?> clazz) throws Exception {
	// return (clazz.equals(String.class) || clazz.equals(Integer.class) ||
	// clazz.equals(Byte.class)
	// || clazz.equals(Long.class) || clazz.equals(Double.class) ||
	// clazz.equals(Float.class)
	// || clazz.equals(Character.class) || clazz.equals(Short.class) ||
	// clazz.equals(BigDecimal.class)
	// || clazz.equals(BigInteger.class) || clazz.equals(Boolean.class) ||
	// clazz.equals(Date.class)
	// || clazz.isPrimitive());
	// }

}
