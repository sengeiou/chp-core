package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 团队类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum GroupType {
	LCJL("1"), // 理财经理
	TDJL("2");// 团队经理

	public final String value;

	private GroupType(String value) {
		this.value = value;
	}

	public static String getGroupType(String value) {
		return groupTypeMap.get(value);
	}

	public static Map<String, String> groupTypeMap = new Hashtable<String, String>();

	public static void initGroupType() {
		if (groupTypeMap.isEmpty()) {
			groupTypeMap.put(GroupType.LCJL.value, "理财经理");
			groupTypeMap.put(GroupType.TDJL.value, "团队经理");
		}
	}
}