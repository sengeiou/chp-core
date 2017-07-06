/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRepayChannel.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:06:10
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * (还款方式，划扣，汇款/转账，POS机刷卡/POS机刷卡查账)
 * @Class Name RepayChannel
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RepayChannel {

	DEDUCT("0", "划扣"),

	NETBANK_CHARGE("1", "汇款/转账"),

	POS("2", "POS机刷卡"),

	POS_CHECK("3", "POS机刷卡查账");

	private static Map<String, RepayChannel> nameMap = new HashMap<String, RepayChannel>(
			10);
	private static Map<String, RepayChannel> codeMap = new HashMap<String, RepayChannel>(
			10);

	static {
		RepayChannel[] allValues = RepayChannel.values();
		for (RepayChannel obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RepayChannel(String code, String name) {
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

	public static RepayChannel parseByName(String name) {
		return nameMap.get(name);
	}

	public static RepayChannel parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
