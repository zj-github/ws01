package javase.a27_xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

public class Dom4JDemo {
//	1、得到某个具体的节点内容:逄凯
	@Test
	public void test1() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//得到根元素
		Element root = document.getRootElement();
		List<Element> es = root.elements("书");
		Element secondBook = es.get(1);
		Element authorE = secondBook.element("作者");
		System.out.println(authorE.getText());
	}
	
	@Test
	public void test11() throws Exception{
		Document document = Dom4JUtil.getDocument();
		String xpath = "//书[2]/作者";
		Node node = document.selectSingleNode(xpath);
		System.out.println(node.getText());
	}
	
//	2、遍历所有元素节点并打印其名称
	@Test
	public void test2() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//得到根元素
		Element root = document.getRootElement();
		treeWalk(root);
	}
	private void treeWalk(Element e){
		System.out.println(e.getName());
		int childCount = e.nodeCount();//孩子的个数
		for(int i=0;i<childCount;i++){
			Node node = e.node(i);
			if(node instanceof Element){
				treeWalk((Element)node);
			}
		}
	}
//	3、修改某个元素节点的主体内容：第2本书的售价改为0.20
	@Test
	public void test3() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//得到根元素
		Element root = document.getRootElement();
		List<Element> es = root.elements("书");
		Element secondBook = es.get(1);
		secondBook.element("售价").setText("0.20");
		Dom4JUtil.write2xml(document);
	}
//	4、向指定元素节点中增加子元素节点:第1本书中增加<内部价>10.00</内部价>
	@Test
	public void test4() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//得到根元素
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		firstBook.addElement("内部价").addText("10.00");
		Dom4JUtil.write2xml(document);
	}
//	5、向指定元素节点上增加同级元素节点:<批发价>20.00</批发价>放在第一本书的售价前面
	@Test
	public void test5() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//得到根元素
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		
		List<Element> es = firstBook.elements();
		
		Element price = DocumentHelper.createElement("批发价").addText("20.00");
		es.add(2, price);
		
		Dom4JUtil.write2xml(document);
	}
//	6、删除指定元素节点:删除批发价
	@Test
	public void test6() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//得到根元素
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		firstBook.remove(firstBook.element("批发价"));
		Dom4JUtil.write2xml(document);
	}
//	7、操作XML文件属性:获取，设置
//	取出第1本书的出版社属性；给第1本书增加一个ISBN="438"
	@Test
	public void test7() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//得到根元素
		Element root = document.getRootElement();
		Element firstBook = root.element("书");
		
		firstBook.addAttribute("ISBN", "222").addAttribute("出版社", "很牛出版社");
		
		
		Dom4JUtil.write2xml(document);
	}
	@Test
	public void test71() throws Exception{
		Document document = Dom4JUtil.getDocument();
		String xpath = "//书[2]";
		Node node = document.selectSingleNode(xpath);
		if(node!=null)
			System.out.println(node.valueOf("@ISBN"));
	}
}
