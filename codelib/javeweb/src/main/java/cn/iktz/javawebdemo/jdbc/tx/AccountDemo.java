package cn.iktz.javawebdemo.jdbc.tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.iktz.javawebdemo.jdbc.JdbcUtil;

public class AccountDemo {
	//MySQL:事务是自动开启和关闭的
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//相当于start transaction
			stmt = conn.prepareStatement("update account set money=money-100 where name='bbb'");
			stmt.executeUpdate();
			
			int i=1/0;
			
			stmt = conn.prepareStatement("update account set money=money+100 where name='aaa'");
			stmt.executeUpdate();
			
			conn.commit();
		}catch(Exception e){
			if(conn!=null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, stmt, conn);
		}
	}
}
