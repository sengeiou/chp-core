package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

import com.creditharmony.core.type.SystemFlag;

/**
 * 划扣服务用系统处理ID类型
 * @author 施大勇
 * 2016年02月01日
 */
public enum DeductWays {
	
	CF_01(SystemFlag.FORTUNE.value + "01", "财富划扣"),
	CF_02(SystemFlag.FORTUNE.value + "02", "财富回款"),
	CF_03(SystemFlag.FORTUNE.value + "03", "财富回息"),
	HJ_01(SystemFlag.LOAN.value + "01", "汇金集中回款"),
	HJ_02(SystemFlag.LOAN.value + "02", "汇金非集中回款"),
	HJ_03(SystemFlag.LOAN.value + "03", "汇金放款"),
	HJ_04(SystemFlag.LOAN.value + "04", "汇金服务费催收"),
	HJ_05(SystemFlag.LOAN.value + "05", "汇金综合服务费催收"),
	ZJ_01(SystemFlag.LOAN.value + "08", "中金预约划扣"),
	
	CJ_01(SystemFlag.CARLOAN.value + "05", "车借放款"),
	CJ_02(SystemFlag.CARLOAN.value + "06", "车借催收服务划扣"),
	CJ_03(SystemFlag.CARLOAN.value + "07", "车借服务费退款"),
	
	CJHK_09(SystemFlag.CARLOAN.value + "09", "车借集中还款划扣"),
	CJHK_10(SystemFlag.CARLOAN.value + "10", "车借非集中还款划扣");
	
	private static Map<String, DeductWays> nameMap = new HashMap<String, DeductWays>();
	private static Map<String, DeductWays> codeMap = new HashMap<String, DeductWays>();
	static {
		DeductWays[] allValues = DeductWays.values();
		for (DeductWays obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}
	private String name;
	private String code;

	private DeductWays(String code, String name) {
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

	public static DeductWays parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductWays parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
