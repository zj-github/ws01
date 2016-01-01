package cn.iktz.javawebdemo.jdbc;

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
//��ε��ô洢����:ֻ��Ҫ֪�������JDBC���ü���
public class ProcedureDemo {
	@Test
	public void test() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		CallableStatement stmt = conn.prepareCall("{call demoSp(?,?)}");//���ô洢����
		stmt.setString(1, "dongze");
		//������͵Ĳ���ע������
		stmt.registerOutParameter(2, Types.VARCHAR);
		
		stmt.execute();//ִ�д洢����
		
		String result = stmt.getString(2);//�õ���������������Ľ��  zyxw---dongze
		System.out.println(result);
		JdbcUtil.release(null, stmt, conn);
	}
}
