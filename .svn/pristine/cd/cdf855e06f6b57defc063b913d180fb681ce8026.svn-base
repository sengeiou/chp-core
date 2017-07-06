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
 * (渠道标识)
 * @Class Name LoanModel
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum LoanModel {
	CHP("0",""),
	
	TG("1","TG");
	
	private static Map<String, LoanModel> nameMap = new HashMap<String, LoanModel>(
			10);
	private static Map<String, LoanModel> codeMap = new HashMap<String, LoanModel>(
			10);

	static {
		LoanModel[] allValues = LoanModel.values();
		for (LoanModel obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanModel(String code, String name) {
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

	public static LoanModel parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanModel parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
