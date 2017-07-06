package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 影像归档状态
 * @Class Name ImageArchiveStatus
 * @author zqa
 * @Create In 2017年3月21日
 */
public enum ImageArchiveStatus {

	INITSTATUS("0", "未发送"),
	
	BEENSEND("1", "已发送"),

	VERIFYSUCCESS("2", "确认成功"),

	VERIFYFAIL("3", "确认失败");

	private static Map<String, ImageArchiveStatus> nameMap = new HashMap<String, ImageArchiveStatus>(
			10);
	private static Map<String, ImageArchiveStatus> codeMap = new HashMap<String, ImageArchiveStatus>(
			10);

	static {
		ImageArchiveStatus[] allValues = ImageArchiveStatus.values();
		for (ImageArchiveStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ImageArchiveStatus(String code, String name) {
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

	public static ImageArchiveStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static ImageArchiveStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
