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
		String text="姓名：张飞";
//		String a = "abc//1dfs'姓名：";
		String a = "abc1dfs'姓名：";
		boolean matches = a.matches(".*(//|').*");
		System.out.println(matches);
	}
	
//	@Test
//	public void test1(){
//		String text = "abc1dfs'姓名：@2$3";
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
//						String s = text.substring(start+1,i);//索引	
//						
//						System.out.println(" >>>  "+cur + "  " +s);
//					}
//					cur=c;
//					start=i;
//					if(cssQuery==null||cssQuery==""){
//						cssQuery=text.substring(0,i);
//						//取Elements
//					}
//					break w;
//				}
//			}
//		}
//		if(matchd){
//			String s = text.substring(start+1,text.length());//索引	
//		}
//	
//		
//	}
//	String text = "abc1dfs'姓名：@2$3";
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
//						String s = text.substring(start+1,i);//索引	
//						
//						System.out.println(" >>>  "+cur + "  " +s);
//					}
//					cur=c;
//					start=i;
//					if(cssQuery==null||cssQuery==""){
//						cssQuery=text.substring(0,i);
//						//取Elements
//						
//					}
//					break w;
//				}
//			}
//		}
//		if(matchd){
//			String s = text.substring(start+1,text.length());//索引	
//		}
//	
//		
//	}
	
	public void test(){
		
	}
	public static void main(String[] args) {
		Document doc = Jsoup.parse("<span><p>发起人：周锦彦</p></span>");
		Elements select = doc.select("span>p'发起人：");
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
//							String s = cssQuery.substring(start+1,i);//索引	
//							int idx = Integer.parseInt(s.trim());
//							if(cur=='$'){
//								Element element = elements.get(0);
//								Node childNode = element.childNode(idx);
//								elements.clear();
//								element.text(childNode.toString());
//								elements.add(element);
//							}else if(cur =='@'){
//								Element element = elements.get(idx);//选择第idx号元素
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
//				String s = cssQuery.substring(start+1,cssQuery.length());//索引	
//			}else{
//				elements = Selector.select(cssQuery, this);
//			}
//			
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main() {
		/*
		 * String s1 = "abc";//s1是一个类类型变量， "abc"是一个对象。 //字符串最大特点：一旦被初始化就不可以被改变。
		 * String s2 = new String("abc");
		 * //s1和s2有什么区别？ //s1在内存中有一个对象。 //s2在内存中有两个对象。
		 * System.out.println(s1==s2);
		 * System.out.println(s1.equals(s2));//String类复写了Object类中equals方法，
		 * //该方法用于判断字符串是否相同。
		 * 
		 */
		String s = "abcde";
		method_1(s);
	}
	/*
	 * String类是对字符串事物的描述。 该类定义了专门用于操作字符串的方法。 "abc":
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
