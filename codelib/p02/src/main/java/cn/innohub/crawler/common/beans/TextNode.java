package cn.innohub.crawler.common.beans;

import java.io.Serializable;
/**
 * @ClassName: TextNode 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author zhangjie
 * @date 2016年1月7日 上午9:54:35 
 *
 */
public class TextNode implements Serializable {
	private static final long serialVersionUID = -4911351336886878099L;
	private String element;// 所属元素
	private String attr;//属性名称

	public TextNode() {
	}


	public TextNode(String element, String attr) {
		this.element = element;
		this.attr = attr;
	}




	@Override
	public String toString() {
		return "TextNode [element=" + element + ", attr=" + attr + "]";
	}


	public String getElement() {
		return element;
	}


	public void setElement(String element) {
		this.element = element;
	}


	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

}