/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDeductPlat.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:40:05
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

import com.creditharmony.core.deduct.type.DeductPlatType;

/**
 * @Class Name DeductPlat(划扣平台)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum DeductPlat {
	FUYOU(DeductPlatType.FY.getCode(),"富友"),
	
	HAOYILIAN(DeductPlatType.HYL.getCode(),"好易联"),
	
	ZHONGJIN(DeductPlatType.ZJ.getCode(),"中金"),
	
	TONGLIAN(DeductPlatType.TL.getCode(),"通联"),
	
	ZCJ(DeductPlatType.ZCJ.getCode(),"ZCJ金账户"),
	
	KALIAN(DeductPlatType.KL.getCode(),"卡联"),
	
	CHANGJIE(DeductPlatType.CJT.getCode(),"畅捷");
	
	private static Map<String, DeductPlat> nameMap = new HashMap<String, DeductPlat>(
			10);
	private static Map<String, DeductPlat> codeMap = new HashMap<String, DeductPlat>(
			10);

	static {
		DeductPlat[] allValues = DeductPlat.values();
		for (DeductPlat obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DeductPlat(String code, String name) {
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

	public static DeductPlat parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductPlat parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
