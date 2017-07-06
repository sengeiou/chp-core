package com.creditharmony.core.autoBill.entity;

import java.util.Date;

import com.creditharmony.core.persistence.DataEntity;

public class AutoBillTemp extends DataEntity<AutoBillTemp>{
	/**
	 * long serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNo;// 流水号
	private Date billTime;
	private String batchNo;
	private String bankInfo;
	private String accountInfo;
	private String accountNo;
	private String accountName;
	private String billStatus;
	private Date bankTime;
	private String userId;// 用户编号
	private String type;// 类型
	private Double money;// 金额
	private String status;//交易状态
	public static final String TYPE_DEDUCT_BILL="1";//划扣对账
	public static final String TYPE_COLLECT_BILL="2";//结算对账
	public static final String TYPE_BACKREST_BILL="3";//回息对账

	public AutoBillTemp(){
		
	}
	
	public AutoBillTemp(String orderNo, String userId, String type, Double money, String status) {
		super();
		this.orderNo = orderNo;
		this.userId = userId;
		this.type = type;
		this.money = money;
		this.status = status;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBillTime() {
		return billTime;
	}

	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}

	public String getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	public Date getBankTime() {
		return bankTime;
	}

	public void setBankTime(Date bankTime) {
		this.bankTime = bankTime;
	}

}
