package c00_javase.a18_JarFile;

import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.Test;

public class JarFileTest {

	@Test
	public void test1() throws Exception{
		
		JarFile jarFile = new JarFile("e:\\tools.jar");

		Enumeration<JarEntry> entries = jarFile.entries();
		while(entries.hasMoreElements()){
			JarEntry jarEntry = entries.nextElement();

			//文件的全路径  
			//com/sun/tools/internal/xjc/reader/relaxng/
			//com/sun/tools/internal/xjc/reader/relaxng/xx.class
			String name = jarEntry.getName();
			System.out.println(name);
		
			//文件尺寸
			//若是文件返回大小，若是目录返回0
			long size = jarEntry.getSize();
			System.out.println(size);
			
			if(jarEntry.isDirectory()){
				System.out.println("--- "+name);
			}
			
		}
		jarFile.close();
	}
}
