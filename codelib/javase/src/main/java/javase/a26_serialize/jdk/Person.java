package javase.a26_serialize.jdk;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 3191119828627505546L;
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age=age;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
