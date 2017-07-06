package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 下期债权人是否冻结
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum NextcreditorFrozen {
	MDJ("0"), // 没冻结
	YDJ("1");// 已冻结

	public final String value;

	private NextcreditorFrozen(String value) {
		this.value = value;
	}

	public static String getNextcreditorFrozen(String value) {
		return nextcreditorFrozenMap.get(value);
	}

	public static Map<String, String> nextcreditorFrozenMap = new Hashtable<String, String>();

	public static void initNextcreditorFrozen() {
		if (nextcreditorFrozenMap.isEmpty()) {
			nextcreditorFrozenMap.put(NextcreditorFrozen.MDJ.value, "没冻结");
			nextcreditorFrozenMap.put(NextcreditorFrozen.YDJ.value, "已冻结");
		}
	}
}