package com.creditharmony.core.moneyaccount.entity;

import com.creditharmony.core.moneyaccount.BaseOutInfo;
import com.creditharmony.core.moneyaccount.IParamInfo;

/**
 * 划拨 (个人与个人之间)响应参数Bean.
 * @Class Name JzhTransferBuOutInfo
 * @author CHP_3.0 接口组
 * @Create In 2016年2月1日
 */
public class JzhTransferBuOutInfo extends BaseOutInfo implements IParamInfo{
    /** 商户代码  */
    private String mchntCd;
    /** 请求流水号. */
    private String mchntTxnSsn;
    
    /**
     * 参数输出.
     * @return Bean中参数集合
     */
	public String getParam() {
		  StringBuilder paramSb = new StringBuilder();
		  paramSb.append("retCode=").append(retCode)
		    .append(", retMsg=").append(retMsg)
	        		.append(", mchntCd=").append(mchntCd)
	                .append(", mchntTxnSsn=").append(mchntTxnSsn);
	        return paramSb.toString();
	}

	/**
	 * 商户代码 的取得处理.
	 *
	 * @return 商户代码
	 */
	public String getMchntCd() {
		return mchntCd;
	}

	/**
	 * 商户代码 的设定处理.
	 *
	 * @param mchntCd
	 *            商户代码
	 */
	public void setMchntCd(String mchntCd) {
		this.mchntCd = mchntCd;
	}

	/**
	 * 请求流水号 的取得处理.
	 *
	 * @return 请求流水号
	 */
	public String getMchntTxnSsn() {
		return mchntTxnSsn;
	}

	/**
	 * 请求流水号 的设定处理.
	 *
	 * @param mchntTxnSsn
	 *            请求流水号
	 */
	public void setMchntTxnSsn(String mchntTxnSsn) {
		this.mchntTxnSsn = mchntTxnSsn;
	}

}
