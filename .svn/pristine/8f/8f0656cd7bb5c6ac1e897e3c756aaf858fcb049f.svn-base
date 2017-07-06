package com.creditharmony.core.users.type;

import java.util.Hashtable;
import java.util.Map;

/**
 * 组织机构类型
 * @Class Name OrgType
 * @author 张永生
 * @Create In 2015年12月5日
 */
public enum OrgType {
	
	COMPANY("1", "公司"), 			   			
	DEPARTMENT("2", "部门");
	
	public final String value;
	public final String name;
	
	private OrgType(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getTypeName(String value) {
		return typeMap.get(value);
	}

	public static Map<String, String> typeMap = new Hashtable<String, String>();

	public static Map<String, String> getTypes() {
		if (typeMap.isEmpty()) {
			typeMap.put(OrgType.COMPANY.value, OrgType.COMPANY.name);
			typeMap.put(OrgType.DEPARTMENT.value, OrgType.DEPARTMENT.name);
		}
		return typeMap;
	}
	
}
