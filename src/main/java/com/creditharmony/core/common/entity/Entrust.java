package com.creditharmony.core.common.entity;

import java.util.Date;

import com.creditharmony.core.persistence.DataEntity;

public class Entrust extends DataEntity<Entrust>{
	
	private static final long serialVersionUID = -1526019757767640274L;

    private String loanCode;

    private String entrustUserCode;

    private String entrustAcceptUserCode;

    private String entrustMsg;

    private String validFlag;

    private Date entrustStartTime;

    private Date entrustEndTime;

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode == null ? null : loanCode.trim();
    }

    public String getEntrustUserCode() {
        return entrustUserCode;
    }

    public void setEntrustUserCode(String entrustUserCode) {
        this.entrustUserCode = entrustUserCode == null ? null : entrustUserCode.trim();
    }

    public String getEntrustAcceptUserCode() {
        return entrustAcceptUserCode;
    }

    public void setEntrustAcceptUserCode(String entrustAcceptUserCode) {
        this.entrustAcceptUserCode = entrustAcceptUserCode == null ? null : entrustAcceptUserCode.trim();
    }

    public String getEntrustMsg() {
        return entrustMsg;
    }

    public void setEntrustMsg(String entrustMsg) {
        this.entrustMsg = entrustMsg == null ? null : entrustMsg.trim();
    }

    public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public Date getEntrustStartTime() {
		return entrustStartTime;
	}

	public void setEntrustStartTime(Date entrustStartTime) {
		this.entrustStartTime = entrustStartTime;
	}

	public Date getEntrustEndTime() {
		return entrustEndTime;
	}

	public void setEntrustEndTime(Date entrustEndTime) {
		this.entrustEndTime = entrustEndTime;
	}

	
}