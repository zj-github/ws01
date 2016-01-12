package cn.iktz.javaweb.demo.jdbc.dbassist;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	public static Connection getConnection(){
		Connection conn = tl.get();
		if(conn==null){
			try {
				conn = C3P0Util.getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tl.set(conn);
		}
		return conn;
	}
	public static void startTransaction(){
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(){
		Connection conn = getConnection();
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(){
		Connection conn = getConnection();
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void release(){
		Connection conn = getConnection();
		try {
			tl.remove();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
