package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 合同归属
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ContractOwner {
	MDKC("1"), // 门店库存
	LCJL("2");// 理财经理

	public static Map<String, String> contractOwnerMap = new Hashtable<String, String>();

	static {
		contractOwnerMap.put(ContractOwner.MDKC.value, "门店库存");
		contractOwnerMap.put(ContractOwner.LCJL.value, "理财经理");
	}
	public final String value;

	private ContractOwner(String value) {
		this.value = value;
	}

	public static String getContractOwner(String value) {
		return contractOwnerMap.get(value);
	}
}