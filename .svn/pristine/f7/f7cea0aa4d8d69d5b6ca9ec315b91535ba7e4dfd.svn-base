package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 数据来源
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum DataSource {
	YDD("1"), // 移动端
	PCD("2"), // PC端
	JX("3"), // 金信
	DJR("4");// 大金融
	public static Map<String, String> dataSourceMap = new Hashtable<String, String>();

	static {
		dataSourceMap.put(DataSource.YDD.value, "移动端");
		dataSourceMap.put(DataSource.PCD.value, "PC端");
		dataSourceMap.put(DataSource.JX.value, "金信");
		dataSourceMap.put(DataSource.DJR.value, "大金融");
	}
	public final String value;

	private DataSource(String value) {
		this.value = value;
	}

	public static String getDataSource(String value) {
		return dataSourceMap.get(value);
	}
}