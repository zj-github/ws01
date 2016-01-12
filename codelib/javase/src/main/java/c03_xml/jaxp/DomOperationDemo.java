package c03_xml.jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomOperationDemo {

	public static void main(String[] args) throws Exception {
		//得到代表内存XML的Document对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
//		test1(document);
//		test2(document);
//		test3(document);
//		test4(document);
//		test5(document);
//		test6(document);
		test7(document);
	}
//	1、得到某个具体的节点内容:逄凯
	public static void test1(Document document){
		//根据元素名称得到节点：作者
		NodeList nl = document.getElementsByTagName("作者");//不分层级关系
		//得到第1个作者
		Node node = nl.item(0);
		//打印其主体内容
		String content = node.getTextContent();
		System.out.println(content);
	}
//	2、遍历所有元素节点并打印其名称
	public static void test2(Node node){
		//判断是否是元素节点：如果是打印名称
		if(node.getNodeType()==Node.ELEMENT_NODE){
			System.out.println(node.getNodeName());
		}
		//得到孩子们，继续遍历。递归了
		NodeList nl = node.getChildNodes();
		for(int i=0;i<nl.getLength();i++){
			test2(nl.item(i));//递归
		}
	}
//	3、修改某个元素节点的主体内容：第2本书的售价改为0.28
	public static void test3(Document document) throws Exception {
		NodeList nl = document.getElementsByTagName("售价");
		Node node = nl.item(1);
		node.setTextContent("0.28");
		//把内存中的document写到XML文件中
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
//	4、向指定元素节点中增加子元素节点:第1本书中增加<内部价>10.00</内部价>
	public static void test4(Document document) throws Exception {
		//创建新元素内部价并设置主体内容
		Element e = document.createElement("内部价");
		e.setTextContent("10.00");
		//得到第1本书，增加孩子
		Node node = document.getElementsByTagName("书").item(0);
		node.appendChild(e);
		//把内存中的document写到XML文件中
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
//	5、向指定元素节点上增加同级元素节点:<批发价>20.00</批发价>放在第一本书的售价前面
	public static void test5(Document document) throws Exception {
		//创建新元素内部价并设置主体内容
		Element e = document.createElement("批发价");
		e.setTextContent("20.00");
		//得到第1本书，在售价前面添加
		Node node = document.getElementsByTagName("售价").item(0);
		Node parentNode = node.getParentNode();
		parentNode.insertBefore(e, node);
		//把内存中的document写到XML文件中
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	
//	6、删除指定元素节点:删除批发价
	public static void test6(Document document) throws Exception {
		Node node = document.getElementsByTagName("批发价").item(0);
		node.getParentNode().removeChild(node);
		//把内存中的document写到XML文件中
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
//	7、操作XML文件属性:获取，设置
	//取出第1本书的出版社属性；给第2本书增加一个ISBN="438"
	public static void test7(Document document) throws Exception {
		
		Node bookNode1 = document.getElementsByTagName("书").item(0);
		Node bookNode2 = document.getElementsByTagName("书").item(1);
		
		Element e1 = (Element)bookNode1;
		Element e2 = (Element)bookNode2;
		
		System.out.println(e1.getAttribute("出版社"));//取出第1本书的出版社属性
		
		e2.setAttribute("ISBN", "438");
		
		//把内存中的document写到XML文件中
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
}
