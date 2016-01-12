package c00_javase.a16_collection_map;
/*
ÿһ��ѧ�����ж�Ӧ�Ĺ����ء�
ѧ��Student����ַString��
ѧ�����ԣ����������䡣
ע�⣺������������ͬ����Ϊͬһ��ѧ����
��֤ѧ����Ψһ�ԡ�



1������ѧ����

2������map��������ѧ����Ϊ������ַ��Ϊֵ�����롣

3����ȡmap�����е�Ԫ�ء�

*/

import java.util.*;



class  MapTest
{
	public static void main(String[] args) 
	{
		HashMap<Student,String> hm = new HashMap<Student,String>();

		hm.put(new Student("lisi1",21),"beijing");
		hm.put(new Student("lisi1",21),"tianjin");
		hm.put(new Student("lisi2",22),"shanghai");
		hm.put(new Student("lisi3",23),"nanjing");
		hm.put(new Student("lisi4",24),"wuhan");

		//��һ��ȡ����ʽ keySet

		Set<Student> keySet = hm.keySet();

		Iterator<Student> it = keySet.iterator();

		while(it.hasNext())
		{
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+".."+addr);
		}


		//�ڶ���ȡ����ʽ entrySet
		Set<Map.Entry<Student,String>> entrySet = hm.entrySet();

		Iterator<Map.Entry<Student,String>> iter = entrySet.iterator();
		
		while(iter.hasNext())
		{
			Map.Entry<Student,String> me = iter.next();
			Student stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+"........."+addr);
		}
	}
}
