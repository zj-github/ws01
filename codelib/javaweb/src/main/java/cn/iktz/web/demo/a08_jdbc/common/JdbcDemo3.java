package cn.iktz.web.demo.a08_jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.iktz.web.demo.a08_jdbc.Users;

//写的Java应用程序尽量做到数据库无关。

//把day11数据库中的users表中所有记录打印到控制台上
public class JdbcDemo3 {

	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day11", "root", "sorry");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id,name,password,email,birthday from users");
			List<Users> us = new ArrayList<Users>();
			while(rs.next()){
				Users u = new Users();
				u.setId(rs.getInt("id"));//java类型与数据库类型的对应关系
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getDate("birthday"));
				us.add(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			if(rs!=null){
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}finally{
//					if(stmt!=null){
//						try {
//							stmt.close();
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}finally{
//							if(conn!=null){
//								try {
//									conn.close();
//								} catch (SQLException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//					}
//				}
//			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}

}
