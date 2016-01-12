package cn.iktz.javaweb.demo.jdbc.tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.iktz.javaweb.demo.jdbc.JdbcUtil;

public class AccountDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		Savepoint sp = null;//回滚点
		try{
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//相当于start transaction
			stmt = conn.prepareStatement("update account set money=money-100 where name='aaa'");
			stmt.executeUpdate();
//			stmt.close();
			
			stmt = conn.prepareStatement("update account set money=money+100 where name='bbb'");
			stmt.executeUpdate();
			
			sp = conn.setSavepoint();//创建回滚点
			
			stmt = conn.prepareStatement("update account set money=money-200 where name='bbb'");
			stmt.executeUpdate();
			
//			int i=1/0;
			
			stmt = conn.prepareStatement("update account set money=money+200 where name='ccc'");
			stmt.executeUpdate();
			
			
			
		}catch(Exception e){
			if(conn!=null)
				try {
					conn.rollback(sp);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		}finally{
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JdbcUtil.release(null, stmt, conn);
		}
	}
}
