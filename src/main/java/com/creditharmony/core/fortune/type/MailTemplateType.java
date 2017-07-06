package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 邮件模板类型
 * @Class Name MailTemplateType
 * @author 朱杰
 * @Create In 2016年3月7日
 */
public enum MailTemplateType {
	SQ("1"), // 首期
	FSQ("2"), // 非首期
	SKQRS("3"), // 收款确认书
	YZ("4"); // 验证邮件

	public final String value;

	private MailTemplateType(String value) {
		this.value = value;
	}

	public static String getMailTemplateType(String value) {
		return mailTemplateTypeMap.get(value);
	}

	public static Map<String, String> mailTemplateTypeMap = new Hashtable<String, String>();

	public static void initBackReason() {
		if (mailTemplateTypeMap.isEmpty()) {
			mailTemplateTypeMap.put(MailTemplateType.SQ.value, "首期");
			mailTemplateTypeMap.put(MailTemplateType.FSQ.value, "非首期");
			mailTemplateTypeMap.put(MailTemplateType.SKQRS.value, "收款确认书");
			mailTemplateTypeMap.put(MailTemplateType.YZ.value, "验证邮件");
		}
	}
}