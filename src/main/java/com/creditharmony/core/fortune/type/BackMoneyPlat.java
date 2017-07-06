package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 回款平台
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BackMoneyPlat {
	// HYLPT("1"), // 好易联平台
	FYPT("0"), // 富友平台
	ZJPT("2"), // 中金平台
	TL("3"), // 通联平台
	JZH("4"), // 金帐户
	WY("5"),// 网银
	KL("6");// 卡联

	public static Map<String, String> backMoneyPlatMap = new Hashtable<String, String>();

	static {
		// backMoneyPlatMap.put(BackMoneyPlat.HYLPT.value, "好易联平台");
		backMoneyPlatMap.put(BackMoneyPlat.FYPT.value, "富友平台");
		backMoneyPlatMap.put(BackMoneyPlat.ZJPT.value, "中金平台");
		backMoneyPlatMap.put(BackMoneyPlat.JZH.value, "金帐户");
		backMoneyPlatMap.put(BackMoneyPlat.WY.value, "网银");
		backMoneyPlatMap.put(BackMoneyPlat.TL.value, "通联平台");
		backMoneyPlatMap.put(BackMoneyPlat.KL.value, "卡联平台");
	}
	public final String value;

	private BackMoneyPlat(String value) {
		this.value = value;
	}

	public static String getBackMoneyPlat(String value) {
		return backMoneyPlatMap.get(value);
	}
}