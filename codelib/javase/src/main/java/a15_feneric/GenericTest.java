package a15_feneric;
import java.util.*;
class  GenericTest
{
	public static void main(String[] args) 
	{
		/*
		ArrayList al = new	ArrayList();
		al.add(new Person("heihei"));

		ArrayList al1 = new ArrayList();

		al1.add("haha1");
		al1.add("haha2");

		al.addAll(al1);

		System.out.println(al);int.next().getName();
		*/


		/**/
		
		ArrayList<Person> al = new	ArrayList<Person>();
		al.add(new Person("ahah"));

		ArrayList<Student> al1 = new ArrayList<Student>();

		al1.add(new Student("haha"));

		al.addAll(al1);
		

		Iterator<Person> it = al.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}




	}
}
/*
Person p = new PErson();
p.equals("haha");
Demo d = new Demo();
d.equals(p);
*/

//���͸㶨�����͵�ʹ�á����ڼ������еķ��ͻ��ü��ɡ����Կ��ö��������ޣ�������ͷ��ͷ������塣

