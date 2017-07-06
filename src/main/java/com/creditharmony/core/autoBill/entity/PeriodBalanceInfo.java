package com.creditharmony.core.autoBill.entity;

import com.creditharmony.core.persistence.DataEntity;

public class PeriodBalanceInfo extends DataEntity<PeriodBalanceInfo> {
	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String billDate;
	private String platformId;
	private double periodAmount;
	private double balanceAmount;
	private double rechargeAmount;
	private double incomeAmount;
	private double payAmount;
	private double finalAmount;
	private double periodZj;
	private double finalZj;
	private String status;
	private String billType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public double getPeriodAmount() {
		return periodAmount;
	}

	public void setPeriodAmount(double periodAmount) {
		this.periodAmount = periodAmount;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Double getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public Double getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(Double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public double getPeriodZj() {
		return periodZj;
	}

	public void setPeriodZj(double periodZj) {
		this.periodZj = periodZj;
	}

	public double getFinalZj() {
		return finalZj;
	}

	public void setFinalZj(double finalZj) {
		this.finalZj = finalZj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

}
