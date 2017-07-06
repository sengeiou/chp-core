package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 电销公共池数据的类型
 * 
 * @Class Name TeleCustomPoolType
 * @author 肖长伟
 * @Create In 2016年2月1日
 */
public enum TeleCustomPoolType {
	IN_POOL("1"), // 在公共池
	DISTRIBUTE("2"), // 已分配
	SEND_BACK("3"); // 退回电销

	public static Map<String, String> teleCustomPoolTypes = new HashMap<String, String>();

	static {
		teleCustomPoolTypes.put(TeleCustomPoolType.IN_POOL.value, "1");
		teleCustomPoolTypes.put(TeleCustomPoolType.DISTRIBUTE.value, "2");
		teleCustomPoolTypes.put(TeleCustomPoolType.SEND_BACK.value, "3");
	}
	public final String value;

	private TeleCustomPoolType(String value) {
		this.value = value;
	}

	public String getTeleCustomPoolType(String value) {
		return teleCustomPoolTypes.get(value);
	}
}
