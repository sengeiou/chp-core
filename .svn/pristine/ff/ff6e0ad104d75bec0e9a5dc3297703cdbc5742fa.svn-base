package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 合同审核不通过原因
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ContractPassCause {
	SQSLBNCGTJSLD50("1"), // 申请数量不能超过推荐量的50
	SQSLBXW50H100DBS("2"), // 申请数量必须为50或100的倍数
	CHTBBSWRKZBPF("3");// 此版本合同尚未入库，暂不派发

	public static Map<String, String> contractPassCauseMap = new Hashtable<String, String>();

	static {
		contractPassCauseMap.put(ContractPassCause.SQSLBNCGTJSLD50.value,
				"申请数量不能超过推荐量的50");
		contractPassCauseMap.put(ContractPassCause.SQSLBXW50H100DBS.value,
				"申请数量必须为50或100的倍数");
		contractPassCauseMap.put(ContractPassCause.CHTBBSWRKZBPF.value,
				"此版本合同尚未入库，暂不派发");
	}
	public final String value;

	private ContractPassCause(String value) {
		this.value = value;
	}

	public static String getContractPassCause(String value) {
		return contractPassCauseMap.get(value);
	}
}