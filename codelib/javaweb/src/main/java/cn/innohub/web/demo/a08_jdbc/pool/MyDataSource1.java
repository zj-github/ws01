package cn.innohub.web.demo.a08_jdbc.pool;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.innohub.web.demo.a08_jdbc.common.JdbcUtil;


public class MyDataSource1 implements DataSource {
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
			final Connection conn = pool.removeFirst();
			Connection proxyConn = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), 
					new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							if("close".equals(method.getName())){
								pool.add(conn);
							}else{
								return method.invoke(conn, args);
							}
							return null;
						}
					});
			return proxyConn;
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



	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
