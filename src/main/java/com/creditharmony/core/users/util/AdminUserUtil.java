package com.creditharmony.core.users.util;

import com.creditharmony.core.type.AdminUserFlag;
import com.creditharmony.core.users.entity.User;

/**
 * 管理员用户工具类
 * @Class Name AdminUserUtil
 * @author 张永生
 * @Create In 2016年6月17日
 */
public class AdminUserUtil {

	/**
	 * 判断是否是汇金管理员或汇金人管室管理员
	 * 2016年6月17日
	 * By 张永生
	 * @param userInfo
	 * @param adminUserFlag
	 * @return
	 */
	public static boolean isLoanAdmin(User userInfo, String adminUserFlag) {
		return userInfo.isLoanAdmin() || AdminUserFlag.LOAN_HUMAN_OFFICE_ADMIN.equals(adminUserFlag);
	}

	/**
	 * 判断是否是汇诚管理员或汇诚人管室管理员
	 * 2016年6月17日
	 * By 张永生
	 * @param userInfo
	 * @param adminUserFlag
	 * @return
	 */
	public static boolean isApproveAdmin(User userInfo, String adminUserFlag) {
		return userInfo.isApproveAdmin() || AdminUserFlag.APPROVE_HUMAN_OFFICE_ADMIN.equals(adminUserFlag);
	}

	/**
	 * 判断是否是财富管理员或财富人管室管理员
	 * 2016年6月17日
	 * By 张永生
	 * @param userInfo
	 * @param adminUserFlag
	 * @return
	 */
	public static boolean isFortuneAdmin(User userInfo, String adminUserFlag) {
		return userInfo.isFortuneAdmin() || AdminUserFlag.FORTUNE_HUMAN_OFFICE_ADMIN.equals(adminUserFlag);
	}
	
	/**
	 * 判断是否是借款人服务部管理员
	 * 2016年6月29日
	 * By 张永生
	 * @param userInfo
	 * @param adminUserFlag
	 * @return
	 */
	public static boolean isLoanerDeptAdmin(String adminUserFlag) {
		return AdminUserFlag.LOANER_DEPT_ADMIN.equals(adminUserFlag);
	}
	
	/**
	 * 判断是否是出借人服务部管理员
	 * 2016年6月29日
	 * By 张永生
	 * @param userInfo
	 * @param adminUserFlag
	 * @return
	 */
	public static boolean isLenderDeptAdmin(String adminUserFlag) {
		return AdminUserFlag.LENDER_DEPT_ADMIN.equals(adminUserFlag);
	}
	
	/**
	 * 判断是否是惠民事业部管理员
	 * 2016年7月1日
	 * By 张永生
	 * @param adminUserFlag
	 * @return
	 */
	public static boolean isHuiMinBizDeptAdmin(String adminUserFlag) {
		return AdminUserFlag.HUIMIN_BIZ_DEPT_ADMIN.equals(adminUserFlag);
	}
	
	public static boolean isDianXiaoZhongXinDeptAdmin(String adminUserFlag) {
		return AdminUserFlag.DIAN_XIAO_DEPT_ADMIN.equals(adminUserFlag);
	}
}
