package cn.iktz.javaweb.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.iktz.javaweb.demo.jdbc.beans.Users;

//写的Java应用程序尽量做到数据库无关。

//把day11数据库中的users表中所有记录打印到控制台上
public class JdbcDemo2 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day11", "root", "sorry");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		List<Users> us = new ArrayList<Users>();
		//while(rs.next()){
//			System.out.println("------------------------");
//			System.out.println(rs.getObject(1));
//			System.out.println(rs.getObject(2));
//			System.out.println(rs.getObject(3));
//			System.out.println(rs.getObject(4));
//			System.out.println(rs.getObject(5));
		while(rs.next()){
			Users u = new Users();
			u.setId(rs.getInt("id"));//java类型与数据库类型的对应关系
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			us.add(u);
		}
		rs.close();
		stmt.close();
		conn.close();
		for(Users uu:us)
			System.out.println(uu);
	}

}
