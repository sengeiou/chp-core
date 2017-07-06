package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/***
 * 回款期限
 * 
 * @Class name RedeemBackDeadline
 * @author 朱杰
 * @Create In 2015年12月31日
 */
public enum RedeemBackDeadline {
	QX_IN_30_NEW("1","30日内(含当日)"),
	QX_BETWEEN_30_60_NEW("2","30日后、60日内"),
	QX_AFTER_60_NEW("3","60日后"),
	QX_IN_30("4","30日内"),
	QX_BETWEEN_30_60("5","30日后60日内"),
	QX_AFTER_60("6","60日后"),
	FQX_IN_7("7","7日内"),
	FQX_BETWEEN_7_30_NEW("8","7日后30日内"),
	FQX_BETWEEN_30_60_NEW("9","30日后60日内"),
	FQX_AFTER_60_NEW("10","60日后90日内"),
	WITHOUT_LIMIT("11","");
	
	private static Map<String, RedeemBackDeadline> codeMap = new HashMap<String, RedeemBackDeadline>(
			10);
	private static Map<String, RedeemBackDeadline> valueMap = new HashMap<String, RedeemBackDeadline>(
			10);

	static {
		RedeemBackDeadline[] allValues = RedeemBackDeadline.values();
		for (RedeemBackDeadline obj : allValues) {			
			codeMap.put(obj.getCode(), obj);
			valueMap.put(obj.getValue(), obj);
		}
	}

	private String value;
	private String code;

	private RedeemBackDeadline(String code, String value) {
		
		this.code = code;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static RedeemBackDeadline parseByValue(String value) {
		return valueMap.get(value);
	}

	public static RedeemBackDeadline parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.value;
	}
}