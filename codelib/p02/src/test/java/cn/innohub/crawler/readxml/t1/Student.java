package cn.innohub.crawler.readxml.t1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private int id;
	private String name;
	private int age;
	private Classroom classroom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Student(int id, String name, int age, Classroom classroom) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.classroom = classroom;
	}

	//无参够着函数一定需要，否则JXBContext无法正常解析。
	public Student() {
		super();
	}
}
