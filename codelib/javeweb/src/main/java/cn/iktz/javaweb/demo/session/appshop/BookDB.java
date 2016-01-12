package cn.iktz.javaweb.demo.session.appshop;

import java.util.HashMap;
import java.util.Map;

//模拟数据库：实际开发中是没有的
public class BookDB {
	//key:后面value书籍的id；value：书对象
	private static Map<String, Book> books = new HashMap<String, Book>();
	static{
		books.put("1", new Book("1", "葵花宝典", "董泽", 5.00f, "欲练此功，必须练好基本功"));
		books.put("2", new Book("2", "辟邪剑法", "逄凯", 5.00f, "欲练此功，必须练好基本功"));
		books.put("3", new Book("3", "玉女心经", "韩菲菲", 15.00f, "欲练此功，必须清纯"));
		books.put("4", new Book("4", "金瓶梅", "迟珑", 5.00f, "古代爱情小说"));
		books.put("5", new Book("5", "JavaWeb体验式开发", "王昭珽", 5.00f, "学号web，干高新工作"));
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
}
