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
 * @Class Name AfraudListType(反欺诈内部加黑灰类型)
 * @author 李静辉
 * @Create In 2016年1月7日
 */
public enum AfraudListType {
	APPLICANT_CELL_PHONE_NUMBER_1("0","申请人手机号1"),
	APPLICANT_CELL_PHONE_NUMBER_2("1","申请人手机号2"),
	APPLICANT_ID_NUMBER("2","申请人证件号"),
	FIXED_TELEPHONE_NUMBER_OF_THE_APPLICANT("3","申请人固定电话"),
	RESIDENTIAL_ADDRESS_OF_THE_APPLICANT("4","申请人住宅地址"),
	UNIT_NAME("5","单位名称"),
	UNIT_ADDRESS("6","单位地址"),
	WORKPHONE("7","单位电话"),
	SPOUSE_CELL_PHONE_NUMBER("8","配偶手机号"),
	SPOUSE_ID_NUMBER("9","配偶证件号"),
	CONTACT_PHONE_NUMBER("10","联系人手机号"),
	CONTACT_HOME_TEL("11","联系人宅电"),
	SPOUSE_ADDRESS("12","配偶地址")
;


	private static Map<String, AfraudListType> nameMap = new HashMap<String, AfraudListType>(
			100);
	private static Map<String, AfraudListType> codeMap = new HashMap<String, AfraudListType>(
			100);

	static {
		AfraudListType[] allValues = AfraudListType.values();
		for (AfraudListType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AfraudListType(String code, String name) {
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

	public static AfraudListType parseByName(String name) {
		return nameMap.get(name);
	}

	public static AfraudListType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
