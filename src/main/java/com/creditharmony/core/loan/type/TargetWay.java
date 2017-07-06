package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

import com.creditharmony.core.deduct.type.DeductWays;

/**
 * @Class Name TargetWay 还款操作关联类型
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum TargetWay {
	
	PAYMENT(DeductWays.HJ_01.getCode(), "集中还款"),

	SERVICE_FEE(DeductWays.HJ_04.getCode(), "催收服务费"),
	
	JYJ_FEE(DeductWays.HJ_05.getCode(),"简易借综合费用"),
	
	REPAYMENT(DeductWays.HJ_02.getCode(), "非集中还款"),
	
	GRANT(DeductWays.HJ_03.getCode(), "放款"),
	
	CAR_SERVICE_FEE(DeductWays.CJ_02.getCode(), "车借催收服务费");

	private static Map<String, TargetWay> nameMap = new HashMap<String, TargetWay>(
			10);
	private static Map<String, TargetWay> codeMap = new HashMap<String, TargetWay>(
			10);

	static {
		TargetWay[] allValues = TargetWay.values();
		for (TargetWay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TargetWay(String code, String name) {
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

	public static TargetWay parseByName(String name) {
		return nameMap.get(name);
	}

	public static TargetWay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
