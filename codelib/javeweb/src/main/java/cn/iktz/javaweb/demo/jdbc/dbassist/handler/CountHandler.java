package cn.iktz.javaweb.demo.jdbc.dbassist.handler;

import java.sql.ResultSet;

import cn.iktz.javaweb.demo.jdbc.dbassist.DBAssistException;
import cn.iktz.javaweb.demo.jdbc.dbassist.ResultSetHandler;


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
