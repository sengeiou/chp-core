package com.creditharmony.core.deduct.bean.in;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 划扣请求-Entity
 * @Class Name DeductReqest
 * @author 周亮
 * @Create In 2016年01月01日
 */
public class DeductReq implements Serializable{
	
	private static final long serialVersionUID = -1159631344884376456L;
	/**业务信息用（汇金合同号，财富出借编号等） **/
	private String businessId;
	/** 系统处理ID */
	private String sysId;
	/** 请求ID */
	private String requestId;
	/** 请求批次ID */
	private String batId;
	/** 关联ID */
	private String refId;
	/** 划扣标志 */
	private String deductFlag;
	/** 规则 */
	private String rule;
	/** 银行ID */
	private String bankId;
	/** 支行省 */
	private String bankProv;
	/** 支行市 */
	private String bankCity;
	/** 支行名 */
	private String bankName;
	/** 账号 */
	private String accountNo;
	/** 账户名称 */
	private String accountName;
	/** 证件类型 */
	private String idType;
	/** 证件编号 */
	private String idNo;
	/** 联系方式(手机号码) */
	private String mobile;
	/** 账户类型（00:卡，01:折）*/
	private String accountType;
	/** 金额 */
	private BigDecimal amount;
	/** 未拆分金额 */
	private Long unsplitAmount;
	/** 状态(0:待处理,1:处理中,2:已处理) */
	private String status;
	/** 剩余可拆分次数 */
	private Integer unsplitTimes;
	/** 备注 */
	private String remarks;
	/**签约平台**/
	private String signPlate;
	/**回盘结果**/
	private String counterofferResult;
	/** 账单日期 */
	private Date billDate;
	/** 表名称 */
	private String table;
    /**
     * 创建人
     */
    private String creatby;
    /** 协议号 */
    private String protocolNo;
    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 修改人
     */
    private String modifyby;

    /**
     * 修改时间
     */
    private Date modifyTime;
    
    /**版本时间*/
	private String verTime;
	
	private Boolean success;
	
	private int cpcnCount;
	// 通联余额不足次数
	private int tlCount;
	/**支行编号*/
	private String branchCode;
	/**业务对象类型*/
	private String busObjType;
	/**
     * 卡联返回流水号
     */
    private String kalianBatchNo;
    
    // 签约平台
    private String fuYouSign;
    // 通联是否签约
    private String tongLianSign;
    // 畅捷是否签约
    private String  changJieSign;
    // 卡联是否签约
    private String  kaLianSign;
    
	public String getKalianBatchNo() {
		return kalianBatchNo;
	}
	public void setKalianBatchNo(String kalianBatchNo) {
		this.kalianBatchNo = kalianBatchNo;
	}
	
	// 逾期天数
	private int overdueDays;
	
	public String getBusObjType() {
		return busObjType;
	}
	public void setBusObjType(String busObjType) {
		this.busObjType = busObjType;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	/**
	 * @return 创建人
	 */
	public String getCreatby() {
		return creatby;
	}
	/**
	 * @param 创建人
	 */
	public void setCreatby(String creatby) {
		this.creatby = creatby;
	}

	/**
	 * @return 创建时间
	 */
	public Date getCreatTime() {
		return creatTime;
	}
	/**
	 * @param 创建时间
	 */
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	/**
	 * @return 修改人
	 */
	public String getModifyby() {
		return modifyby;
	}
	/**
	 * @param 修改人
	 */
	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	/**
	 * @return 修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param 修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	/**
	 * @return 请求ID 
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param 请求ID 
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the sysId
	 */
	public String getSysId() {
		return sysId;
	}
	/**
	 * @param sysId the sysId to set
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	/**
	 * @return the batId
	 */
	public String getBatId() {
		return batId;
	}
	/**
	 * @param batId the batId to set
	 */
	public void setBatId(String batId) {
		this.batId = batId;
	}
	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}
	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	/**
	 * @return 划扣标志 
	 */
	public String getDeductFlag() {
		return deductFlag;
	}
	/**
	 * @param 划扣标志 
	 */
	public void setDeductFlag(String deductFlag) {
		this.deductFlag = deductFlag;
	}

	/**
	 * @return 规则 
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * @param 规则
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * @return 银行ID 
	 */
	public String getBankId() {
		return bankId;
	}
	/**
	 * @param 银行ID 
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return 支行省 
	 */
	public String getBankProv() {
		return bankProv;
	}
	/**
	 * @param 支行省 
	 */
	public void setBankProv(String bankProv) {
		this.bankProv = bankProv;
	}

	/**
	 * @return 支行市 
	 */
	public String getBankCity() {
		return bankCity;
	}
	/**
	 * @param 支行市 
	 */
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	/**
	 * @return 支行名 
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param 支行名 
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return 账号 
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * @param 账号 
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return 账户名称 
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param 账户名称 
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return 证件类型 
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * @param 证件类型 
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return 证件编号 
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * @param 证件编号 
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * @return 联系方式(手机号码) 
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param 联系方式(手机号码) 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return 账户类型（00:卡，01:折）
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType 账户类型（00:卡，01:折）
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return 金额 
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param 金额 
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the unsplitAmount
	 */
	public Long getUnsplitAmount() {
		return unsplitAmount;
	}
	/**
	 * @param unsplitAmount the unsplitAmount to set
	 */
	public void setUnsplitAmount(Long unsplitAmount) {
		this.unsplitAmount = unsplitAmount;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the unsplit_times
	 */
	public Integer getUnsplitTimes() {
		return unsplitTimes;
	}
	/**
	 * @param unsplitTimes the unsplit_times to set
	 */
	public void setUnsplitTimes(Integer unsplitTimes) {
		this.unsplitTimes = unsplitTimes;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSignPlate() {
		return signPlate;
	}
	public void setSignPlate(String signPlate) {
		this.signPlate = signPlate;
	}
	public String getCounterofferResult() {
		return counterofferResult;
	}
	public void setCounterofferResult(String counterofferResult) {
		this.counterofferResult = counterofferResult;
	}
	public String getVerTime() {
		return verTime;
	}
	public void setVerTime(String verTime) {
		this.verTime = verTime;
	}
	/**
	 * @return the 账单日期
	 */
	public Date getBillDate() {
		return billDate;
	}
	/**
	 * @param 账单日期
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public int getCpcnCount() {
		return cpcnCount;
	}
	public void setCpcnCount(int cpcnCount) {
		this.cpcnCount = cpcnCount;
	}
	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(String table) {
		this.table = table;
	}
	public int getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}
	/**
	 * @return the protocolNo
	 */
	public String getProtocolNo() {
		return protocolNo;
	}
	/**
	 * @param protocolNo the String protocolNo to set
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public int getTlCount() {
		return tlCount;
	}
	public void setTlCount(int tlCount) {
		this.tlCount = tlCount;
	}
	public String getFuYouSign() {
		return fuYouSign;
	}
	public String getTongLianSign() {
		return tongLianSign;
	}
	public String getChangJieSign() {
		return changJieSign;
	}
	public void setFuYouSign(String fuYouSign) {
		this.fuYouSign = fuYouSign;
	}
	public void setTongLianSign(String tongLianSign) {
		this.tongLianSign = tongLianSign;
	}
	public void setChangJieSign(String changJieSign) {
		this.changJieSign = changJieSign;
	}
	public String getKaLianSign() {
		return kaLianSign;
	}
	public void setKaLianSign(String kaLianSign) {
		this.kaLianSign = kaLianSign;
	}
	
}
