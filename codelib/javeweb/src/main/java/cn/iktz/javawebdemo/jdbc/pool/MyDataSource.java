/*package cn.iktz.javawebdemo.jdbc.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;

import cn.iktz.javawebdemo.jdbc.JdbcUtil;

public class MyDataSource implements DataSource {
	public static int initalPoolSize = 10;
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	static{
		//初始化10个链接
		for(int i=0;i<initalPoolSize;i++){
			Connection conn;
			try {
				conn = JdbcUtil.getConnection();
				pool.addLast(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public synchronized Connection getConnection() throws SQLException {
		if(pool.size()>0){
			Connection conn = pool.removeFirst();
			MyConnection1 mconn = new MyConnection1(conn, pool);
			return mconn;
		}else{
			throw new RuntimeException("服务器忙");
		}
	}

	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		return null;
	}
	
}
*/