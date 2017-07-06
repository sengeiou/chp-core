package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 赎回类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum RedeemType {
	BFSH("1"), // 部分赎回
	QBSH("2");// 全部赎回

	public static Map<String, String> redeemTypeMap = new Hashtable<String, String>();

	static {
		redeemTypeMap.put(RedeemType.BFSH.value, "部分赎回");
		redeemTypeMap.put(RedeemType.QBSH.value, "全部赎回");
	}
	public final String value;

	private RedeemType(String value) {
		this.value = value;
	}

	public static String getRedeemType(String value) {
		return redeemTypeMap.get(value);
	}
}