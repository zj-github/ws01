package cn.innohub.crawler.common.dbassist.handler;

import java.sql.ResultSet;

import cn.innohub.crawler.common.dbassist.DBAssistException;
import cn.innohub.crawler.common.dbassist.ResultSetHandler;


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
