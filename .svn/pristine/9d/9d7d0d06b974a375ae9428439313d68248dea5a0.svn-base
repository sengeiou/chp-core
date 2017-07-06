package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 组织机构类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum OrgType {
	TD("1"), // 团队
	YYB("2"), // 营业部
	SS("3"), // 省市
	DQ("4"), // 大区
	ZB("5"), // 总部
	CFSYB("6");// 财富事业部

	public final String value;

	private OrgType(String value) {
		this.value = value;
	}

	public static String getOrgType(String value) {
		return orgTypeMap.get(value);
	}

	public static Map<String, String> orgTypeMap = new Hashtable<String, String>();

	public static void initOrgType() {
		if (orgTypeMap.isEmpty()) {
			orgTypeMap.put(OrgType.TD.value, "团队");
			orgTypeMap.put(OrgType.YYB.value, "营业部");
			orgTypeMap.put(OrgType.SS.value, "省市");
			orgTypeMap.put(OrgType.DQ.value, "大区");
			orgTypeMap.put(OrgType.ZB.value, "总部");
			orgTypeMap.put(OrgType.CFSYB.value, "财富事业部");
		}
	}
}