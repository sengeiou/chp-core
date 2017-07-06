/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeTradeType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:00:23
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

import com.creditharmony.core.deduct.type.DeductPlatType;

/**
 * 追回方式
 * @Class Name TradeRecove
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum TradeRecove {
	FUYOU(DeductPlatType.FY.getCode(),"富友"),
	
	HAOYILIAN(DeductPlatType.HYL.getCode(),"好易联"),
	
	ZHONGJIN(DeductPlatType.ZJ.getCode(),"中金"),
	
	TONGLIAN(DeductPlatType.TL.getCode(),"通联"),

	BLUE_CHARGE("4","蓝补冲抵"),
	
	DEDUCTED("5","已扣除");

	private static Map<String, TradeRecove> nameMap = new HashMap<String, TradeRecove>(
			10);
	private static Map<String, TradeRecove> codeMap = new HashMap<String, TradeRecove>(
			10);

	static {
		TradeRecove[] allValues = TradeRecove.values();
		for (TradeRecove obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TradeRecove(String code, String name) {
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

	public static TradeRecove parseByName(String name) {
		return nameMap.get(name);
	}

	public static TradeRecove parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
