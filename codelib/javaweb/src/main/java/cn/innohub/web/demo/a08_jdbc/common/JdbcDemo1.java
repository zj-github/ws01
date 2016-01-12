package cn.innohub.web.demo.a08_jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//写的Java应用程序尽量做到数据库无关。

//把day11数据库中的users表中所有记录打印到控制台上
public class JdbcDemo1 {

	public static void main(String[] args) throws SQLException {
//		1、注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//		2、获取与数据库的链接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day11", "root", "sorry");
		//System.out.println(conn.getClass().getName());
//		3、创建代表SQL语句的对象
		Statement stmt = conn.createStatement();
//		4、执行SQL语句
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
//		5、如果有查询结果：遍历结果
		while(rs.next()){
//			System.out.println("------------------------");
//			System.out.println(rs.getObject("id"));
//			System.out.println(rs.getObject("name"));
//			System.out.println(rs.getObject("password"));
//			System.out.println(rs.getObject("email"));
//			System.out.println(rs.getObject("birthday"));
			//字段索引从1开始
			System.out.println("------------------------");
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
		}
//		6、释放占用的资源
		rs.close();
		stmt.close();
		conn.close();
	}

}
