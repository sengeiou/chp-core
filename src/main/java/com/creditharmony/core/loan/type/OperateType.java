package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

import com.creditharmony.core.deduct.type.DeductWays;

/**
 * @Class Name OperateType(操作类型-划扣)
 * @author 王彬彬
 * @Create In 2015年12月22日
 */
public enum OperateType {
	
	COLLECT_DEDUCT(DeductWays.HJ_01.getCode(), "待集中划扣"),

	PAYMENT_DEDUCT(DeductWays.HJ_02.getCode(), "待还款划扣"),
	
	SERVICE_FEE(DeductWays.HJ_04.getCode(),"催收服务费"),
	
	SERVICE_PAY(DeductWays.HJ_03.getCode(),"放款"),
	
	CAR_PAYMENT_DEDUCT(DeductWays.CJHK_10.getCode(),"车借待还款划扣"),
	
	CAR_COLLECT_DEDUCT(DeductWays.CJHK_09.getCode(),"车借待集中划扣");

	private static Map<String, OperateType> nameMap = new HashMap<String, OperateType>(
			10);
	private static Map<String, OperateType> codeMap = new HashMap<String, OperateType>(
			10);

	static {
		OperateType[] allValues = OperateType.values();
		for (OperateType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private OperateType(String code, String name) {
		this.name = name;
		this.code = code;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static OperateType parseByName(String name) {
		return nameMap.get(name);
	}

	public static OperateType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
