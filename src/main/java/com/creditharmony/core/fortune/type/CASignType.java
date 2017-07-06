package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 签名类型
 * 
 * @Class Name CASignType
 * @author 朱杰
 * @Create In 2016年2月24日
 */
public enum CASignType {
	CONTRACT("0"), // 出借合同
	PAYMENTCONFIRMATION("1"), // 收款确认书
	CREDITFILE("2"),// 债权文件
	FYXY("3"),// 富友协议
	CJBG("4"),// 出借变更
	CJRBG("5"),// 出借人变更
	KH("6"),// 开户申请书
	ZF_CONTRACT("7"),// 出借合同作废
	ZF_CREDITFILE("8");// 债权文件作废

	public static Map<String, String> areaTypeMap = new Hashtable<String, String>();

	static {
		areaTypeMap.put(CASignType.CONTRACT.value, "出借合同");
		areaTypeMap.put(CASignType.PAYMENTCONFIRMATION.value, "收款确认书");
		areaTypeMap.put(CASignType.CREDITFILE.value, "债权文件");
		areaTypeMap.put(CASignType.FYXY.value, "富友协议");
		areaTypeMap.put(CASignType.CJBG.value, "出借变更");
		areaTypeMap.put(CASignType.CJRBG.value, "出借人变更");
		areaTypeMap.put(CASignType.KH.value, "开户申请书");
		areaTypeMap.put(CASignType.ZF_CONTRACT.value, "出借合同作废");
		areaTypeMap.put(CASignType.ZF_CREDITFILE.value, "债权文件作废");
	}
	public final String value;

	private CASignType(String value) {
		this.value = value;
	}

	public static String getAreaType(String value) {
		return areaTypeMap.get(value);
	}
}