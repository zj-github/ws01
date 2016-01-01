package cn.iktz.javawebdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//д��JavaӦ�ó������������ݿ��޹ء�

//��day11���ݿ��е�users�������м�¼��ӡ������̨��
public class JdbcDemo1 {

	public static void main(String[] args) throws SQLException {
//		1��ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//		2����ȡ�����ݿ������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day11", "root", "sorry");
		//System.out.println(conn.getClass().getName());
//		3����������SQL���Ķ���
		Statement stmt = conn.createStatement();
//		4��ִ��SQL���
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
//		5������в�ѯ������������
		while(rs.next()){
//			System.out.println("------------------------");
//			System.out.println(rs.getObject("id"));
//			System.out.println(rs.getObject("name"));
//			System.out.println(rs.getObject("password"));
//			System.out.println(rs.getObject("email"));
//			System.out.println(rs.getObject("birthday"));
			//�ֶ�������1��ʼ
			System.out.println("------------------------");
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
//		6���ͷ�ռ�õ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

}
