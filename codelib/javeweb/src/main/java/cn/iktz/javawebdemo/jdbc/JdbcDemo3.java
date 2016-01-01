package cn.iktz.javawebdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.iktz.javawebdemo.jdbc.beans.Users;

//д��JavaӦ�ó������������ݿ��޹ء�

//��day11���ݿ��е�users�������м�¼��ӡ������̨��
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
				u.setId(rs.getInt("id"));//java���������ݿ����͵Ķ�Ӧ��ϵ
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
