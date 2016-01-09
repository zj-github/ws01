package cn.innohub.crawler.parse.reflect;

import java.lang.reflect.Field;

public class ReflectTest {

	public static void main(String[] args) {
		
		try {
			Class<?> clazz = Class.forName("cn.innohub.crawler.parse.reflect.PraseResult");
			Object ins = clazz.newInstance();
			Field declaredField = clazz.getDeclaredField("name");
		
			declaredField.setAccessible(true);
			
			declaredField.set(ins, "innohub");
		
			PraseResult pr = (PraseResult)ins;
			
			System.out.println(pr.getName());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

