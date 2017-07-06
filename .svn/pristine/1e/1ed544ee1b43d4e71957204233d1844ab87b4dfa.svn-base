package com.creditharmony.core.common.util;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.core.type.SystemFlag;


/**
 * 划扣帮助类
 * @Class Name DeductHelper
 * @author 张永生
 * @Create In 2016年5月20日
 */
public class DeductHelper {

	/** 财富  **/
	public static final String FORTUNE = "Fortune";
	/** 汇金  **/
	public static final String LOAN = "Loan";
	/** 其他  **/
	public static final String OTHER = "Other";
	
	/**
	 * 生成请求ID
	 * 2016年5月20日
	 * By 张永生
	 * @return
	 */
	public static String getRequestId() {
		return DateUtils.getNowTime() + randomStr(10);
	}
	
	/**
	 * 随机产生指定长度的数据字符串
	 * 2016年5月20日
	 * By 张永生
	 * @param length
	 * @return
	 */
	public static String randomStr(int length) {
		if (length < 1) {
			return null;
		}
		Random strGen = new Random();
		char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz").toCharArray();
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[strGen.nextInt(35)];
		}
		return new String(randBuffer);
	}
	
	/**
	 * 获取系统标识
	 * 2016年5月20日
	 * By 张永生
	 * @param sysId
	 * @return
	 */
	public static String getSystemFlag(String sysId) {
		if (sysId.startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
			return FORTUNE;
		} else if (sysId.startsWith(String.valueOf(SystemFlag.LOAN.value))) {
			return LOAN;
		} else {
			return OTHER;
		}
	}
	
	/**
	 * 获取请求批次号
	 * 2016年5月20日
	 * By 张永生
	 * @return
	 */
	public static String getBatchNo() {
		String base = DateUtils.getDate("yyyyMMdd") + "1200";
		String batId = "";
		try {
			Date b = DateUtils.parseDate(base, "yyyyMMddHHmm");
			Date n = new Date();
			if (Boolean.TRUE == DateUtils.dateAfter(n, b)) {
				batId = base + "99999999";
			} else {
				batId = base + "88888888";
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return batId;
	}
	
	/**
	 * 获取划扣失败金额
	 * 2016年5月20日
	 * By 张永生
	 * @param applyAmount
	 * @param deductedMoney
	 * @return
	 */
	public static Double getDeductFailedMoney(String applyAmount, String deductedMoney){
		return Double.valueOf(applyAmount)-Double.valueOf(deductedMoney);
	}
	
	
}
