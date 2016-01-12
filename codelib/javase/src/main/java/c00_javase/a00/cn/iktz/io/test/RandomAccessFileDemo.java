package c00_javase.a00.cn.iktz.io.test;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
文件的随机读写
1、内部封装了一个数组，而且通过指针对数组的元素进行操作。
2、可以通过getFilePointer获取指针位置，可以通过seek改变指针的位置。
*/
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		 writeFile();
		 readFile();
	}
	//
	public static void readFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("e:\\t.txt", "r");
		// 调整对象中指针。
		 raf.seek(8*1);
		// 跳过指定的字节数
		//raf.skipBytes(8);
		/*读取一个字 start*/
		byte[] buf = new byte[4];
		raf.read(buf);
		System.out.println(new String(buf));
		/*读取一个字 end*/
		raf.close();
	}
	public static void writeFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("e:\\t.txt", "rw");
		raf.seek(8 * 1);//把指针移到第八个字节的位置
		raf.write("iktz.cn".getBytes());
		raf.close();
	}
}
