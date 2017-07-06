package com.creditharmony.core.common.type;


/**
 * 数据域的类型
 * @Class Name DomainType
 * @author 张永生
 * @Create In 2015年12月19日
 */
public interface DomainType {

	/**
	 * 组织结构
	 */
	public static final String ORG = "org";
	/**
	 * 用户
	 */
	public static final String USER = "user";
	
	/**
	 *  惠民出借服务部合同审核小组
	 */
	public static final String CONTRACT_APPROVE_GROUP = "approveGroup";
	/**
	 *  惠民出借服务部利率审核小组
	 */
	public static final String RATE_APPROVE_GROUP = "rateApproveGroup";
	
	/**
	 *  惠民出借服务部合同审核单据模式为空的小组组员(门店分配类型)
	 */
	public static final String CONTRACT_APPROVE_MEMBER = "approveMember";
	/**
	 *  惠民出借服务部合同审核单据模式为TG的小组组员(门店分配类型)
	 */
	public static final String CONTRACT_APPROVE_MEMBER_TG = "approveMemberTG";
	/**
	 *  惠民出借服务部利率审核小组组员(门店分配类型)
	 */
	public static final String RATE_APPROVE_MEMBER = "rateApproveMember";
	
}
