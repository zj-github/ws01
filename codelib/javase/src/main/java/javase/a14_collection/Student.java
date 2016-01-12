package javase.a14_collection;
class Student implements Comparable<Student>
{
	private String name;
	private int age;
	public Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public Student(String name2, String string) {
		// TODO Auto-generated constructor stub
	}

	public int compareTo(Student s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));

		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}

	public int hashCode()
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("¿‡–Õ≤ª∆•≈‰");

		Student s = (Student)obj;

		return this.name.equals(s.name) && this.age==s.age;
		

	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return name+":"+age;
	}
}
