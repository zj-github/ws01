package c00_javase.a18_io;
//��C��һ���ı��ļ����Ƶ�D�̡�

/*
���Ƶ�ԭ����
��ʵ���ǽ�C���µ��ļ����ݴ洢��D�̵�һ���ļ��С�

���裺
1����D�̴���һ���ļ������ڴ洢C���ļ��е����ݡ�
2�������ȡ����C���ļ�������
3��ͨ�����ϵĶ�д������ݴ洢��
4���ر���Դ��
*/

import java.io.*;

class CopyText 
{
	public static void main(String[] args) throws IOException
	{
		copy_2();
	}


	public static void copy_2()
	{
		FileWriter fw = null;
		FileReader fr = null;
		try
		{
			fw = new FileWriter("SystemDemo_copy.txt");
			fr = new FileReader("SystemDemo.java");

			char[] buf = new char[1024];

			int len = 0;
			while((len=fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("��дʧ��");

		}
		finally
		{
			if(fr!=null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{
				}
			if(fw!=null)
				try
				{
					fw.close();
				}
				catch (IOException e)
				{
				}
		}
	}

	//��C�̶�һ���ַ�������D��дһ���ַ���
	public static void copy_1()throws IOException
	{
		//����Ŀ�ĵء�
		FileWriter fw = new FileWriter("RuntimeDemo_copy.txt");

		//�������ļ�������
		FileReader fr = new FileReader("RuntimeDemo.java");

		int ch = 0;

		while((ch=fr.read())!=-1)
		{
			fw.write(ch);
		}
		
		fw.close();
		fr.close();

	}


}