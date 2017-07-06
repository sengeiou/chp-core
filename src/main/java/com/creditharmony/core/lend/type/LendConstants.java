package com.creditharmony.core.lend.type;

/**
 * 
 * @Class Name LendConstants   借款常量标示   汇金 汇诚共同
 * @author 李静辉
 * @Create In 2015年12月28日
 */
public class LendConstants {
	
	/************借款类型*****************************/
	/**
	 * 产品类型----信借
	 */
	public static final String PRODUCTS_TYPE_LOAN_CREDIT = "products_type_loan_credit";
	/**
	 * 产品类型----车借
	 */
	public static final String PRODUCTS_TYPE_CAR_CREDIT = "products_type_car_credit";
	//jk_product_type
	
	/************信审借款****************************/
	
	/**
	 * 回退清单大类
	 */
	public static final String BACK_REASON = "jk_back_reason";
	/**
	 * 外访清单大类
	 */
	public static final String OUT_CHK = "jk_out_chk";
	/**
	 * 评估结果：正常、异常、无效
	 */
	public static final String EVAL_RESULT = "jk_eval_result";
	
	/**
	 * 家庭联系人关系
	 */
	public static final String LOAN_FAMILY_RELATION = "jk_loan_family_relation";
	/**
	 * 工作证明人和本人关系
	 */
	public static final String WORKEMATE_RELATION = "jk_workemate_relation";
	/**
	 * 汇金码表中工作证明人和本人关系
	 */
	public static final String LOAN_WORKEMATE_RELATION = "jk_loan_workmate_relation";

	/**
	 * 接听状态
	 */
	public static final String APPROVE_PHONE_STATUE = "jk_approve_phone_statue";
	/**
	 * 复审、终审组审批额度判定
	 */
	public static final String APPROVE_RESPONE_AMOUNT = "jk_approve_respone_amount";
	
	
	
	/************车借*****************************/
	
	/**
	 * 回退清单大类
	 */
	public static final String CAR_BACK_REASON = "jk_car_back_reason";
	
	/**
	 * 成功
	 */
	public static final String SUCCESS = "success";
	/**
	 * 错误
	 */
	public static final String ERROR = "error";
	/**
	 * 失败
	 */
	public static final String FAILED = "failed";
	
}
