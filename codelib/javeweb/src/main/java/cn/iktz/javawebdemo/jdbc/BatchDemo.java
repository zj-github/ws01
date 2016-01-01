package cn.iktz.javawebdemo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;
/*
use day12;
create table t1(
	id int primary key,
	name varchar(100)
);
 */
//�������������ݿ�Ľ�������
public class BatchDemo {
	//����2����ɾ����1��
	@Test
	public void test1() throws Exception{
		String sql1 = "insert into t1 (id,name) values(1,'a1')";
		String sql2 = "insert into t1 (id,name) values(2,'a2')";
		String sql3 = "delete from t1 where id=1";
		
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = conn.createStatement();//Statment�ڲ�ά����һ��List����
		stmt.addBatch(sql1);
		stmt.addBatch(sql2);
		stmt.addBatch(sql3);//��List�������
		
		stmt.executeBatch();
		
		JdbcUtil.release(null, stmt, conn);
		
	}
	//����100����¼
	@Test
	public void test2() throws Exception{
		String sql = "insert into t1 (id,name) values(?,?)";
		
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i=0;i<100;i++){
			stmt.setInt(1, i+1);
			stmt.setString(2, "aaa"+(i+1));
			stmt.addBatch();
		}
		stmt.executeBatch();
		JdbcUtil.release(null, stmt, conn);
		
	}
	//����1000001����¼
	@Test
	public void test3() throws Exception{
		String sql = "insert into t1 (id,name) values(?,?)";
		
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i=0;i<1000001;i++){
			stmt.setInt(1, i+1);
			stmt.setString(2, "aaa"+(i+1));
			stmt.addBatch();
			if(i%1000==0){
				stmt.executeBatch();
				stmt.clearBatch();
			}
		}
		stmt.executeBatch();
		JdbcUtil.release(null, stmt, conn);
		
	}
}
