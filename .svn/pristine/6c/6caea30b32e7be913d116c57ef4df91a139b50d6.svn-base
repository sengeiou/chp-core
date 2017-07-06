/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeChannelFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:43:08
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name ChannelFlag(还款申请类型人)
 * @author 于飞
 * @Create In 2016年11月02日
 */
public enum OperateRole {
	ZHONGHE("1","中和公司查账"),
	
	MENDIAN("0","门店查账"),
	
	ZHONGHEGONGSHANG("中和-中国工商银行","中和-中国工商银行"),
	//中和-中国工商银行账号
	ZHONGHEGONGSHANGBANK("0200204809200036173","0200204809200036173"),
	
	//中和-招商银行账号
	ZHONGHEZHAOSHANGBANK("110921341910603","110921341910603");
	
	private static Map<String, OperateRole> nameMap = new HashMap<String, OperateRole>(
			10);
	private static Map<String, OperateRole> codeMap = new HashMap<String, OperateRole>(
			10);

	static {
		OperateRole[] allValues = OperateRole.values();
		for (OperateRole obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private OperateRole(String code, String name) {
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

	public static OperateRole parseByName(String name) {
		return nameMap.get(name);
	}

	public static OperateRole parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
