package cn.innohub.web.project.dbassist;

import java.sql.ResultSet;
public interface ResultSetHandler<T> {
	T handler(ResultSet rs);
}
