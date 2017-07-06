package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name FileNumber(影像文件夹)
 * @author WJJ
 * @Create In 2017年5月5日
 */
public enum FileNumber {
	
	ENTRUST_DEDUCTION("309110122","委托划扣"),
	
	OTHER_FILE("309110125","其它材料"),
	
	EARLY_CLEAN("30911031","提前结清"),
    
    EMAIL_CHANGE("30911029","邮箱变更"),
    
    PHONE_CHANGE("30911030","手机号变更"),
    
    CARD_MCHANGE("30911032","卡号变更");

	private static Map<String, FileNumber> nameMap = new HashMap<String, FileNumber>(
			10);
	private static Map<String, FileNumber> codeMap = new HashMap<String, FileNumber>(
			10);

	static {
		FileNumber[] allValues = FileNumber.values();
		for (FileNumber obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FileNumber(String code, String name) {
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

	public static FileNumber parseByName(String name) {
		return nameMap.get(name);
	}

	public static FileNumber parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
