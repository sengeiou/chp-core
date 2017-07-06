package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 职业
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum Prof {
	ZYYZ("1"), // 自营业主
	GSZY("2"), // 公司职员
	GWY("3"), // 公务员
	ZYZY("4"), // 自由职业
	LTXRS("5"), // 离退休人士
	QT("6");// 其他

	public static Map<String, String> profMap = new Hashtable<String, String>();

	static {
		profMap.put(Prof.ZYYZ.value, "自营业主");
		profMap.put(Prof.GSZY.value, "公司职员");
		profMap.put(Prof.GWY.value, "公务员");
		profMap.put(Prof.ZYZY.value, "自由职业");
		profMap.put(Prof.LTXRS.value, "离退休人士");
		profMap.put(Prof.QT.value, "其他");
	}
	public final String value;

	private Prof(String value) {
		this.value = value;
	}

	public static String getProf(String value) {
		return profMap.get(value);
	}
}