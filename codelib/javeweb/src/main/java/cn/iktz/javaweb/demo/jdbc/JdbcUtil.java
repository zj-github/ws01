package cn.iktz.javaweb.demo.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		try {
			//读取配置文件
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties props = new Properties();
			props.load(in);
			driverClass = props.getProperty("driverClass");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			//注册驱动
			Class.forName(driverClass);
		} catch (IOException e) {
			throw new ExceptionInInitializerError("Read config file failure");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError("The driver class full name was wrong,you are sb");
		}
		
	}
	
	public static Connection getConnection() throws Exception{
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	public static void release(ResultSet rs,Statement stmt,Connection conn){
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
