package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/**
 * 优先回款状态
 * @Class Name PriorityBackStatus
 * @author 郭强
 * @Create In 2017年3月24日
 */
public enum PriorityBackState {
	DSP("1"),
	SPTG("2"),
	SPWTG("3"),
	YCX("4");
	public final String value;
	private PriorityBackState(String value) {
		this.value = value;
	}

	public static String getPrioritybackstateMap(String value) {
		return prioritybackstateMap.get(value);
	}
	
	public static Map<String, String> prioritybackstateMap = new Hashtable<String, String>();
	static {
		 prioritybackstateMap.put(PriorityBackState.DSP.value, "待审批");
		 prioritybackstateMap.put(PriorityBackState.SPTG.value, "已通过"); 	
		 prioritybackstateMap.put(PriorityBackState.SPWTG.value, "未通过");
		 prioritybackstateMap.put(PriorityBackState.YCX.value, "已撤销");
	}
}
