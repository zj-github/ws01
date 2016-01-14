package cn.iktz.web.demo.a08_jdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnection1 extends ConnectionAdapter {
	private Connection conn;
	private LinkedList<Connection> pool;
	public MyConnection1(Connection conn,LinkedList<Connection> pool){
		super(conn);
		this.pool = pool;
	}
	public void close() throws SQLException {
		pool.add(conn);
	}
	
}
