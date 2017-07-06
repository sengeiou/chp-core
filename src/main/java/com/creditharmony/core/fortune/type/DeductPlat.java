package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 划扣平台
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum DeductPlat {
	FYPT("0"), // 富友平台
	HYLPT("1"), // 好易联平台
	ZJPT("2"), // 中金平台
	TL("3"),// 通联平台
	KL("6"),// 卡联平台
	CJ("7");// 畅捷平台

	public static Map<String, String> deductPlatMap = new Hashtable<String, String>();
	public static Map<String, String> shortDeductPlatMap = new Hashtable<String, String>();

	static {
		deductPlatMap.put(DeductPlat.HYLPT.value, "好易联平台");
		deductPlatMap.put(DeductPlat.FYPT.value, "富友平台");
		deductPlatMap.put(DeductPlat.ZJPT.value, "中金平台");
		deductPlatMap.put(DeductPlat.TL.value, "通联平台");
		deductPlatMap.put(DeductPlat.KL.value, "卡联平台");
		deductPlatMap.put(DeductPlat.CJ.value, "畅捷平台");
		
		shortDeductPlatMap.put(DeductPlat.HYLPT.value, "好易联");
		shortDeductPlatMap.put(DeductPlat.FYPT.value, "富友");
		shortDeductPlatMap.put(DeductPlat.ZJPT.value, "中金");
		shortDeductPlatMap.put(DeductPlat.TL.value, "通联");
		shortDeductPlatMap.put(DeductPlat.KL.value, "卡联");
		shortDeductPlatMap.put(DeductPlat.CJ.value, "畅捷");
	}
	public final String value;

	private DeductPlat(String value) {
		this.value = value;
	}

	public static String getDeductPlat(String value) {
		return deductPlatMap.get(value);
	}
	public static String getShortDeductPlat(String value) {
		return shortDeductPlatMap.get(value);
	}
}