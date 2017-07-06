/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRelation.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:07:57
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name Relation(联系人类型)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RelationType {
	FAMILY_CONTACTS("0","家庭联系人"),
	
	WORK_VOUCHER("1","工作证明人"),
	
	OTHER_CONTACTS("2","其他联系人");
	
	private static Map<String, RelationType> nameMap = new HashMap<String, RelationType>(
			10);
	private static Map<String, RelationType> codeMap = new HashMap<String, RelationType>(
			10);

	static {
		RelationType[] allValues = RelationType.values();
		for (RelationType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RelationType(String code, String name) {
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

	public static RelationType parseByName(String name) {
		return nameMap.get(name);
	}

	public static RelationType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
