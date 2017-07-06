package com.creditharmony.core.autoBill.constants;

public class AutoBillConstants {

	/**
	 * 对应字典类型gt_auto_bill_status，对账状态为一致
	 */
	public static final String GT_AUTO_BILL_STATUS_SAME = "1";
	/**
	 * 对应字典类型gt_auto_bill_status，对账状态为未对账
	 */
	public static final String GT_AUTO_BILL_STATUS_NONE = "2";
	/**
	 * 对应字典类型gt_auto_bill_status，对账状态为不一致
	 */
	public static final String GT_AUTO_BILL_STATUS_DIFFERENT = "3";

	/**
	 * 对应字典类型gt_auto_bill_platformRes，平台结果为等待处理
	 */
	public static final String GT_AUTO_BILL_PLATFORMRES_WAIT = "10";
	/**
	 * 对应字典类型gt_auto_bill_platformRes，平台结果为处理中
	 */
	public static final String GT_AUTO_BILL_PLATFORMRES_PROCESSING = "20";
	/**
	 * 对应字典类型gt_auto_bill_platformRes，平台结果为成功
	 */
	public static final String GT_AUTO_BILL_PLATFORMRES_SUCCESS = "30";
	/**
	 * 对应字典类型gt_auto_bill_platformRes，平台结果为失败
	 */
	public static final String GT_AUTO_BILL_PLATFORMRES_FAILURE = "40";
	
	public static final String GT_AUTO_BILL_PLATFORMRES_FAILURE_50 = "50";
	
	/**
	 * 对应字典类型gt_auto_bill_result，划扣结果为失败
	 */
	public static final String GT_AUTO_BILL_RESULT_SUCCESS = "1";
	/**
	 * 对应字典类型gt_auto_bill_result，划扣结果为失败
	 */
	public static final String GT_AUTO_BILL_RESULT_FAILURE = "2";
	/**
	 * 对应字典类型gt_auto_bill_result，划扣结果为失败
	 */
	public static final String GT_AUTO_BILL_RESULT_PROCESSING = "3";

	/**
	 * 对应字典类型gt_auto_bill_result，划扣结果为成功
	 */
	public static final String GT_AUTO_BILL_RESULT_SUCCESS_CODE = "0000";

	/**
	 * 对应字典类型gt_auto_bill_busType，业务类型为财富
	 */
	public static final String GT_AUTO_BILL_BUSTYPE_FORTUNE = "1";
	/**
	 * 对应字典类型gt_auto_bill_busType，业务类型为汇金
	 */
	public static final String GT_AUTO_BILL_BUSTYPE_LOAN = "2";
	/**
	 * 已确认
	 */
	public static final String GT_AUTO_BILL_CONFIRM = "1";

}
