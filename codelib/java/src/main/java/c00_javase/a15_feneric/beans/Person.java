package c00_javase.a15_feneric.beans;

class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return "person :"+name;
	}
}
