/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.AgainstContent.java
 * @Create By 张进
 * @Create In 2016年1月6日 
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 冲抵内容
 * 
 * @Class Name AgainstContent
 * @author 张进
 * @Create In 2016年1月6日
 */
public enum AgainstContent {
	/**
	 * 分期服务费
	 */
	MONTHSERVICEFEE("0", "冲分期服务费"),
	
	/**
	 * 利息
	 */
	MONTHINTEREST("1", "冲利息"),

	/**
	 * 本金
	 */
	MONTHPRINCIPAL("2", "冲本金"),

	/**
	 * 违约金
	 */
	VIOLATE("3", "冲违约金"),

	/**
	 * 罚息
	 */
	PUNISH("4", "冲罚息"),

	/**
	 * 滞纳金
	 */
	SURCHARGE("5", "冲滞纳金"),
	
	PAYBACK_CHARGE("6", "还款查账"),
	
	CENTERDEDUCT("8", "集中划扣"),
	
	PAYBACK_DEDUCT("9", "还款划扣 "),
	
	URGE_CHARGE("10", "催收服务费转入"),
	
	JYJ_CHARGE("13","综合费用转入"),
	
	CHARGE_AMOUNT("11", "冲抵提前结清金额"),
	
    GOLD_AMOUNT("12", "金账户划扣"),
    
	COMPREHENSIVE_SERVICE("13", "综合服务费转入");

	 
	private static Map<String, AgainstContent> nameMap = new HashMap<String, AgainstContent>(
			15);
	private static Map<String, AgainstContent> codeMap = new HashMap<String, AgainstContent>(
			15);

	static {
		AgainstContent[] allValues = AgainstContent.values();
		for (AgainstContent obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AgainstContent(String code, String name) {
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

	public static AgainstContent parseByName(String name) {
		return nameMap.get(name);
	}

	public static AgainstContent parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
