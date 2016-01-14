package cn.iktz.web.demo.a01_request;

import java.util.Arrays;

//字段名与表单的输入域名称保持一致：约定
public class User {
	private String username;
	private String[] password;
	public String getUsername() {//读属性
		return username;
	}
	public void setUsername(String username) {//写属性
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
