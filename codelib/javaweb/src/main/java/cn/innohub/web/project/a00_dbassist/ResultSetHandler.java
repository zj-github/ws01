package cn.innohub.web.project.a00_dbassist;

import java.sql.ResultSet;
public interface ResultSetHandler<T> {
	T handler(ResultSet rs);
}
