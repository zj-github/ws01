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
		//�õ������ڴ�XML��Document����
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
//	1���õ�ĳ������Ľڵ�����:�̿�
	public static void test1(Document document){
		//����Ԫ�����Ƶõ��ڵ㣺����
		NodeList nl = document.getElementsByTagName("����");//���ֲ㼶��ϵ
		//�õ���1������
		Node node = nl.item(0);
		//��ӡ����������
		String content = node.getTextContent();
		System.out.println(content);
	}
//	2����������Ԫ�ؽڵ㲢��ӡ������
	public static void test2(Node node){
		//�ж��Ƿ���Ԫ�ؽڵ㣺����Ǵ�ӡ����
		if(node.getNodeType()==Node.ELEMENT_NODE){
			System.out.println(node.getNodeName());
		}
		//�õ������ǣ������������ݹ���
		NodeList nl = node.getChildNodes();
		for(int i=0;i<nl.getLength();i++){
			test2(nl.item(i));//�ݹ�
		}
	}
//	3���޸�ĳ��Ԫ�ؽڵ���������ݣ���2������ۼ۸�Ϊ0.28
	public static void test3(Document document) throws Exception {
		NodeList nl = document.getElementsByTagName("�ۼ�");
		Node node = nl.item(1);
		node.setTextContent("0.28");
		//���ڴ��е�documentд��XML�ļ���
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
//	4����ָ��Ԫ�ؽڵ���������Ԫ�ؽڵ�:��1����������<�ڲ���>10.00</�ڲ���>
	public static void test4(Document document) throws Exception {
		//������Ԫ���ڲ��۲�������������
		Element e = document.createElement("�ڲ���");
		e.setTextContent("10.00");
		//�õ���1���飬���Ӻ���
		Node node = document.getElementsByTagName("��").item(0);
		node.appendChild(e);
		//���ڴ��е�documentд��XML�ļ���
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
//	5����ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ�:<������>20.00</������>���ڵ�һ������ۼ�ǰ��
	public static void test5(Document document) throws Exception {
		//������Ԫ���ڲ��۲�������������
		Element e = document.createElement("������");
		e.setTextContent("20.00");
		//�õ���1���飬���ۼ�ǰ�����
		Node node = document.getElementsByTagName("�ۼ�").item(0);
		Node parentNode = node.getParentNode();
		parentNode.insertBefore(e, node);
		//���ڴ��е�documentд��XML�ļ���
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
	
//	6��ɾ��ָ��Ԫ�ؽڵ�:ɾ��������
	public static void test6(Document document) throws Exception {
		Node node = document.getElementsByTagName("������").item(0);
		node.getParentNode().removeChild(node);
		//���ڴ��е�documentд��XML�ļ���
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
//	7������XML�ļ�����:��ȡ������
	//ȡ����1����ĳ��������ԣ�����2��������һ��ISBN="438"
	public static void test7(Document document) throws Exception {
		
		Node bookNode1 = document.getElementsByTagName("��").item(0);
		Node bookNode2 = document.getElementsByTagName("��").item(1);
		
		Element e1 = (Element)bookNode1;
		Element e2 = (Element)bookNode2;
		
		System.out.println(e1.getAttribute("������"));//ȡ����1����ĳ���������
		
		e2.setAttribute("ISBN", "438");
		
		//���ڴ��е�documentд��XML�ļ���
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
	}
}
