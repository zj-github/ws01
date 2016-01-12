package cn.iktz.javaweb.demo.session.appshop;

import java.util.HashMap;
import java.util.Map;

//ģ�����ݿ⣺ʵ�ʿ�������û�е�
public class BookDB {
	//key:����value�鼮��id��value�������
	private static Map<String, Book> books = new HashMap<String, Book>();
	static{
		books.put("1", new Book("1", "��������", "����", 5.00f, "�����˹����������û�����"));
		books.put("2", new Book("2", "��а����", "�̿�", 5.00f, "�����˹����������û�����"));
		books.put("3", new Book("3", "��Ů�ľ�", "���Ʒ�", 15.00f, "�����˹��������崿"));
		books.put("4", new Book("4", "��ƿ÷", "����", 5.00f, "�Ŵ�����С˵"));
		books.put("5", new Book("5", "JavaWeb����ʽ����", "���ѬE", 5.00f, "ѧ��web���ɸ��¹���"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
}
