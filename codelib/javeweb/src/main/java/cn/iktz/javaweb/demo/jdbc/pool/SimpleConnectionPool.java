package cn.iktz.javaweb.demo.jdbc.pool;
/*package cn.iktz.javawebdemo.jdbc.pool;

import java.sql.Connection;
import java.util.LinkedList;

import com.itheima.util.JdbcUtil;
//ģ�����ӳ�ԭ��������ȡ���ݿ����ӵ�Ч��
//�����ӷŵ�һ�������У��������Ӻ�һ��Ҫ���س���
public class SimpleConnectionPool {
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	static{
		//��ʼ��10������
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
			throw new RuntimeException("������æ");
		}
	}
	public static void release(Connection conn){
		pool.addLast(conn);
	}
}
*/