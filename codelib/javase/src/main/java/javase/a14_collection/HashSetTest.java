package javase.a14_collection;

import java.util.*;

/*
往hashSet集合中存入自定对象
姓名和年龄相同为同一个人，重复元素。





*/
class HashSetTest 
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args) 
	{
		HashSet hs = new HashSet();

		hs.add(new Person("a1",11));
		hs.add(new Person("a2",12));
		hs.add(new Person("a3",13));
//		hs.add(new Person("a2",12));
//		hs.add(new Person("a4",14));

		//sop("a1:"+hs.contains(new Person("a2",12)));
			
//		hs.remove(new Person("a4",13));
		

		Iterator it = hs.iterator();

		while(it.hasNext())
		{
			Person p = (Person)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
	}
}