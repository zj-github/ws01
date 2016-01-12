package cn.iktz.javaweb.demo.jdbc.pool;
/*package cn.iktz.javawebdemo.jdbc.pool;

import java.sql.Connection;
import java.util.LinkedList;

import com.itheima.util.JdbcUtil;
//模拟连接池原理：提升获取数据库链接的效率
//把链接放到一个缓存中，用完链接后一定要还回池中
public class SimpleConnectionPool {
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	static{
		//初始化10个链接
		for(int i=0;i<10;i++){
			Connection conn;
			try {
				conn = JdbcUtil.getConnection();
				pool.addLast(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized static Connection getConnection(){
		if(pool.size()>0){
			Connection conn = pool.removeFirst();
			return conn;
		}else{
			throw new RuntimeException("服务器忙");
		}
	}
	public static void release(Connection conn){
		pool.addLast(conn);
	}
}
*/