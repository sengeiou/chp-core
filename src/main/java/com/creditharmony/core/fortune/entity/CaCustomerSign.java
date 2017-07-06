package com.creditharmony.core.fortune.entity;

/**
 * 代理签章需要参数
 * 
 * @Class Name CaCustomerSign
 * @author 朱杰
 * @Create In 2016年3月31日
 */
public class CaCustomerSign {
	
	public CaCustomerSign(){
		
	}
	
	public CaCustomerSign(String custName,String keyword,String idCard){
		this.custName=custName;
		this.idCard=idCard;
		this.keyword=keyword;
	}

	//关键字
	private String keyword;
	//证件号
	private String idCard;
	//客户姓名
	private String custName;
	
	/** 批次编码,可以根据此编码将一批附件归档在一起 */
	private String batchNo;
	/** 在同一批次编码下的分类 */
	private String subType;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	
}