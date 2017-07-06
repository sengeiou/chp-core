package com.creditharmony.core.users.type;

import java.util.Hashtable;
import java.util.Map;


/**
 * 惠民组织机构类型,即总部的组织机构类型
 * @Class Name BaseDeptOrgType
 * @author 张永生
 * @Create In 2015年12月22日
 */
public enum BaseDeptOrgType {

	LOANER_DEPT("6100000001", "借款人服务部"), 				    
	LENDER_DEPT("6100000002", "出借人服务部"), 					   
	DATA_DEPT("6100000003", "数据管理部"),	
	RISK_DEPT("6100000004", "风险管理部"), 				    
	REQ_PRODUCT_DEPT("6100000005", "需求分析与产品部"), 					   
	MAINTENANCE_DEPT("6100000006", "总部运维部"),
	BASE_DEPT("6100000007", "总部"),
	CONTRACT_APPROVE_TEAM("6100000008", "合同审核小组"),
	CONTRACT_RATEAPPROVE_TEAM("6100000009", "合同制作小组"),
	CALL_CUSTOMER_SERVICE("6100000010", "客户服务中心"),
	XINHE_DAJINRONG("6100000011", "信和大金融"),
	HUIMIN_BIZ_DEPT("6100000012", "惠民事业部");
	

	public final String key;
	public final String name;
	
	private BaseDeptOrgType(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static Map<String, String> typeMap = new Hashtable<String, String>();
	
	public static Map<String, String> getTypeMap(){
		if(typeMap.isEmpty()){
			typeMap.put(LOANER_DEPT.key, LOANER_DEPT.name);
			typeMap.put(LENDER_DEPT.key, LENDER_DEPT.name);
			typeMap.put(DATA_DEPT.key, DATA_DEPT.name);
			typeMap.put(RISK_DEPT.key, RISK_DEPT.name);
			typeMap.put(REQ_PRODUCT_DEPT.key, REQ_PRODUCT_DEPT.name);
			typeMap.put(MAINTENANCE_DEPT.key, MAINTENANCE_DEPT.name);
			typeMap.put(BASE_DEPT.key, BASE_DEPT.name);
			typeMap.put(CONTRACT_APPROVE_TEAM.key, CONTRACT_APPROVE_TEAM.name);
			typeMap.put(CONTRACT_RATEAPPROVE_TEAM.key, CONTRACT_RATEAPPROVE_TEAM.name);
			typeMap.put(XINHE_DAJINRONG.key, XINHE_DAJINRONG.name);
			typeMap.put(HUIMIN_BIZ_DEPT.key, HUIMIN_BIZ_DEPT.name);
		}
		return typeMap;
	}
	
}
