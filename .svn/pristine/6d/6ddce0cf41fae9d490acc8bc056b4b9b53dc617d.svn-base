package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户公共池标记状态
 * 
 * @Class Name CustomMarkState
 * @author 肖长伟
 * @Create In 2016年2月18日
 */
public enum CustomerMarkState {
	GGC("1"), // 公共池
	DX("2"), // 电销
	QD("3"); // 抢单
	public static Map<String, String> teleCustomPoolTypes = new HashMap<String, String>();

	static {
		teleCustomPoolTypes.put(CustomerMarkState.GGC.value, "1");
		teleCustomPoolTypes.put(CustomerMarkState.DX.value, "2");
		teleCustomPoolTypes.put(CustomerMarkState.QD.value, "3");
	}
	public final String value;

	private CustomerMarkState(String value) {
		this.value = value;
	}

	public String getTeleCustomPoolType(String value) {
		return teleCustomPoolTypes.get(value);
	}
}
