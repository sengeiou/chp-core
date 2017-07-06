package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 呼叫中心当前客户的状态
 * @Class Name CallCenterStatus
 * @author 肖长伟
 * @Create In 2016年3月1日
 */
public enum CallCenterStatus {
	NEW("0", "新增"),
	IN_CITY("1", "在城市"),
	IN_STORE("2", "在门店"),
	IN_TEAM("3", "在团队"),
	HAVE_MANAGER("4", "分配理财经理");
	
	public final String id;
	public final String value;
	
	private CallCenterStatus(String code, String value) {
		this.id = code;
		this.value = value;
	}
	
	public static Map<String, String> callCenterStatus = new HashMap<String, String>();
	
	public String getTeleCustomPoolType(String code) {
		return callCenterStatus.get(code);
	}
	
	public static void initTeleCustomPoolType() {
		if(callCenterStatus.isEmpty()) {
			callCenterStatus.put(CallCenterStatus.NEW.id, "新增");
			callCenterStatus.put(CallCenterStatus.IN_CITY.id, "在城市");
			callCenterStatus.put(CallCenterStatus.IN_STORE.id, "在门店");
			callCenterStatus.put(CallCenterStatus.IN_TEAM.id, "在团队");
			callCenterStatus.put(CallCenterStatus.HAVE_MANAGER.id, "分配理财经理");
		}
	}
}
