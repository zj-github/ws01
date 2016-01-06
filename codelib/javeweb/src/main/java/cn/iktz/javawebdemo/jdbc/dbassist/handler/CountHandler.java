package cn.iktz.javawebdemo.jdbc.dbassist.handler;

import java.sql.ResultSet;

import cn.iktz.javawebdemo.jdbc.dbassist.DBAssistException;
import cn.iktz.javawebdemo.jdbc.dbassist.ResultSetHandler;


public class CountHandler implements ResultSetHandler<Integer> {
	public Integer handler(ResultSet rs) {
		try {
			if(rs.next()){
				return rs.getInt(1);
			}else
				return null;
		} catch (Exception e) {
			throw new DBAssistException(e);
		}
	}
}
