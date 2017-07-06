package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/***
 * 文件类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum FileType {
	ZRSR("ZRSR","债权转让及受让协议"), // 债权转让及受让协议
	SKQRS_HK("SKQRS_HK","收款确认书_划扣"), // 收款确认书_划扣
	Q30TDQ_TXLB("Q30TDQ_TXLB","前30天到期提醒列表"), // 前30天到期提醒列表
	Q10TDQ_TXLB("Q10TDQ_TXLB","前10天到期提醒列表"), // 前10天到期提醒列表
	Q3MONTHTDQ_TXLB("Q3MONTHTDQ_TXLB","三个月内到期提醒列表"), // 三个月内到期提醒列表
	DQ_TXLB("DQ_TXLB","到期提醒列表"), // 到期提醒列表
	HQSPLB("HQSPLB","划扣审批列表"), // 划扣审批列表
	HKSBXYKLB("HKSBXYKLB","划扣失败协议库列表"), // 划扣失败协议库列表
	HKSBLB("HKSBLB","划扣失败列表"), // 划扣失败列表
	YHKLB("YHKLB","已划扣列表"), // 已划扣列表
	YCJZQHFLB("YCJZQHFLB","已出借债权回访列表"), // 已出借债权回访列表
	KYZQLB("KYZQLB","可用债权列表"), // 可用债权列表
	YMYZQLB("YMYZQLB","月满盈债权列表"), // 月满盈债权列表
	YMYKYZQLB("YMYKYZQLB","月满盈可用债权列表"), // 月满盈可用债权列表
	DJZQLB("DJZQLB","债权冻结列表"), // 债权冻结列表
	DTJZQXXLB("DTJZQXXLB","待推荐债权信息列表"), // 待推荐债权信息列表
	DCJZHLB("DCJZLLB","导出金帐户"), // 导出金帐户
	JZHHBLB("JZHHBLB","PW03_20150101_0001"), // 金帐户线下划拨
	GGCLB("GGCLB","公共池列表"), // 公共池列表
	ZQCXLB("ZQCXLB","债权撤销列表"); // 债权撤销列表

	private static Map<String, FileType> nameMap = new HashMap<String, FileType>(
			10);
	private static Map<String, FileType> codeMap = new HashMap<String, FileType>(
			10);

	static {
		FileType[] allValues = FileType.values();
		for (FileType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FileType(String code, String name) {
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

	public static FileType parseByName(String name) {
		return nameMap.get(name);
	}

	public static FileType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}