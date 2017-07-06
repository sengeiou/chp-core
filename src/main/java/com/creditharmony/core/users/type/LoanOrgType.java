package com.creditharmony.core.users.type;

import java.util.Hashtable;
import java.util.Map;


/**
 * 汇金组织机构类型
 * @Class Name LoanOrgType
 * @author 张永生
 * @Create In 2015年12月22日
 */
public enum LoanOrgType {

	BUISNESS_DEPT("6200000001", "汇金业务部"),	
	PROVINCE_COMPANY("6200000002", "省分公司"),
	STORE("6200000003", "门店"),  
	TEAM("6200000004", "团队"),
	DISTRICT("6200000005", "区域"),
	CITY_COMPANY("6200000006", "城市支公司"),
	MOBILE_SALE("6200000007", "电销部"),
	MOBILE_SALE_TEAM("6200000008", "电销团队"),
	DATA_DEPT("6200000009", "数据部"),
	MANAGE_DEPT("6200000010", "汇金管理部"),
	HUMAN_MANAGE_OFFICE("6200000011", "汇金人管室"),
	TELE_REMIND_REPAYMENT("6200000012", "电催中心");
	
	public final String key;
	public final String name;
	
	private LoanOrgType(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static Map<String, String> typeMap = new Hashtable<String, String>();
	
	public static Map<String, String> getTypeMap(){
		if(typeMap.isEmpty()){
			typeMap.put(BUISNESS_DEPT.key, BUISNESS_DEPT.name);
			typeMap.put(PROVINCE_COMPANY.key, PROVINCE_COMPANY.name);
			typeMap.put(STORE.key, STORE.name);
			typeMap.put(TEAM.key, TEAM.name);
			typeMap.put(DISTRICT.key, DISTRICT.name);
			typeMap.put(CITY_COMPANY.key, CITY_COMPANY.name);
			typeMap.put(MOBILE_SALE.key, MOBILE_SALE.name);
			typeMap.put(MOBILE_SALE_TEAM.key, MOBILE_SALE_TEAM.name);
			typeMap.put(DATA_DEPT.key, DATA_DEPT.name);
			typeMap.put(MANAGE_DEPT.key, MANAGE_DEPT.name);
			typeMap.put(HUMAN_MANAGE_OFFICE.key, HUMAN_MANAGE_OFFICE.name);
			typeMap.put(TELE_REMIND_REPAYMENT.key, TELE_REMIND_REPAYMENT.name);
		}
		return typeMap;
	}
	
}
