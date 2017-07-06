package com.creditharmony.core.autoBill.entity;

import java.text.DecimalFormat;

import com.creditharmony.core.excel.annotation.ExcelField;
import com.creditharmony.core.persistence.DataEntity;

public class BankBillInfo extends DataEntity<BankBillInfo>{
	/**
	 * long serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	@ExcelField(title="对账时间", sort=1)
	private String billDate;// 到账日期
	private String platformId;// 对账平台id
	@ExcelField(title="对账平台", sort=2, dictType="tz_deduct_plat")
	private String platformName;// 对账平台
	private double totalAmount;//结算金额
	@ExcelField(title="平台结算金额", sort=3)
	private String totalAmountFormate;
	private double balanceAmount;// 结算到余额金额
	@ExcelField(title="结算到余额金额", sort=4)
	private String balanceAmountFormate;
	@ExcelField(title="对账银行", sort=5, dictType="tz_open_bank")
	private String bankId;// 对账银行
	private String bankName;// 对账银行
	private double incomeAmount;// 银行入账金额
	@ExcelField(title="银行入账金额", sort=6)
	private String incomeAmountFormate;
	private String status;//交易状态
	@ExcelField(title="确认状态", sort=7)
	private String statusStr;
	private String hasEdit;//是否修改
	
	public static final String STATUS_CONFIRMED="1";
	public static final String STATUS_EQUAL="2";
	public static final String STATUS_NOT_EQUAL="3";
	public static final String STATUS_NOT_CONFIRMED="4";
	
	public BankBillInfo(){
		
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Double getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(Double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHasEdit() {
		return hasEdit;
	}
	public void setHasEdit(String hasEdit) {
		this.hasEdit = hasEdit;
	}
	public String getTotalAmountFormate() {
		DecimalFormat df1 = new DecimalFormat("#,##0.00#"); 
		return df1.format(this.totalAmount);
	}
	public void setTotalAmountFormate(String totalAmountFormate) {
		this.totalAmountFormate = totalAmountFormate;
	}
	public String getBalanceAmountFormate() {
		DecimalFormat df1 = new DecimalFormat("#,##0.00#"); 
		return df1.format(this.balanceAmount);
	}
	public void setBalanceAmountFormate(String balanceAmountFormate) {
		this.balanceAmountFormate = balanceAmountFormate;
	}
	public String getIncomeAmountFormate() {
		DecimalFormat df1 = new DecimalFormat("#,##0.00#"); 
		return df1.format(this.incomeAmount);
	}
	public void setIncomeAmountFormate(String incomeAmountFormate) {
		this.incomeAmountFormate = incomeAmountFormate;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
}
