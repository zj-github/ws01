package cn.iktz.javawebdemo.jdbc.dbassist;

import java.sql.ResultSet;
public interface ResultSetHandler<T> {
	T handler(ResultSet rs);
}
