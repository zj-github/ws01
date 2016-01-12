package c01_increased.d1;

//import static java.lang.Math.max;
import static java.lang.Math.*;

import c01_increased.d2.AnnotationTest;

public class StaticImport {

	public static void main(String[] args){
		
		AnnotationTest.sayHello();
		int x = 1;
		try {
			x++;
		} finally {
			System.out.println("template");
		}
		System.out.println(x);
		
		
		System.out.println(max(3, 6));
		System.out.println(abs(3 - 6));
		
	}
}
