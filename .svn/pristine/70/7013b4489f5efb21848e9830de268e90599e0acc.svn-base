package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 删除标识
 * @Class Name DeleteFlag
 * @author 朱杰
 * @Create In 2016年4月21日
 */
public enum DeleteFlag { 
	NOT_DELETED("0"), // 未删除
	DELETED("1"); // 删除
	public static Map<String, String> deleteFlagMap = new Hashtable<String, String>();
	static {
		deleteFlagMap.put(DeleteFlag.NOT_DELETED.value, "未删除");
		deleteFlagMap.put(DeleteFlag.DELETED.value, "删除");
	}
	public final String value;

	private DeleteFlag(String value) {
		this.value = value;
	}

	public static String getDeleteFlag(String value) {
		return deleteFlagMap.get(value);
	}

}