package cn.iktz.javaweb.demo.request;

import java.util.Arrays;

//�ֶ�����������������Ʊ���һ�£�Լ��
public class User {
	private String username;
	private String[] password;
	public String getUsername() {//������
		return username;
	}
	public void setUsername(String username) {//д����
		this.username = username;
	}
	public String[] getPassword() {
		return password;
	}
	public void setPassword(String[] password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password="
				+ Arrays.toString(password) + "]";
	}
	
}
