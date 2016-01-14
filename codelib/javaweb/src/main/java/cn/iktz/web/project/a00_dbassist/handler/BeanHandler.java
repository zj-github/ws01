package cn.iktz.web.project.a00_dbassist.handler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import cn.iktz.web.project.a00_dbassist.DBAssistException;
import cn.iktz.web.project.a00_dbassist.ResultSetHandler;

/**返回单个*/
public class BeanHandler<T> implements ResultSetHandler<T> {

	private Class<T> clazz;
	public BeanHandler(Class<T> clazz){
		this.clazz = clazz;
	}
	public T handler(ResultSet rs) {
		try {
			if(rs.next()){
				T bean = clazz.newInstance();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for(int i=0;i<columnCount;i++){
					String columnName = rsmd.getColumnName(i+1);
					Object columnValue = rs.getObject(columnName);
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(bean, columnValue);
				}
				return bean;
			}else
				return null;
		} catch (Exception e) {
			throw new DBAssistException(e);
		}
	}

}
