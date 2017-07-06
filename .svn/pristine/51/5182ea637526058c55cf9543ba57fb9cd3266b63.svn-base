/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDeductTime.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:16:17
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

import com.creditharmony.core.deduct.type.DeductType;

/**
 * @Class Name DeductTime 划扣方式(实时、批量)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum DeductTime {
	RIGHTNOW(DeductType.REALTIME.getCode(), "实时"),

	BATCH(DeductType.BATCH.getCode(), "批量");

	private static Map<String, DeductTime> nameMap = new HashMap<String, DeductTime>(
			2);
	private static Map<String, DeductTime> codeMap = new HashMap<String, DeductTime>(
			2);

	static {
		DeductTime[] allValues = DeductTime.values();
		for (DeductTime obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DeductTime(String code, String name) {
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

	public static DeductTime parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductTime parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
