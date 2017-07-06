package com.creditharmony.core.pay.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 富有对应证件类型
 * @Class Name PayCertificateTypeType
 * @author 朱杰
 * @Create In 2016年1月11日
 */
public enum PayCertificateType {
	SFZ("0", "身份证"),
	HZ("1", "护照"),
	JGZ("2", "军官证"),
	SBZ("3", "士兵证"),
	HXZ("4", "回乡证"),
	HKB("5", "户口本"),
	WGHZ("6", "外国护照"),
	QT("7", "其他");
	
	private static Map<String, PayCertificateType> nameMap = 
			new HashMap<String, PayCertificateType>();
	private static Map<String, PayCertificateType> codeMap = 
			new HashMap<String, PayCertificateType>();
	static {
		PayCertificateType[] allValues = PayCertificateType.values();
		for (PayCertificateType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PayCertificateType(String code, String name) {
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

	public static PayCertificateType parseByName(String name) {
		return nameMap.get(name);
	}

	public static PayCertificateType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
