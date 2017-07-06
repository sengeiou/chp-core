/**
 * 
 */
package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求任务类型
 * @Name Name TaskStatusType 
 * @author 施大勇
 * @Create In 2016年01月27日
 */
public enum TaskStatusType {

	PENDING("0", "待处理"),
	PROCESSING("1", "处理中"),
	READY("R", "准备正理中"),
	DONE("2", "已处理"),
	BATCHING("4", "批量处理中"),
	WAITTING("3", "等待查询结果中"),
	QUERIES("5", "等待实时结果查询中"),
	ADDED("6", "任务已提交且尚未处理"),
	SENT("9", "结果数据已推送");
	private static Map<String, TaskStatusType> nameMap = new HashMap<String, TaskStatusType>();
	private static Map<String, TaskStatusType> codeMap = new HashMap<String, TaskStatusType>();
	static {
		TaskStatusType[] allValues = TaskStatusType.values();
		for (TaskStatusType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}
	private String name;
	private String code;

	private TaskStatusType(String code, String name) {
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

	public static TaskStatusType parseByName(String name) {
		return nameMap.get(name);
	}

	public static TaskStatusType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
