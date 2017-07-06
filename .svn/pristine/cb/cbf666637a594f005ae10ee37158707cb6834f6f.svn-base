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
 * @Class Name BlackGreyList(黑/灰名单类型)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum BlackGreyList {
	BLACK_LIST("0","黑名单"),
	GREY_LIST("1","灰名单"),
	INNOCENT_CASE("2","清白件"),
	FALL_BACK("3","退回"),
	UNPROCESSED("4","反欺诈未处理")
;


	private static Map<String, BlackGreyList> nameMap = new HashMap<String, BlackGreyList>(
			100);
	private static Map<String, BlackGreyList> codeMap = new HashMap<String, BlackGreyList>(
			100);

	static {
		BlackGreyList[] allValues = BlackGreyList.values();
		for (BlackGreyList obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private BlackGreyList(String code, String name) {
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

	public static BlackGreyList parseByName(String name) {
		return nameMap.get(name);
	}

	public static BlackGreyList parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
