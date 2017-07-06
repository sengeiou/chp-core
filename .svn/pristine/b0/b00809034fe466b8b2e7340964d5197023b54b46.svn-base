package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/**
 * 在职状态
 * 2016年12月20日
 * @author 郭强
 *
 */
public enum WorkingState {
	ZZ("0"), // 在职
	LZ("1"), // 离职
	K("2");  // 空
	public static Map<String, String> workingStateMap = new Hashtable<String, String>();

	static {
		workingStateMap.put(WorkingState.ZZ.value, "Z");
		workingStateMap.put(WorkingState.LZ.value, "L");
		workingStateMap.put(WorkingState.K.value, "-");
	}
	public final String value;

	private WorkingState(String value) {
		this.value = value;
	}

	public static String getWorkingState(String value) {
		return workingStateMap.get(value);
	}
	
}
