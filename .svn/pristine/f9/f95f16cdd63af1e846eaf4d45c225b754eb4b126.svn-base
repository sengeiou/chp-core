/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name AfraudListSource(反欺诈黑灰名单来源)
 * @author 李静辉
 * @Create In 2016年1月7日
 */
public enum AfraudListSource {
	OUTSIDE_PLUS_BLACK("0","外部"),
	INSIDE_PLUS_BLACK_GREY("1","内部")
;
	
	private static Map<String, AfraudListSource> nameMap = new HashMap<String, AfraudListSource>(
			100);
	private static Map<String, AfraudListSource> codeMap = new HashMap<String, AfraudListSource>(
			100);

	static {
		AfraudListSource[] allValues = AfraudListSource.values();
		for (AfraudListSource obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AfraudListSource(String code, String name) {
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

	public static AfraudListSource parseByName(String name) {
		return nameMap.get(name);
	}

	public static AfraudListSource parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
