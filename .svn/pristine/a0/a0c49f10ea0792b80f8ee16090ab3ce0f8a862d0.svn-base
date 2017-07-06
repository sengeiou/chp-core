/**
 * 
 */
package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 划扣处理任务返回类型
 * @Name Name ResultType 
 * @author 施大勇
 * @Create In 2016年01月27日
 */
public enum ResultType {

	ADD_SUCCESS("0100", "划扣任务已成功提交。"),
	ADD_FAIL("1111", "无可用划扣任务。"),
	POXY_FAIL("9999", "划扣接口调用失败"),
	POXY_SUCCESS("0000", "处理成功"),
	ADD_UPFAILED("8888", "任务提交失败"),
	ADD_RBSUCCESS("0100", "任务解除成功"),
	POXY_WAITTING("3333", "第三方平台处理中");
	
	private static Map<String, ResultType> nameMap = new HashMap<String, ResultType>();
	private static Map<String, ResultType> codeMap = new HashMap<String, ResultType>();
	static {
		ResultType[] allValues = ResultType.values();
		for (ResultType obj : allValues) {
			nameMap.put(obj.getMsg(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String msg;
	private String code;

	private ResultType(String code, String name) {
		this.msg = name;
		this.code = code;

	}

	public String getMsg() {
		return msg;
	}

	public void setName(String name) {
		this.msg = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static ResultType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ResultType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.msg;
	}
}
