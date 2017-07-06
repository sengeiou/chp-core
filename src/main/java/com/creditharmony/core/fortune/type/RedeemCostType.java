/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCounterofferResult.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:08:35
 */
package com.creditharmony.core.fortune.type;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 费率类型
 * 
 * @Class Name RedeemCostType
 * @author 朱杰
 * @Create In 2015年12月31日
 */
public enum RedeemCostType {
	QX_IN_30_NEW("1", new BigDecimal("0.04")),
	QX_BETWEEN_30_60_NEW("2", new BigDecimal("0.03")),
	QX_AFTER_60_NEW("3", new BigDecimal("0.02")),
	QX_IN_30("4", new BigDecimal("0.02")),
	QX_BETWEEN_30_60("5", new BigDecimal("0.01")),
	QX_AFTER_60("6", BigDecimal.ZERO),
	FQX_IN_7("7", new BigDecimal("0.05")),
	FQX_BETWEEN_7_30_NEW("8", new BigDecimal("0.04")),
	FQX_BETWEEN_30_60_NEW("9", new BigDecimal("0.03")),
	FQX_AFTER_60_NEW("10", new BigDecimal("0.02")),
	WITHOUT_LIMIT("11", new BigDecimal("0.05"));

	private static Map<BigDecimal, RedeemCostType> valueMap = new HashMap<BigDecimal, RedeemCostType>(
			10);
	private static Map<String, RedeemCostType> codeMap = new HashMap<String, RedeemCostType>(
			10);

	static {
		RedeemCostType[] allValues = RedeemCostType.values();
		for (RedeemCostType obj : allValues) {
			valueMap.put(obj.getValue(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private BigDecimal value;
	private String code;

	private RedeemCostType(String code, BigDecimal value) {
		this.value = value;
		this.code = code;

	}

	public BigDecimal getValue() {
		return value;
	}

	public void setName(BigDecimal value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static RedeemCostType parseByValue(BigDecimal value) {
		return valueMap.get(value);
	}

	public static RedeemCostType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
