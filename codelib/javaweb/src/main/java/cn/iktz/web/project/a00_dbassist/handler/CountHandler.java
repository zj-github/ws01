package cn.iktz.web.project.a00_dbassist.handler;

import java.sql.ResultSet;

import cn.iktz.web.project.a00_dbassist.DBAssistException;
import cn.iktz.web.project.a00_dbassist.ResultSetHandler;


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
