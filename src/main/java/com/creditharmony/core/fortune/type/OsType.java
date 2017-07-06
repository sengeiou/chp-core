package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 三网用系统标识
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum OsType {
	CHP("XH_CHP"), // CHP
	JX("XH_JX"), // 金信
	CX("XH_CX"), // 创新
	CRM("XH_CRM"), // CRM
	DJR("XH_DJR"), // 大金融
	XHLT("XH_XHLT"), // 星火乐投
	OTHER("XH_OTHER"), // 其他系统
	ZCJ("XH_ZCJ");// 资产家
	public static Map<String, String> osTypeMap = new Hashtable<String, String>();

	static {
		osTypeMap.put(OsType.CHP.value, "CHP");
		osTypeMap.put(OsType.JX.value, "金信");
		osTypeMap.put(OsType.CX.value, "创新");
		osTypeMap.put(OsType.CRM.value, "CRM");
		osTypeMap.put(OsType.DJR.value, "大金融");
		osTypeMap.put(OsType.XHLT.value, "星火乐投");
		osTypeMap.put(OsType.ZCJ.value, "资产家");
	}
	public final String value;

	private OsType(String value) {
		this.value = value;
	}

	public static String getDataSource(String value) {
		return osTypeMap.get(value);
	}
}