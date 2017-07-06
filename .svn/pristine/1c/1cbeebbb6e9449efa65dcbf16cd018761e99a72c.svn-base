/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeUploadFileType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:03:43
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name UploadFileType
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum UploadFileType {
	APPLICATION_CERT("0", "申请证明"),

	IDENTITY_WED("1", "身份证明及婚姻证明"),

	WORK_CERT("3", "工作证明及经营证明"),

	LIVE_CERT("4", "居住证明及资产证明"),

	BANK_STATEMENT("5", "银行流水"),

	CREDIT_REPORT("6", "征信报告"),

	OTHER_INFO("7", "其它资料"),

	VISIT_INFO("8", "外访资料"),

	COBORROW_INFO("9", "共借人资料");

	private static Map<String, UploadFileType> nameMap = new HashMap<String, UploadFileType>(
			20);
	private static Map<String, UploadFileType> codeMap = new HashMap<String, UploadFileType>(
			20);

	static {
		UploadFileType[] allValues = UploadFileType.values();
		for (UploadFileType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private UploadFileType(String code, String name) {
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

	public static UploadFileType parseByName(String name) {
		return nameMap.get(name);
	}

	public static UploadFileType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
