package com.creditharmony.core.deduct.bean.out;

import com.creditharmony.core.deduct.bean.in.DeductReq;

/**
 * 划扣结果用实体类
 * 
 * @Class Name DeResult
 * @author 施大勇
 * @Create In 2016年01月27日
 */
public class DeResult {

	/**
	 * 返回消息码
	 */
	private String reCode;
	
	/**
	 * 返回消息
	 */
	private String reMge;
	/**
	 * 提交任务
	 */
	private DeductReq deductReq;

	/**
	 * @return 返回消息码
	 */
	public String getReCode() {
		return reCode;
	}
	/**
	 * @param 返回消息码
	 */
	public void setReCode(String reCode) {
		this.reCode = reCode;
	}
	
	/**
	 * @return 返回消息
	 */
	public String getReMge() {
		return reMge;
	}
	/**
	 * @param 返回消息
	 */
	public void setReMge(String reMge) {
		this.reMge = reMge;
	}

	/**
	 * @return the deductReq
	 */
	public DeductReq getDeductReq() {
		return deductReq;
	}
	/**
	 * @param deductReq the deductReq to set
	 */
	public void setDeductReq(DeductReq deductReq) {
		this.deductReq = deductReq;
	}
	
	public String toString() {
		return "消息码：" + this.reCode + " 返回消息：" + this.reMge;
	}
}
