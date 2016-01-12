package javase.a05;

public class Person {
	private String name;
	private int age;

	/*
	 * �������顣 ���ã���������г�ʼ���� ����һ���������У����������ڹ��캯��ִ�С� �͹��캯�������� ���������Ǹ����ж������ͳһ��ʼ����
	 * �����캯���Ǹ���Ӧ�Ķ����ʼ����
	 * 
	 * ���������ж�����ǲ�ͬ�����Եĳ�ʼ�����ݡ�
	 * 
	 */
	{
		// System.out.println("person code run");
		cry();
	}

	Person() {
		System.out.println("A: name=" + name + ",,age=" + age);

	}


	/*
	 * public void setName(String n) { name = n; } public String getName() {
	 * return name; }
	 */
	Person(String n, int a) {
		name = n;
		age = a;
		System.out.println("C: name=" + name + ",,age=" + age);
		// cry();
	}

	Person(int age) {
		this.age = age;
	}

	Person(String name) {
		this.name = name;
	}

	public void cry() {

		System.out.println("cry......");
	}
	
	/*
	���󣺸��˶���һ�����ڱȽ������Ƿ���ͬ�Ĺ��ܡ�Ҳ�����Ƿ���ͬ���ˡ�
	*/
	public boolean compare(Person p)
	{
		return this.age==p.age;

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	
}