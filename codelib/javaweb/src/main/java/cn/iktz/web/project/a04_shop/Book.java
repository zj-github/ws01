package cn.iktz.web.project.a04_shop;

import java.io.Serializable;

public class Book implements Serializable{
	private String id;//唯一标识一本书
	private String name;
	private String author;
	private float price;
	private String description;
	
	public Book(){}
	
	public Book(String id, String name, String author, float price,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", price=" + price + ", description=" + description + "]";
	}
	
}
