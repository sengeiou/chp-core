package com.creditharmony.core.deduct.bean.out;

import java.io.Serializable;


/**
 * 财富划扣返回结果实体
 * @Class Name FortuneDeductResult
 * @author 韩龙
 * @Create In 2016年1月31日
 */
public class FortuneDeductResult implements Serializable {

	private static final long serialVersionUID = -8786585027087366089L;
	/** 
	 * 请求ID 
	 */
	private String requestId;
	/** 
	 * 系统请求ID(对应出借编号、回款、回息等唯一标识) 
	 */
	private String lendCode;
	/** 
	 * 分天划扣ID 
	 */
	private String theDayId;
	/** 
	 * 成功金额 
	 */
	private String deductSucceedMoney;
	/** 
	 * 失败金额 
	 */
	private String deductFailMoney;
	/** 
	 * 交易时间 
	 */
	private String deductTime;
	/** 
	 * 失败原因 
	 */
	private String confirmOpinion;
	
	/**
	 * 划扣或放款结果（0000:成功，其它为失败）
	 */
	private String deductResultCode;
	/** 
	 * 业务功能ID 101：财富划扣；102：财富回款；103：财富回息 
	 */
	private String deductSysIdType;
	/** 
	 * 划扣失败平台 
	 */
	private String plateformId;
	/** 
	 * 未划金额 
	 */
	private String unDeductMoney;
	/** 
	 * 累计失败金额 
	 */
	private String allDeductFailMoney;
	
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
	 * @return 系统请求ID(对应出借编号、回款、回息等唯一标识) 
	 */
	public String getLendCode() {
		return lendCode;
	}
	/**
	 * @param 系统请求ID(对应出借编号、回款、回息等唯一标识) 
	 */
	public void setLendCode(String lendCode) {
		this.lendCode = lendCode;
	}
	/**
	 * @return 分天划扣ID 
	 */
	public String getTheDayId() {
		return theDayId;
	}
	/**
	 * @param 分天划扣ID 
	 */
	public void setTheDayId(String theDayId) {
		this.theDayId = theDayId;
	}
	/**
	 * @return 成功金额 
	 */
	public String getDeductSucceedMoney() {
		return deductSucceedMoney;
	}
	/**
	 * @param 成功金额 
	 */
	public void setDeductSucceedMoney(String deductSucceedMoney) {
		this.deductSucceedMoney = deductSucceedMoney;
	}
	/**
	 * @return 失败金额 
	 */
	public String getDeductFailMoney() {
		return deductFailMoney;
	}
	/**
	 * @param 失败金额 
	 */
	public void setDeductFailMoney(String deductFailMoney) {
		this.deductFailMoney = deductFailMoney;
	}
	/**
	 * @return 交易时间 
	 */
	public String getDeductTime() {
		return deductTime;
	}
	/**
	 * @param 交易时间 
	 */
	public void setDeductTime(String deductTime) {
		this.deductTime = deductTime;
	}
	/**
	 * @return 失败原因 
	 */
	public String getConfirmOpinion() {
		return confirmOpinion;
	}
	/**
	 * @param 失败原因 
	 */
	public void setConfirmOpinion(String confirmOpinion) {
		this.confirmOpinion = confirmOpinion;
	}
	/**
	 * @return 业务功能ID 101：财富划扣；102：财富回款；103：财富回息 
	 */
	public String getDeductSysIdType() {
		return deductSysIdType;
	}
	/**
	 * @param 业务功能ID 101：财富划扣；102：财富回款；103：财富回息 
	 */
	public void setDeductSysIdType(String deductSysIdType) {
		this.deductSysIdType = deductSysIdType;
	}
	/**
	 * @return 划扣失败平台 
	 */
	public String getPlateformId() {
		return plateformId;
	}
	/**
	 * @param 划扣失败平台 
	 */
	public void setPlateformId(String plateformId) {
		this.plateformId = plateformId;
	}
	/**
	 * @return 未划金额 
	 */
	public String getUnDeductMoney() {
		return unDeductMoney;
	}
	/**
	 * @param 未划金额 
	 */
	public void setUnDeductMoney(String unDeductMoney) {
		this.unDeductMoney = unDeductMoney;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((confirmOpinion == null) ? 0 : confirmOpinion.hashCode());
		result = prime * result
				+ ((deductFailMoney == null) ? 0 : deductFailMoney.hashCode());
		result = prime
				* result
				+ ((deductSucceedMoney == null) ? 0 : deductSucceedMoney
						.hashCode());
		result = prime * result
				+ ((deductSysIdType == null) ? 0 : deductSysIdType.hashCode());
		result = prime * result
				+ ((deductTime == null) ? 0 : deductTime.hashCode());
		result = prime * result
				+ ((lendCode == null) ? 0 : lendCode.hashCode());
		result = prime * result
				+ ((plateformId == null) ? 0 : plateformId.hashCode());
		result = prime * result
				+ ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result
				+ ((theDayId == null) ? 0 : theDayId.hashCode());
		result = prime * result
				+ ((unDeductMoney == null) ? 0 : unDeductMoney.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FortuneDeductResult other = (FortuneDeductResult) obj;
		if (confirmOpinion == null) {
			if (other.confirmOpinion != null)
				return false;
		} else if (!confirmOpinion.equals(other.confirmOpinion))
			return false;
		if (deductFailMoney == null) {
			if (other.deductFailMoney != null)
				return false;
		} else if (!deductFailMoney.equals(other.deductFailMoney))
			return false;
		if (deductSucceedMoney == null) {
			if (other.deductSucceedMoney != null)
				return false;
		} else if (!deductSucceedMoney.equals(other.deductSucceedMoney))
			return false;
		if (deductSysIdType == null) {
			if (other.deductSysIdType != null)
				return false;
		} else if (!deductSysIdType.equals(other.deductSysIdType))
			return false;
		if (deductTime == null) {
			if (other.deductTime != null)
				return false;
		} else if (!deductTime.equals(other.deductTime))
			return false;
		if (lendCode == null) {
			if (other.lendCode != null)
				return false;
		} else if (!lendCode.equals(other.lendCode))
			return false;
		if (plateformId == null) {
			if (other.plateformId != null)
				return false;
		} else if (!plateformId.equals(other.plateformId))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (theDayId == null) {
			if (other.theDayId != null)
				return false;
		} else if (!theDayId.equals(other.theDayId))
			return false;
		if (unDeductMoney == null) {
			if (other.unDeductMoney != null)
				return false;
		} else if (!unDeductMoney.equals(other.unDeductMoney))
			return false;
		return true;
	}
	/**
	 * @return the deductResultCode
	 */
	public String getDeductResultCode() {
		return deductResultCode;
	}
	/**
	 * @param deductResultCode the deductResultCode to set
	 */
	public void setDeductResultCode(String deductResultCode) {
		this.deductResultCode = deductResultCode;
	}	
	
	/**
	 * @param 累计失败金额 
	 */
	public String getAllDeductFailMoney() {
		return allDeductFailMoney;
	}
	
	/**
	 * @param 累计失败金额 
	 */
	public void setAllDeductFailMoney(String allDeductFailMoney) {
		this.allDeductFailMoney = allDeductFailMoney;
	}
	
	
}
