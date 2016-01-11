package cn.innohub.crawler.common.beans;

import java.util.Arrays;

/**
 * @ClassName: FieldBean
 * @Description: 存储抽取后的字段
 * @author zhangjie
 * @date 2016年1月11日 下午1:24:06
 *
 */
public class FieldBean extends BeanDatum {

	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	private String tableName;
	private String detailId;
	private String[] columns;
	private String[] values;
	private int pos = 0;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public FieldBean(int len) {
		columns = new String[len];
		values = new String[len];
	}

	public FieldBean() {
		columns = new String[15];
		values = new String[15];
	}

	public void add(String column, String value) {
		columns[pos] = column;
		values[pos] = value;
		pos++;
	}

	public String[] getColumns() {
		return columns;
	}

	public String[] getValues() {
		return values;
	}

	public int size() {
		return pos;
	}

	public String[] valuesToString() {
		return Arrays.copyOf(values, size());
	}

	public String columnToString() {
		return arrToString(columns);
	}

	public String arrToString(String[] arg) {
		String s = "";
		for (int i = 0; i < size(); i++) {
			s += arg[i] + ",";
		}
		return splitLastComma(s);
	}

	@Override
	public String toString() {
		return "FieldBean [tableName=" + tableName + ", detailId=" + detailId + ", columns=" + Arrays.toString(columns)
				+ ", values=" + Arrays.toString(values) + ", pos=" + pos + "]";
	}

	private String splitLastComma(String s) {
		return s.substring(0, s.length() - 1);
	}

	public String createPlaceholder() {
		String s = "";
		for (int i = 0; i < size(); i++) {
			s += "?,";
		}
		return splitLastComma(s);
	}

	public String createInsertSQL() {
		String sql = "insert into table " + tableName + "(" + columnToString() + ") values " + "(" + createPlaceholder()
				+ ")";
		return sql;
	}

	public static void main(String[] args) {
		String[] a = new String[] { "aaa", "bbb", "cc", null, "" };
		String[] copyOf = Arrays.copyOf(a, 3);
		System.out.println(Arrays.toString(copyOf));
	}
}