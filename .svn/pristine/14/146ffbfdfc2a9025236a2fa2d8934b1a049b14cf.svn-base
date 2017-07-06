/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCardType.java
 * @Create By 王彬彬
 * @Create In 2016年1月12日 下午6:12:53
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * CE文件夹名称
 * 
 * @Class Name CeFolderType
 * @author 王彬彬
 * @Create In 2016年1月12日
 */
public enum CeFolderType {
	CONTRACT_MAKE("0", "合同制作文件夹"),

	CONTRACT_SIGN("1", "合同签订文件夹(CA加盖)"),

	SIGN_UPLOAD("2", "签约上传文件夹"),
	
	PAYMENT_UPLOAD("3", "还款申请凭条文件夹"),
	
	PAYMENT_POS_UPLOAD("4", "POS还款申请凭条文件夹"),

	URGE_UPLOAD("5", "催收服务费还款文件夹"),
	
	OTHER_UPLOAD("6", "其他上传文件夹"),
	
	ACCOUNT_CHANGE("7", "账户变更文件夹"),
	
	LOAN_CHANGE("8", "申请资料文件夹"),
	
	CAR_CONTRACT_MAKE("9", "车借合同制作文件夹"),
	
	CAR_EXTEND_SIGN_UPLOAD("10", "展期合同制作文件夹"),
	
	CONTRACT_CANCEL("11", "合同作废文件夹");
	
	private static Map<String, CeFolderType> nameMap = new HashMap<String, CeFolderType>(
			15);
	private static Map<String, CeFolderType> codeMap = new HashMap<String, CeFolderType>(
			15);

	static {
		CeFolderType[] allValues = CeFolderType.values();
		for (CeFolderType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CeFolderType(String code, String name) {
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

	public static CeFolderType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CeFolderType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
