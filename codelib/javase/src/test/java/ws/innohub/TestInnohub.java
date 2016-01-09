package ws.innohub;

public class TestInnohub {

	public static void main(String[] args) {
		/**
		 * crawlDautm>
		 * 		url
		 * 		filed1
		 *			columnname 			
		 * 			element
		 * 			attr
		 * 		filed2
		 * 			
		*/
		//1、读取配置
		/* 
		* map1 (
		 * 	<u1,list(<pro_name,reg>,<pro_logo,reg>)>
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
