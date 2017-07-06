package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 文件合成状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum FilecpState {
	WHC("0"), // 未合成
	HCCG("1"), // 合成成功
	HCSB("2"), // 合成失败
	ZZHC("3"),// 正在合成
	FQ("4");// 废弃

	public final String value;

	private FilecpState(String value) {
		this.value = value;
	}

	public static String getFilecpState(String value) {
		return filecpStateMap.get(value);
	}

	public static Map<String, String> filecpStateMap = new Hashtable<String, String>();

	public static void initFilecpState() {
		if (filecpStateMap.isEmpty()) {
			filecpStateMap.put(FilecpState.WHC.value, "未合成");
			filecpStateMap.put(FilecpState.HCCG.value, "合成成功");
			filecpStateMap.put(FilecpState.HCSB.value, "合成失败");
			filecpStateMap.put(FilecpState.ZZHC.value, "正在合成");
			filecpStateMap.put(FilecpState.FQ.value, "废弃");
		}
	}
}