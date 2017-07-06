package com.creditharmony.core.users.type;

import java.util.Hashtable;
import java.util.Map;


/**
 * 财富组织机构类型
 * @Class Name FortuneOrgType
 * @author 张永生
 * @Create In 2015年12月22日
 */
public enum FortuneOrgType {

	BUSINESS_DEPT("6400000001", "财富事业部"),
	DISTRICT("6400000002", "分公司"),   			    	
	CITY("6400000003", "支公司"), 						
	STORE("6400000004", "营业部"), 			        
	TEAM("6400000005", "团队"),
	CENTER("6400000007", "财富中心"),
	TELE("6400000008", "电销部"),
	HUMAN_MANAGE_OFFICE("6400000009", "人管室"),
	DATA_DEPT("6400000010", "数据部"),
	MANAGE_DEPT("6400000011", "财富管理部");
	
	
	public final String key;
	public final String name;
	
	private FortuneOrgType(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static Map<String, String> typeMap = new Hashtable<String, String>();
	
	public static Map<String, String> getTypeMap(){
		if(typeMap.isEmpty()){
			typeMap.put(BUSINESS_DEPT.key, BUSINESS_DEPT.name);
			typeMap.put(DISTRICT.key, DISTRICT.name);
			typeMap.put(CITY.key, CITY.name);
			typeMap.put(STORE.key, STORE.name);
			typeMap.put(TEAM.key, TEAM.name);
			typeMap.put(CENTER.key, CENTER.name);
			typeMap.put(HUMAN_MANAGE_OFFICE.key, HUMAN_MANAGE_OFFICE.name);
			typeMap.put(DATA_DEPT.key, DATA_DEPT.name);
		}
		return typeMap;
	}
	
}
