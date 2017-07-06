package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

import com.creditharmony.core.deduct.type.DeductType;

/***
 * 划扣接口方式
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum DeductinterType {
	SS(DeductType.REALTIME.getCode()), // 实时
	PL(DeductType.BATCH.getCode());// 批量

	public static Map<String, String> deductinterTypeMap = new Hashtable<String, String>();

	static {
		deductinterTypeMap.put(DeductType.REALTIME.getCode(), "实时");
		deductinterTypeMap.put(DeductType.BATCH.getCode(), "批量");
	}

	public final String value;

	private DeductinterType(String value) {
		this.value = value;
	}

	public static String getDeductinterType(String value) {
		return deductinterTypeMap.get(value);
	}
}