package a13_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;
import org.junit.Test;

public class StringDemo {
	
	
	@Test
	public void test01(){
		String text="�������ŷ�";
//		String a = "abc//1dfs'������";
		String a = "abc1dfs'������";
		boolean matches = a.matches(".*(//|').*");
		System.out.println(matches);
	}
	
//	@Test
//	public void test1(){
//		String text = "abc1dfs'������@2$3";
//		String cssQuery = "";
//		
//		Document doc = Jsoup.parse("<span><p>dd</p><p>eeeeee</p></span>");
//	
//		doc.select("");
//		
//		
//		
//		char[] match = new char[]{'$','\'','@'};
//		char cur = 0;
//		int start=0;
//		boolean matchd = false;
//		for(int i=0;i<text.length();i++){
//			char c1 = text.charAt(i);
//			w:for(char c : match){
//				if(c==c1){
//					
//					matchd=true;
//					if(start!=0){
//						String s = text.substring(start+1,i);//����	
//						
//						System.out.println(" >>>  "+cur + "  " +s);
//					}
//					cur=c;
//					start=i;
//					if(cssQuery==null||cssQuery==""){
//						cssQuery=text.substring(0,i);
//						//ȡElements
//					}
//					break w;
//				}
//			}
//		}
//		if(matchd){
//			String s = text.substring(start+1,text.length());//����	
//		}
//	
//		
//	}
//	String text = "abc1dfs'������@2$3";
//	Document doc = Jsoup.parse("<span><p>dd</p><p>eeeeee</p></span>");
//	public void select(String cssQuery){
//		
//		char[] match = new char[]{'$','\'','@'};
//		char cur = 0;
//		int start=0;
//		boolean matchd = false;
//		for(int i=0;i<text.length();i++){
//			char c1 = text.charAt(i);
//			w:for(char c : match){
//				if(c==c1){
//					matchd=true;
//					if(start!=0){
//						String s = text.substring(start+1,i);//����	
//						
//						System.out.println(" >>>  "+cur + "  " +s);
//					}
//					cur=c;
//					start=i;
//					if(cssQuery==null||cssQuery==""){
//						cssQuery=text.substring(0,i);
//						//ȡElements
//						
//					}
//					break w;
//				}
//			}
//		}
//		if(matchd){
//			String s = text.substring(start+1,text.length());//����	
//		}
//	
//		
//	}
	
	public void test(){
		
	}
	public static void main(String[] args) {
		Document doc = Jsoup.parse("<span><p>�����ˣ��ܽ���</p></span>");
		Elements select = doc.select("span>p'�����ˣ�");
		System.out.println("text  : "+select.text());
	}
	
//	 public void select(String cssQuery){
//	    	Elements elements = null ;
//			char[] match = new char[]{'$','\'','@'};
//			char cur = 0;
//			int start=0;
//			boolean matchd = false;
//			for(int i=0;i<cssQuery.length();i++){
//				char c1 = cssQuery.charAt(i);
//				w:for(char c : match){
//					if(c==c1){
//						
//						matchd=true;
//						if(start!=0){
//							String s = cssQuery.substring(start+1,i);//����	
//							int idx = Integer.parseInt(s.trim());
//							if(cur=='$'){
//								Element element = elements.get(0);
//								Node childNode = element.childNode(idx);
//								elements.clear();
//								element.text(childNode.toString());
//								elements.add(element);
//							}else if(cur =='@'){
//								Element element = elements.get(idx);//ѡ���idx��Ԫ��
//								elements.clear();
//								elements.add(element);
//							}
//							
//							
//							System.out.println(" >>>  "+cur + "  " +s);
//						}
//						cur=c;
//						start=i;
//						
//						elements = Selector.select(cssQuery, this);
//						if(elements==null){
//							elements = Selector.select(cssQuery.substring(0,i), this);
//						}
//						break w;
//					}
//				}
//			}
//			if(matchd){
//				String s = cssQuery.substring(start+1,cssQuery.length());//����	
//			}else{
//				elements = Selector.select(cssQuery, this);
//			}
//			
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main() {
		/*
		 * String s1 = "abc";//s1��һ�������ͱ����� "abc"��һ������ //�ַ�������ص㣺һ������ʼ���Ͳ����Ա��ı䡣
		 * String s2 = new String("abc");
		 * //s1��s2��ʲô���� //s1���ڴ�����һ������ //s2���ڴ�������������
		 * System.out.println(s1==s2);
		 * System.out.println(s1.equals(s2));//String�ิд��Object����equals������
		 * //�÷��������ж��ַ����Ƿ���ͬ��
		 * 
		 */
		String s = "abcde";
		method_1(s);
	}
	/*
	 * String���Ƕ��ַ�������������� ���ඨ����ר�����ڲ����ַ����ķ����� "abc":
	 */

	public static void method_1(String s) {
		char ch = s.charAt(3);

		System.out.println("ch=" + ch);
		int num = s.codePointAt(3);

		System.out.println("num=" + num);

		String s1 = "qq";
		s1 = s1.concat("mm");

		System.out.println("s1=" + s1);
		System.out.println("qq" + "mm");

		String a = "opq";
		String b = "opq";
		System.out.println("a==b:" + (a == b));
	}
	
	
}
