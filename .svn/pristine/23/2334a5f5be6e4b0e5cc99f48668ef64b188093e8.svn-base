package com.creditharmony.core.autoBill.entity;

import java.text.DecimalFormat;
import java.util.Date;

import com.creditharmony.core.cache.DictCache;
import com.creditharmony.core.excel.annotation.ExcelField;
import com.creditharmony.core.persistence.DataEntity;

public class DeductHistory extends DataEntity<DeductHistory>{
	/**
	 * long serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	@ExcelField(title="对账时间", sort=1)
	private Date billTime;
	@ExcelField(title="发送时间", sort=2)
	private Date sendTime;
	private String platformType;//对账平台
	@ExcelField(title="对账平台", sort=3)
	private String platformName;
	private String billType;//对账业务
	@ExcelField(title="对账业务", sort=4)
	private String billTypeName;
	@ExcelField(title="业务编号", sort=5)
	private String businessNo;//业务编号
	private String orderNum;//批次编号
	@ExcelField(title="订单号", sort=6)
	private String orderNo;//市场订单号
	@ExcelField(title="流水号", sort=7)
	private String itemNo;//流水号
	@ExcelField(title="客户姓名", sort=8)
	private String customName;//客户姓名
	private double money;//金额
	@ExcelField(title="金额", sort=10)
	private String moneyFormate;
	private String platformRes;//平台结果
	@ExcelField(title="平台结果", sort=11)
	private String platformResStr;
	private String balanceAmount;//平台金额
	private String balanceStatus;//我方结果
	@ExcelField(title="我方结果", sort=9)
	private String balanceStatusStr;
	private String billStatus;
	@ExcelField(title="对账结果", sort=12)
	private String billStatusStr;
	private String deductType;
	private Date billDate;//账单日
	
	public Date getBillTime() {
		return billTime;
	}
	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}
	
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getPlatformType() {
		return platformType;
	}
	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}
	public String getPlatformName() {
		return DictCache.getInstance().getDictLabel("tz_deduct_plat",platformType);
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getBillTypeName() {
		if(this.billType == null){
			return "";
		}
		if(this.billType.startsWith("2")){
			return "财富";
		}else if(this.billType.startsWith("3")){
			return "汇金";
		}
		return "";
	}
	public void setBillTypeName(String billTypeName) {
		this.billTypeName = billTypeName;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public String getPlatformRes() {
		return platformRes;
	}
	public void setPlatformRes(String platformRes) {
		this.platformRes = platformRes;
	}
	public String getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(String balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	
	public String getBalanceStatus() {
		return balanceStatus;
	}
	public void setBalanceStatus(String balanceStatus) {
		this.balanceStatus = balanceStatus;
	}
	public String getMoneyFormate() {
		DecimalFormat df1 = new DecimalFormat("#,##0.00#"); 
		return df1.format(this.money);
	}
	public void setMoneyFormate(String moneyFormate) {
		this.moneyFormate = moneyFormate;
	}
	public String getPlatformResStr() {
		return DictCache.getInstance().getDictLabel("gt_auto_bill_platformRes", this.platformRes) ;
	}
	public void setPlatformResStr(String platformResStr) {
		this.platformResStr = platformResStr;
	}
	public String getBalanceStatusStr() {
		return DictCache.getInstance().getDictLabel("gt_auto_bill_result", this.balanceStatus) ;
	}
	public void setBalanceStatusStr(String balanceStatusStr) {
		this.balanceStatusStr = balanceStatusStr;
	}
	public String getBillStatusStr() {
		return DictCache.getInstance().getDictLabel("gt_auto_bill_status", this.billStatus) ;
	}
	public void setBillStatusStr(String billStatusStr) {
		this.billStatusStr = billStatusStr;
	}
	public String getDeductType() {
		return deductType;
	}
	public void setDeductType(String deductType) {
		this.deductType = deductType;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
}
