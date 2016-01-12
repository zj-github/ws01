package cn.iktz.javaweb.demo.jdbc.dbassist;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAssist {
	
	public int update(String sql,Object... params){
		Connection conn = null;
		conn = TransactionManager.getConnection();
		return update(conn,true,sql,params);
	}	
	public int update(Connection conn,String sql,Object... params){
		return update(conn,false,sql,params);
	}	
	public int update(Connection conn,boolean autoCommit,String sql,Object... params){
		PreparedStatement stmt = null;
		try{
			stmt = conn.prepareStatement(sql);
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int paramCount = pmd.getParameterCount();
			if(paramCount!=0){
				if(params==null||params.length!=paramCount){
					throw new IllegalArgumentException("Wrong param");
				}
				
				for(int i=0;i<paramCount;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			return stmt.executeUpdate();
		}catch(Exception e){
			throw new DBAssistException(e);
		}finally{
			if(autoCommit){
				release(null, stmt, conn);
			}else {
				release(null, stmt, null);
			}
		}
	}
	public <T> T query(String sql,ResultSetHandler<T> rsh,Object...params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = TransactionManager.getConnection();
			//add
			//System.out.println("閾炬帴鏄惁宸茬粡鍏抽棴锛�+conn.isClosed());
			
			stmt = conn.prepareStatement(sql);
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int paramCount = pmd.getParameterCount();
			if(paramCount!=0){
				if(params==null||params.length!=paramCount){
					throw new IllegalArgumentException("Wrong param");
				}
				for(int i=0;i<paramCount;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			rs = stmt.executeQuery();
			T obj = rsh.handler(rs);
			return obj;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			//release(rs, stmt, conn);
			TransactionManager.release();
		}
	}
	

	
	public void release(ResultSet rs,Statement stmt,Connection conn){
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
