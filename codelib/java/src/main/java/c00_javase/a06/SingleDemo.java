package c00_javase.a06;
/*
���ģʽ�����ĳһ����������֮��Ч�ķ�����
java��23�����ģʽ��
�������ģʽ�����һ�������ڴ�ֻ����һ������


��Ҫ��֤����Ψһ��
1��Ϊ�˱�������������ཨ����������Ƚ�ֹ�����������������
2����Ϊ��������������Է��ʵ��������ֻ���ڱ����У��Զ���һ������
3��Ϊ�˷�������������Զ������ķ��ʣ����Զ����ṩһЩ���ʷ�ʽ��

��������ô�ô��������أ�
1�������캯��˽�л���
2�������д���һ���������
3���ṩһ���������Ի�ȡ���ö���



�����������ô����������ô������
����Ҫ��������Ķ���֤���ڴ���Ψһʱ���ͽ����ϵ��������ϼ��ɡ�


*/

class Single
{


	private  Single(){}

	private static Single s = new Single();

	public static  Single getInstance()
	{
		return s;
	}
}


class SingleDemo 
{
	public static void main(String[] args) 
	{
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();

//		s1.setNum(23);

//		System.out.println(s2.getNum());


		
//		Single s1 = new Single();
//		Single s2= new Single();
//		s1.setNum(30);
//		System.out.println(s2.getNum());

//		Student s1 = new Student();
//		s1.setAge(30);
//
//		Student s2 = new Student();
//		s2.setAge(12);

//		Student s1 = Student.getStudent();
//		Student s2 = Student.getStudent();

		


	}
}



class Student
{
	private int age;


	private static Student s = new Student();
	private Student(){}
	public static Student getStudent()
	{
		return s;
	}



	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
}
