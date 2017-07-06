/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeSplitStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月21日 下午8:03:57
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 拆分后数据处理状态
 * 
 * @Class Name SplitStatus
 * @author 王彬彬
 * @Create In 2015年12月21日
 */
public enum SplitDataStatus {
	NO_PROCESS("0", "未处理"),

	SEND_SUCCEED("1", "发送成功"),

	SEND_FAILED("2", "发送处理失败"),

	WAIT_RESULT("3", "等待平台返回结果中"),

	ONLINE_CHANGE("4", "线上修正"),

	INVALID_GLAG("9", "无效标识");

	private static Map<String, SplitDataStatus> nameMap = new HashMap<String, SplitDataStatus>(
			10);
	private static Map<String, SplitDataStatus> codeMap = new HashMap<String, SplitDataStatus>(
			10);

	static {
		SplitDataStatus[] allValues = SplitDataStatus.values();
		for (SplitDataStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SplitDataStatus(String code, String name) {
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

	public static SplitDataStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static SplitDataStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
