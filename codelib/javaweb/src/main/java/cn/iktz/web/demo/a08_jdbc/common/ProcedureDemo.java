package cn.iktz.web.demo.a08_jdbc.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.junit.Test;
/*
delimiter $$

CREATE PROCEDURE demoSp(IN inputParam VARCHAR(255), INOUT inOutParam varchar(255))
BEGIN
    SELECT CONCAT('zyxw---', inputParam) into inOutParam;
END $$

delimiter ;
*/
//如何调用存储过程:只需要知道如何用JDBC调用即可
public class ProcedureDemo {
	@Test
	public void test() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		CallableStatement stmt = conn.prepareCall("{call demoSp(?,?)}");//调用存储过程
		stmt.setString(1, "dongze");
		//输出类型的参数注册类型
		stmt.registerOutParameter(2, Types.VARCHAR);
		
		stmt.execute();//执行存储过程
		
		String result = stmt.getString(2);//得到输出参数的运算后的结果  zyxw---dongze
		System.out.println(result);
		JdbcUtil.release(null, stmt, conn);
	}
}
