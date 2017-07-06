package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 回息平台
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BackInterestPlat {
	// HYLPT("1"), // 好易联平台
	FYPT("0"), // 富友平台
	ZJPT("2"), // 中金平台
	TL("3"), // 通联平台
	JZH("4"), // 金帐户
	WY("5"),// 网银
	KL("6");//卡联平台

	public static Map<String, String> backInterestPlatMap = new Hashtable<String, String>();

	static {
		// backInterestPlatMap.put(BackInterestPlat.HYLPT.value, "好易联平台");
		backInterestPlatMap.put(BackInterestPlat.FYPT.value, "富友平台");
		backInterestPlatMap.put(BackInterestPlat.ZJPT.value, "中金平台");
		backInterestPlatMap.put(BackInterestPlat.TL.value, "通联");
		backInterestPlatMap.put(BackInterestPlat.JZH.value, "金帐户");
		backInterestPlatMap.put(BackInterestPlat.WY.value, "网银");
		backInterestPlatMap.put(BackInterestPlat.KL.value, "卡联平台");
	}
	public final String value;

	private BackInterestPlat(String value) {
		this.value = value;
	}

	public static String getBackInterestPlat(String value) {
		return backInterestPlatMap.get(value);
	}
}