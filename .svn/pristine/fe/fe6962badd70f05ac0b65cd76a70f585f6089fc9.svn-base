package com.creditharmony.core.users.type;

import java.util.Hashtable;
import java.util.Map;


/**
 * 汇诚组织机构类型,即核查部门的组织机构类型
 * @Class Name CheckDeptOrgType
 * @author 张永生
 * @Create In 2015年12月22日
 */
public enum ApproveOrgType {

	VERIFY_DEPT("6300000001", "信借审批部"),
	CREDIT_MANAGE("6300000002", "信借管理"),
	CREDIT_FINAL_APPROVE("6300000003", "信借终审"),
	CREDIT_SUPER_FINAL_APPROVE("6300000004", "信借高级终审"),
	RECONSIDER_APPROVE("6300000005", "复议审批"),
	RECONSIDER_MANAGE("6300000006", "复议管理"),  
	RECONSIDER_FINAL_APPROVE("6300000007", "复议终审"),
	ANTIFRAUD_DEPT("6300000008", "反欺诈排查部"),
	COMPREHENSIVE_MANAGE("6300000009", "综合管理部"),
	CAR_DEPT("6300000010", "车借审批部"),
	POLICY_REVIEW("6300000011", "政策研究部"),
	DATA_ANALYSIS("6300000012", "数据分析部"),
	TRAIN_DEPT("6300000013", "培训部"),
	APPROVE_ADMIN_DEPT("6300000014", "汇诚管理员"),
	EXAMINE_MEMBER("6300000015", "稽核部"),
	HUMAN_MANAGE_OFFICE("6300000016", "人管室");
	
	public final String key;
	public final String name;
	
	private ApproveOrgType(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static Map<String, String> typeMap = new Hashtable<String, String>();
	
	public static Map<String, String> getTypeMap(){
		if(typeMap.isEmpty()){
			typeMap.put(VERIFY_DEPT.key, VERIFY_DEPT.name);
			typeMap.put(CREDIT_MANAGE.key, CREDIT_MANAGE.name);
			typeMap.put(CREDIT_FINAL_APPROVE.key, CREDIT_FINAL_APPROVE.name);
			typeMap.put(CREDIT_SUPER_FINAL_APPROVE.key, CREDIT_SUPER_FINAL_APPROVE.name);
			typeMap.put(RECONSIDER_APPROVE.key, RECONSIDER_APPROVE.name);
			typeMap.put(RECONSIDER_MANAGE.key, RECONSIDER_MANAGE.name);
			typeMap.put(RECONSIDER_FINAL_APPROVE.key, RECONSIDER_FINAL_APPROVE.name);
			typeMap.put(ANTIFRAUD_DEPT.key, ANTIFRAUD_DEPT.name);
			typeMap.put(COMPREHENSIVE_MANAGE.key, COMPREHENSIVE_MANAGE.name);
			typeMap.put(CAR_DEPT.key, CAR_DEPT.name);
			typeMap.put(POLICY_REVIEW.key, POLICY_REVIEW.name);
			typeMap.put(DATA_ANALYSIS.key, DATA_ANALYSIS.name);
			typeMap.put(TRAIN_DEPT.key, TRAIN_DEPT.name);
			typeMap.put(APPROVE_ADMIN_DEPT.key, APPROVE_ADMIN_DEPT.name);
			typeMap.put(EXAMINE_MEMBER.key, EXAMINE_MEMBER.name);
			typeMap.put(HUMAN_MANAGE_OFFICE.key, HUMAN_MANAGE_OFFICE.name);
		}
		return typeMap;
	}
	
}
