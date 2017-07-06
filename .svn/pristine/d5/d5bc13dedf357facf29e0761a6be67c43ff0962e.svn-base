/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typePayFeeResult.java
 * @Create By 王彬彬
 * @Create In 2016年1月4日 下午5:07:18
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 汇诚退回，汇金修改项目
 * @Class Name PayFeeResult
 * @author 王彬彬
 * @Create In 2016年1月4日
 */
public enum ReturnChangeResult {

	MOBILE("0","手机号"),
	
	NAME("1","姓名"),
	
	IC_CARD("2","身份证"),
	
	HOME_ADDRESS("3","家庭地址"),
	
	EMAIL("4","邮箱"),
	
	MATE_MOBILE("5","配偶手机号"),
	
	MATE_IC_CARD("6","配偶身份证"),
	
	MATE_NAME("7","配偶姓名"),
	
	WORK_NAME("8","单位名称"),
	
	WORK_ADDRESS("9","单位地址"),
	
	TELPHONE("10","固话"),
	
	WORK_TEL("11","单位固话"),
	
	MATE_TEL_PHONE("12","配偶单位固话"),
	
	CONTACT_PHONE("13","联系人电话"),
	
	CONTACT_NAME("14","联系人姓名"),
	
	DEL_CONTACT("15","删除联系人"),
	
	DEL_COBORROWER("16","删除共借人"),
	
	DEGREE("17","学历"),
	
	MARRIED("18","婚姻状况"),
	
	HOUSE_PORI("19","住房性质"),
	
	CONTACT_TYPE_MAIN("20","关系类型"),
	
	CONTACT_TRELATION_MAIN("21","跟本人关系"),
	
	LEGAL_PERSON_CERT("22","法人身份证号"),
	
	LEGAL_PERSON_PHONE("23","法人手机号"),
	
	LEGAL_PERSON_EMAIL("24","法人邮箱"),
	
	LEGAL_PERSON_NAME("25","法人姓名"),
	
	LEGAL_CREDIT_CODE("26","信用代码"),
	
	LEGAL_ORG_CODE("27","组织机构码"),
	
	CONTACT_CERT("28","联系人身份证号");
	
	private static Map<String, ReturnChangeResult> nameMap = new HashMap<String, ReturnChangeResult>(
			50);
	private static Map<String, ReturnChangeResult> codeMap = new HashMap<String, ReturnChangeResult>(
			50);

	static {
		ReturnChangeResult[] allValues = ReturnChangeResult.values();
		for (ReturnChangeResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ReturnChangeResult(String code, String name) {
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

	public static ReturnChangeResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static ReturnChangeResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
