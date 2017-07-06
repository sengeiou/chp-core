package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 总部类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum HqType {
	CJBDJR("7"), // 出借部对接人
	CJBJL("8"), // 出借部经理
	QT("99");// 其他

	public final String value;

	private HqType(String value) {
		this.value = value;
	}

	public static String getHqType(String value) {
		return hqTypeMap.get(value);
	}

	public static Map<String, String> hqTypeMap = new Hashtable<String, String>();

	public static void initHqType() {
		if (hqTypeMap.isEmpty()) {
			hqTypeMap.put(HqType.CJBDJR.value, "出借部对接人");
			hqTypeMap.put(HqType.CJBJL.value, "出借部经理");
			hqTypeMap.put(HqType.QT.value, "其他");
		}
	}
}