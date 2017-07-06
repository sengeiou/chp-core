package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 大区类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum RegionalType {
	FGSZJL("3"), // 分公司总经理
	FGSFJL("5"), // 分公司副经理
	SJZY("11");// 数据专员

	public static Map<String, String> regionalTypeMap = new Hashtable<String, String>();

	static {
		regionalTypeMap.put(RegionalType.FGSZJL.value, "分公司总经理");
		regionalTypeMap.put(RegionalType.FGSFJL.value, "分公司副经理");
		regionalTypeMap.put(RegionalType.SJZY.value, "数据专员");
	}
	public final String value;

	private RegionalType(String value) {
		this.value = value;
	}

	public static String getRegionalType(String value) {
		return regionalTypeMap.get(value);
	}
}