package com.creditharmony.core.common.entity.ex;

import java.util.Date;

import com.creditharmony.core.common.entity.DataDomain;

public class DataDomainEx extends DataDomain{

	private static final long serialVersionUID = -9205103141015849643L;
	
	private Date assignTimeStart;		//分配开始时间
	private Date assignTimeEnd;			//分配结束时间
	
	public Date getAssignTimeStart() {
		return assignTimeStart;
	}
	public void setAssignTimeStart(Date assignTimeStart) {
		this.assignTimeStart = assignTimeStart;
	}
	public Date getAssignTimeEnd() {
		return assignTimeEnd;
	}
	public void setAssignTimeEnd(Date assignTimeEnd) {
		this.assignTimeEnd = assignTimeEnd;
	}
	
	
}
