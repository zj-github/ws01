package javase.a27_xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.junit.Test;

public class Dom4JDemo {
//	1���õ�ĳ������Ľڵ�����:�̿�
	@Test
	public void test1() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//�õ���Ԫ��
		Element root = document.getRootElement();
		List<Element> es = root.elements("��");
		Element secondBook = es.get(1);
		Element authorE = secondBook.element("����");
		System.out.println(authorE.getText());
	}
	
	@Test
	public void test11() throws Exception{
		Document document = Dom4JUtil.getDocument();
		String xpath = "//��[2]/����";
		Node node = document.selectSingleNode(xpath);
		System.out.println(node.getText());
	}
	
//	2����������Ԫ�ؽڵ㲢��ӡ������
	@Test
	public void test2() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//�õ���Ԫ��
		Element root = document.getRootElement();
		treeWalk(root);
	}
	private void treeWalk(Element e){
		System.out.println(e.getName());
		int childCount = e.nodeCount();//���ӵĸ���
		for(int i=0;i<childCount;i++){
			Node node = e.node(i);
			if(node instanceof Element){
				treeWalk((Element)node);
			}
		}
	}
//	3���޸�ĳ��Ԫ�ؽڵ���������ݣ���2������ۼ۸�Ϊ0.20
	@Test
	public void test3() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//�õ���Ԫ��
		Element root = document.getRootElement();
		List<Element> es = root.elements("��");
		Element secondBook = es.get(1);
		secondBook.element("�ۼ�").setText("0.20");
		Dom4JUtil.write2xml(document);
	}
//	4����ָ��Ԫ�ؽڵ���������Ԫ�ؽڵ�:��1����������<�ڲ���>10.00</�ڲ���>
	@Test
	public void test4() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//�õ���Ԫ��
		Element root = document.getRootElement();
		Element firstBook = root.element("��");
		firstBook.addElement("�ڲ���").addText("10.00");
		Dom4JUtil.write2xml(document);
	}
//	5����ָ��Ԫ�ؽڵ�������ͬ��Ԫ�ؽڵ�:<������>20.00</������>���ڵ�һ������ۼ�ǰ��
	@Test
	public void test5() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//�õ���Ԫ��
		Element root = document.getRootElement();
		Element firstBook = root.element("��");
		
		List<Element> es = firstBook.elements();
		
		Element price = DocumentHelper.createElement("������").addText("20.00");
		es.add(2, price);
		
		Dom4JUtil.write2xml(document);
	}
//	6��ɾ��ָ��Ԫ�ؽڵ�:ɾ��������
	@Test
	public void test6() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//�õ���Ԫ��
		Element root = document.getRootElement();
		Element firstBook = root.element("��");
		firstBook.remove(firstBook.element("������"));
		Dom4JUtil.write2xml(document);
	}
//	7������XML�ļ�����:��ȡ������
//	ȡ����1����ĳ��������ԣ�����1��������һ��ISBN="438"
	@Test
	public void test7() throws Exception{
		Document document = Dom4JUtil.getDocument();
		//�õ���Ԫ��
		Element root = document.getRootElement();
		Element firstBook = root.element("��");
		
		firstBook.addAttribute("ISBN", "222").addAttribute("������", "��ţ������");
		
		
		Dom4JUtil.write2xml(document);
	}
	@Test
	public void test71() throws Exception{
		Document document = Dom4JUtil.getDocument();
		String xpath = "//��[2]";
		Node node = document.selectSingleNode(xpath);
		if(node!=null)
			System.out.println(node.valueOf("@ISBN"));
	}
}
