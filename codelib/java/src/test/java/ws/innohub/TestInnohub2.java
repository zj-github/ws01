package ws.innohub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestInnohub2 {
	 static class  Bean1{
		 String reg;
		 List<Bean2> info;
	 }
	 static class Bean2{
		 String column;
		 Selector select;
	 }
	 static class Selector{
		 String element;
		 String attr;
	 }

	public static void main(String[] args) {
		Map<String,Bean1> map1= new HashMap<>();
		Bean1  b1 = new Bean1();
		String reg ="baidu.com/art"; 
		b1.reg = reg;
		List<Bean2> info = b1.info;
		
		Bean2 b2 = new Bean2();
		
		Selector s = new Selector();
		s.attr="href";
		s.element="div.title";
		
		b2.column="pro_name";
		b2.select=s;
		
		Bean2 b22 = new Bean2();
		
		Selector s1 = new Selector();
		s1.attr="href";
		s1.element="div.title";
		
		b22.column="pro_log";
		b22.select=s1;
		
		info.add(b22);
		
		map1.put(reg, b1);
		
//		map1.put(reg,b1 )//key是一个正则表达式
		
		
		//1、读取配置
		/* 
		* map1 (
		 * 	<u1,list(<pro_name,selector>,<pro_logo,selector>)>
		 * 	<u2,list(<title,reg>,<posttime,reg>)>
		 * )
		 *
		 */
		//2、抓取
		//3、抽取字段
		//		pro_name
		//		pro_logo
			/*
			 * 
			 * 
			 * while(true){
			 * u1|u2 = getURLType
			 * fieldlist = map.get(u1|u2)
			 * map m = new map();
			 * 
			 * [k1,k2,k3,k4]
			 * [v1,v2,v3,v4]
			 * 
			 * for(fieldlist){
			 *  provalue=	Jsoup.select(pro_key);
			 *  m.put(provalue)
			 * }
			 * 
			 * bean1< url,map>
			 * 
			 * map.get(getType(url)).add(bean1);
			 * 
			 * map(
			 * 		<u1,list<[k1,k2,k3][v1,v2,v3],[k1,k2,k3][v1,v2,v3],[k1,k2,k3][v1,v2,v3],>>    
			 * 		<u2,map<tile,posttime>>
			 * )
			 */
		
		//封装根据url取得类型的方法 
		
		//4、存储
		
		
		
	}
}
