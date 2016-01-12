package javase.a05;

public class Person {
	private String name;
	private int age;

	/*
	 * 构造代码块。 作用：给对象进行初始化。 对象一建立就运行，而且优先于构造函数执行。 和构造函数的区别： 构造代码块是给所有对象进行统一初始化，
	 * 而构造函数是给对应的对象初始化。
	 * 
	 * 构造代码快中定义的是不同对象共性的初始化内容。
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
	需求：给人定义一个用于比较年龄是否相同的功能。也就是是否是同龄人。
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