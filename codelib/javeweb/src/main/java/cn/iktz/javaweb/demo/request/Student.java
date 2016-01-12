package cn.iktz.javaweb.demo.request;

import java.util.Arrays;
import java.util.Date;

public class Student {
	private int id;//Ñ§ºÅ
	private String name;
	private Date birthday;
	private boolean married;
	private String[] hobbies;
	private String gender;
	private String description;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday="
				+ birthday + ", married=" + married + ", hobbies="
				+ Arrays.toString(hobbies) + ", gender=" + gender
				+ ", description=" + description + ", city=" + city + "]";
	}
	
	
}
