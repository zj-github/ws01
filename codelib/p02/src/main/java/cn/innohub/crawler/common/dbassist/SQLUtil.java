package cn.innohub.crawler.common.dbassist;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.innohub.crawler.common.beans.innohub.CCFAProjectInfo;
import cn.innohub.crawler.core.Context;

public class SQLUtil {

//	private static String createCCFASQL() {
//		String tableName = "ccfa_project_info";
//		Map<String, String> columnMapping = Context.getInstance().getColumnMapping();
////		String[] columns = columnMapping.get("ccfa").split(",");
//		String[] columns = "project_name,project_logo,city,contact_name,description,introduction".split(",");
//		
//	}
	public static String createInsertSQL(String tableName,StringBuilder columnsb,StringBuilder statmsb) {
		String sql = "INSERT INTO " + tableName + " ( " + columnsb.toString() + " ) " + " values " + "("+statmsb.toString()+")";
		return sql;
	}
	
	public synchronized static void handccfa(CCFAProjectInfo ccfap,StringBuilder columnsbtmp,StringBuilder statmsbtmp,List<String> l) {
		//1、column 
		//2、?????
		//3、values
		StringBuilder columnsb = new StringBuilder();
		StringBuilder statmsb = new StringBuilder();
		Map<String, String> columnMapping = Context.getInstance().getColumnMapping();
//		String[] columns = columnMapping.get("ccfa").split(",");
		String[] columns = "project_name,project_logo,city,contact_name,description,introduction".split(",");
		try {
			
			for (int i=0;i<columns.length;i++) {
				String column =columns[i];
				String field = columnMapping.get(column);
				Field field2 = ccfap.getClass().getDeclaredField(field);
				field2.setAccessible(true);
				String v = (String) field2.get(ccfap);
				if(StringUtils.isNotEmpty(v)){
					columnsb.append(column+",");
					statmsb.append("?,");
					l.add(v);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		columnsbtmp.append( columnsb.substring(0,columnsb.length()-1));
		statmsbtmp.append(statmsb.substring(0,statmsb.length()-1));
	}
//	
//	private synchronized static String handccfa(int length) {
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<length;i++){
//			sb.append("?,");
//		}
//		return sb.substring(0,sb.length()-1);
//	}
	public static void main(String[] args) {
		Object[] valuessb = new Object[]{};
		valuessb[1]="d";
		System.out.println(valuessb);
		
	}
}
