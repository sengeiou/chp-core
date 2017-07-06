/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.entity.PlatformRule.java
 * @Create By 王彬彬
 * @Create In 2015年12月21日 上午11:28:25
 */
package com.creditharmony.core.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 汇诚接口参数
 * 
 * @Class Name PlatformRule
 * @author 申阿伟
 * @Create In 2017年05月6日
 */
public class AuditResult implements Serializable {

	private static final long serialVersionUID = 5295307586996661227L;
	//借款编码
	private String loanCode;
	//风险等级
	private String riskLevel;
	//审批产品
	private String productCode;
	//审批分期
	private Integer months;
	//批复金额
	private String auditAmount; 
	
	//返回结果
	List<ProductRate> productRateList=new ArrayList<ProductRate>();
	
	
	public String getLoanCode() {
		return loanCode;
	}
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		this.months = months;
	}
	
	public String getAuditAmount() {
		return auditAmount;
	}
	public void setAuditAmount(String auditAmount) {
		this.auditAmount = auditAmount;
	}
	public List<ProductRate> getProductRateList() {
		return productRateList;
	}
	public void setProductRateList(List<ProductRate> productRateList) {
		this.productRateList = productRateList;
	}
	
}