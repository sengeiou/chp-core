package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 合同状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ContractState {
	KC("0"), // 库存
	YFP("1"), // 已分配
	YSZF("2"), // 遗失作废
	QCZF("3"), // 签错作废
	CJSPZ("4"), // 出借审批中
	YCJ("5"), // 已出借
	BBZF("6"),// 版本作废
	ZFSPZ("7"),//作废审批中
	SPTH("8");//审批退回

	public static Map<String, String> contractStateMap = new Hashtable<String, String>();

	static {
		contractStateMap.put(ContractState.KC.value, "库存");
		contractStateMap.put(ContractState.YFP.value, "已分配");
		contractStateMap.put(ContractState.YSZF.value, "遗失作废");
		contractStateMap.put(ContractState.QCZF.value, "签错作废");
		contractStateMap.put(ContractState.CJSPZ.value, "出借审批中");
		contractStateMap.put(ContractState.YCJ.value, "已出借");
		contractStateMap.put(ContractState.BBZF.value, "版本作废");
		contractStateMap.put(ContractState.ZFSPZ.value, "作废审批中");
		contractStateMap.put(ContractState.SPTH.value, "审批退回");
	}
	
	public final String value;

	private ContractState(String value) {
		this.value = value;
	}

	public static String getContractState(String value) {
		return contractStateMap.get(value);
	}
}