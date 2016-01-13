package c00_javase.a18_JarFile;

import java.io.File;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import org.junit.Test;

public class JarFileTest {

	@Test
	public void test1() throws Exception{
		
		JarFile jarFile = new JarFile("e:\\tools.jar");

		Enumeration<JarEntry> entries = jarFile.entries();
		while(entries.hasMoreElements()){
			JarEntry jarEntry = entries.nextElement();

			//�ļ���ȫ·��  
			//com/sun/tools/internal/xjc/reader/relaxng/
			//com/sun/tools/internal/xjc/reader/relaxng/xx.class
			String name = jarEntry.getName();
			System.out.println(name);
		
			//�ļ��ߴ�
			//�����ļ����ش�С������Ŀ¼����0
			long size = jarEntry.getSize();
			System.out.println(size);
			
			if(jarEntry.isDirectory()){
				System.out.println("--- "+name);
			}
			
		}
		jarFile.close();
	}
	@Test
	public void test2() throws Exception{
		
		JarFile jarFile = new JarFile("e:\\tools.jar");
		
		String name = "com/sun/tools/internal/xjc/reader/relaxng/";
		ZipEntry entry = jarFile.getEntry(name);
		System.out.println(entry.isDirectory());
		jarFile.close();
	}
}
