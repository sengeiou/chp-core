package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 出借相关变更类型
 * 
 * @Class Name LendchgType
 * @author 朱杰
 * @Create In 2015年12月30日
 */
public enum LendchgType {
	LENDER_CHG("1"), // 出借人变更
	LEND_CHG("2"),//  出借变更
	CUSTOMER_CHG("3"),//客户信息变更
	TRUSTESSHIP_PHONE_CHA("4"),// 金账户手机号变更
	TRUSTESSHIP_CARD_CHA("5"),// 金账户银行卡变更
	TRUSTESSHIP_CANCELLATION("6");// 金账户销户

	public static Map<String, String> LendchgTypeMap = new Hashtable<String, String>();

	static{
		LendchgTypeMap.put(LendchgType.LENDER_CHG.value, "出借人变更");
		LendchgTypeMap.put(LendchgType.LEND_CHG.value, "出借变更");
		LendchgTypeMap.put(LendchgType.CUSTOMER_CHG.value, "客户信息变更");
		LendchgTypeMap.put(LendchgType.TRUSTESSHIP_PHONE_CHA.value, "金账户手机号变更");
		LendchgTypeMap.put(LendchgType.TRUSTESSHIP_CARD_CHA.value, "金账户银行卡变更");
		LendchgTypeMap.put(LendchgType.TRUSTESSHIP_CANCELLATION.value, "金账户销户");
	}
	public final String value;

	private LendchgType(String value) {
		this.value = value;
	}

	public static String getLendchgType(String value) {
		return LendchgTypeMap.get(value);
	}
}