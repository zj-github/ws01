package c00_javase.a13_String;

public class StringTest0112 {
	public static void main(String[] args) {
		String classPath = "/E:/test/d/conf/";

		String jarFilePath = classPath.substring(classPath.indexOf("/"));
		System.out.println(jarFilePath);
		
	}
}
