package c00_javase.a26_serialize.jdk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) throws Exception  {
		
		Person person = new Person("test01",29);
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("e:\\person.txt"));
		
		os.writeObject(person);
		os.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e:\\person.txt"));
		Person p = (Person)ois.readObject();
		System.out.println(p.toString());
		
		
		
		ois.close();
	}
}
