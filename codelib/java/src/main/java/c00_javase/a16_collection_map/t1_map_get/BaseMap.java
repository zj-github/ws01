package c00_javase.a16_collection_map.t1_map_get;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class BaseMap {

	public static void main(String[] args) {
		
		Map<String,String> m = new HashMap<>();
		for (int i = 0; i < 1000*10000; i++) {
			String string = getString();
			m.put(i+++"",string );
//			System.out.println(string);
		}
		
		System.out.println("----------------------");
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(m.get(458654+""));
		
		
//		ObjectInputStream in = new ObjectInputStream();
//		ObjectOutputStream o = new ObjectOutputStream()
		
//		m.
//		
//		System.out.println("######################");
		System.out.println( System.currentTimeMillis()-currentTimeMillis);
		
		
	}
	static char[] c= new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};
	static Random r = new Random();
	public static String getString(){
		StringBuilder sb =new StringBuilder();
		for (int i = 0; i < 30; i++) {
			int idx = r.nextInt(25);
			sb.append(c[idx]);
		}
		return sb.toString();
	}
	
	@Test
	public void random(){
		for (int i = 0; i < 10; i++) {
			int nextInt = r.nextInt(25);
			System.out.println(nextInt);
		}
	}
	
}

