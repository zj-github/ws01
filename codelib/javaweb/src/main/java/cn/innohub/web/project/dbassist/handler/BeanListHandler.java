package cn.innohub.web.project.dbassist.handler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import cn.innohub.web.project.dbassist.DBAssistException;
import cn.innohub.web.project.dbassist.ResultSetHandler;

public class BeanListHandler<T> implements ResultSetHandler<List<T>> {
	private Class<T> clazz;
	public BeanListHandler(Class<T> clazz){
		this.clazz = clazz;
	}
	public List<T> handler(ResultSet rs) {
		try {
			List<T> list = new ArrayList<T>();
			while(rs.next()){
				T bean = clazz.newInstance();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for(int i=0;i<columnCount;i++){
					String columnName = rsmd.getColumnName(i+1);
					
					Object columnValue = rs.getObject(columnName);//�м�¼ֵ
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					if("status".equals(columnName)){
						char columnValueChar = columnValue.toString().charAt(0);
						field.set(bean, columnValueChar);	
					}else{
						field.set(bean, columnValue);	
					}
					
				}
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			throw new DBAssistException(e);
		}
	}

}
