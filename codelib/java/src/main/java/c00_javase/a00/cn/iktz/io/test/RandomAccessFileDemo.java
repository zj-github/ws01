package c00_javase.a00.cn.iktz.io.test;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
�ļ��������д
1���ڲ���װ��һ�����飬����ͨ��ָ��������Ԫ�ؽ��в�����
2������ͨ��getFilePointer��ȡָ��λ�ã�����ͨ��seek�ı�ָ���λ�á�
*/
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		 writeFile();
		 readFile();
	}
	//
	public static void readFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("e:\\t.txt", "r");
		// ����������ָ�롣
		 raf.seek(8*1);
		// ����ָ�����ֽ���
		//raf.skipBytes(8);
		/*��ȡһ���� start*/
		byte[] buf = new byte[4];
		raf.read(buf);
		System.out.println(new String(buf));
		/*��ȡһ���� end*/
		raf.close();
	}
	public static void writeFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("e:\\t.txt", "rw");
		raf.seek(8 * 1);//��ָ���Ƶ��ڰ˸��ֽڵ�λ��
		raf.write("iktz.cn".getBytes());
		raf.close();
	}
}
