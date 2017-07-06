package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 文件制作人员在岗状态
 * 
 * @Class Name FileMakerJobStatus
 * @author 朱杰
 * @Create In 2016年3月19日
 */
public enum FileMakerJobStatus {
	ZG("1"), // 在岗
	LG("0"); // 离岗

	public static Map<String, String> fileMakerJobStatusMap = new Hashtable<String, String>();

	static {
		fileMakerJobStatusMap.put(FileMakerJobStatus.ZG.value, "在岗");
		fileMakerJobStatusMap.put(FileMakerJobStatus.LG.value, "离岗");
	}
	public final String value;

	private FileMakerJobStatus(String value) {
		this.value = value;
	}

	public static String getFileMakerJobStatus(String value) {
		return fileMakerJobStatusMap.get(value);
	}
}