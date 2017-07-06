package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 变更类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ContractChangeType {
	YS("1"), // 遗失
	ZF("2"), // 作废
	ZJ("3");// 转借

	public static Map<String, String> contractChangeTypeMap = new Hashtable<String, String>();

	static{
		if (contractChangeTypeMap.isEmpty()) {
			contractChangeTypeMap.put(ContractChangeType.YS.value, "遗失");
			contractChangeTypeMap.put(ContractChangeType.ZF.value, "作废");
			contractChangeTypeMap.put(ContractChangeType.ZJ.value, "转借");
		}
	}
	public final String value;

	private ContractChangeType(String value) {
		this.value = value;
	}

	public static String getContractChangeType(String value) {
		return contractChangeTypeMap.get(value);
	}
}