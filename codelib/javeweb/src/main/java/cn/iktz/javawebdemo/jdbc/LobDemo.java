package cn.iktz.javawebdemo.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
/*
create database day12;
use day12;
create table c1(
	id int primary key,
	content longtext
);
create table b1(
	id int primary key,
	content longblob
);
 */
public class LobDemo {
	//存储大文本到数据库:流
	@Test
	public void testClobWirte() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into c1 (id,content) values(?,?)");
		stmt.setInt(1, 1);
		
		File file = new File("src/jpm.txt");
		Reader reader = new FileReader(file);
		
		stmt.setCharacterStream(2, reader, (int)file.length());//MySQL驱动没有实现long的。
		int count = stmt.executeUpdate();
		System.out.println(count);
		JdbcUtil.release(null, stmt, conn);
	}
	@Test
	public void testClobRead() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from c1 where id=1");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			Reader r = rs.getCharacterStream("content");
			FileWriter out = new FileWriter("e:/jpm.txt");
			char c[] = new char[1024];
			int len = -1;
			while((len=r.read(c))!=-1){
				out.write(c, 0, len);
			}
			out.close();
			r.close();
		}
		JdbcUtil.release(null, stmt, conn);
	}
	@Test
	public void testBlobWirte() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into b1 (id,content) values(?,?)");
		stmt.setInt(1, 1);
		InputStream in = new FileInputStream("src/7.jpg");
		stmt.setBinaryStream(2, in, in.available());
		int count = stmt.executeUpdate();
		System.out.println(count);
		JdbcUtil.release(null, stmt, conn);
	}
	@Test
	public void testBlobRead() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from b1 where id=1");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			InputStream in = rs.getBinaryStream("content");
			OutputStream out = new FileOutputStream("e:/77.jpg");
			byte b[] = new byte[1024];
			int len = -1;
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
			out.close();
			in.close();
		}
		JdbcUtil.release(null, stmt, conn);
	}
}
