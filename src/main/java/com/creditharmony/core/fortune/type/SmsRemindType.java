package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

public enum SmsRemindType {
	/** 消息提醒类型 前10天提醒 */
	QSTDQTX("1"),
	/** 消息提醒类型 前30天提醒 */
	QSSTFBQTX("2"),
	/** 消息提醒类型 到期提醒 */
	DQTX("3"),
	/** 划扣申批短信提醒 */
	HKSPXXTQ("4"),
	/** 划扣失败短信提醒 */
	HKSBXXTQ("5"),
	/** 划扣成功短信提醒 */
	HKCGXXTQ("6"),
	/** 回款短信提醒 */
	HKDXTQ("7"),
	/** 回息短信提醒 */
	HXDXTQ("8");

	public static Map<String, String> smsRemindTypeMap = new Hashtable<String, String>();

	static {
		smsRemindTypeMap.put(SmsRemindType.QSTDQTX.value, "消息提醒类型 前10天提醒");
		smsRemindTypeMap.put(SmsRemindType.QSSTFBQTX.value, "消息提醒类型 前30天提醒");
		smsRemindTypeMap.put(SmsRemindType.QSSTFBQTX.value, "消息提醒类型 到期提醒");
		smsRemindTypeMap.put(SmsRemindType.HKSPXXTQ.value, "划扣申批短信提醒");
		smsRemindTypeMap.put(SmsRemindType.HKSBXXTQ.value, "划扣失败短信提醒");
		smsRemindTypeMap.put(SmsRemindType.HKCGXXTQ.value, "划扣成功短信提醒");
		smsRemindTypeMap.put(SmsRemindType.HKDXTQ.value, "回款短信提醒");
		smsRemindTypeMap.put(SmsRemindType.HXDXTQ.value, "回息短信提醒");
	}
	public final String value;

	private SmsRemindType(String value) {
		this.value = value;
	}

	public static String getSmsRemindType(String value) {
		return smsRemindTypeMap.get(value);
	}
}
