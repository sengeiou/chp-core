package com.creditharmony.core.users.constants;


/**
 * 组织机构常量类
 * @Class Name OrgConstants
 * @author 张永生
 * @Create In 2015年12月15日
 */
public interface OrgConstants {

	/**
	 * 组织机构的根节点:信和财富
	 */
	public static final String ORG_ROOT_ID = "1";
	/**
	 * 有孩子节点
	 */
	public static final String HAS_CHILDREN = "1";
	/**
	 * 没有孩子节点
	 */
	public static final String NO_CHILDREN = "0";
	/**
	 * 财富的根节点
	 */
	public static final String ORG_FORTUNE_ROOT = "0";
	public static final String ORG_FORTUNE_ROOT_PARENT_IDS = "-1,1,0,";
	/**
	 * 汇金的根节点
	 */
	public static final String ORG_LOAN_ROOT = "400000001014984";
	public static final String ORG_LOAN_ROOT_PARENT_IDS = "-1,1,400000001014984,";

	public static final String DIAN_XIAO_DEPT_ROOT = "400000323590842";
	public static final String ORG_DIAN_XIAO_ROOT_PARENT_IDS = "-1,1,400000323590842";
	/**
	 * 汇诚的根节点
	 */
	public static final String ORG_APPROVE_ROOT = "100000000000000";
	public static final String ORG_APPROVE_ROOT_PARENT_IDS = "-1,1,100000000000000,";
	
	/**
	 * 出借人服务部的根节点
	 */
	public static final String LENDER_DEPT_ROOT = "21";
	public static final String LENDER_DEPT_ROOT_PARENT_IDS = "-1,1,400000001416046,21,";
	
	/**
	 * 借款人服务部的根节点
	 */
	public static final String LOANER_DEPT_ROOT = "400000001416047";
	public static final String LOANER_DEPT_ROOT_PARENT_IDS = "-1,1,400000001416046,400000001416047,";
	
	/**
	 * 惠民事业部根节点
	 */
	public static final String HUIMIN_BIZ_DEPT_ROOT = "400000001416046";
	

	
	
	
	
	
}
