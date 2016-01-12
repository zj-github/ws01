package cn.iktz.javaweb.demo.jdbc.dbassist;

import java.sql.ResultSet;
public interface ResultSetHandler<T> {
	T handler(ResultSet rs);
}
