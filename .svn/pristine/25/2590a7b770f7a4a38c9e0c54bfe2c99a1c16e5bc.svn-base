package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 沟通方式
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CommunicationMode {
	SM("1"), // 上门
	YY("2"), // 邀约
	DX("3"), // 短信
	YJ("4"), // 邮件
	WX("5"), // 微信
	QQ("6"), // QQ
	DH("7"), // 电话
	MT("8");// 面谈

	public static Map<String, String> communicationModeMap = new Hashtable<String, String>();

	static {
		communicationModeMap.put(CommunicationMode.SM.value, "上门");
		communicationModeMap.put(CommunicationMode.YY.value, "邀约");
		communicationModeMap.put(CommunicationMode.DX.value, "短信");
		communicationModeMap.put(CommunicationMode.YJ.value, "邮件");
		communicationModeMap.put(CommunicationMode.WX.value, "微信");
		communicationModeMap.put(CommunicationMode.QQ.value, "QQ");
		communicationModeMap.put(CommunicationMode.DH.value, "电话");
		communicationModeMap.put(CommunicationMode.MT.value, "面谈");
	}
	public final String value;

	private CommunicationMode(String value) {
		this.value = value;
	}

	public static String getCommunicationMode(String value) {
		return communicationModeMap.get(value);
	}
}