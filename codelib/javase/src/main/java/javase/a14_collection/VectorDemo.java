package javase.a14_collection;

import java.util.*;

/*
ö�پ���Vector���е�ȡ����ʽ��
����ö�ٺ͵���������
��ʵö�ٺ͵�����һ���ġ�

��Ϊö�ٵ������Լ����������ƶ�������
���Ա�������ȡ���ˡ�
ö�����������ˡ�



*/
class VectorDemo 
{
	public static void main(String[] args) 
	{
		Vector v = new Vector();

		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");

		Enumeration en = v.elements();

		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}
}