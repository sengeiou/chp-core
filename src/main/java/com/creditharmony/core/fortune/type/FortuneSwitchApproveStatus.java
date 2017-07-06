package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/**
 * 转投标识
 * @Class Name FortuneChannelFlag
 * @author 陈晓强
 * @Create In 2016年11月5日
 */
public enum FortuneSwitchApproveStatus {
	
	DSP("1","待审批"),
	SPCG("2","审批成功"),
	SPSB("3","审批失败"),
	WZT("4","未转投"),
	CXZT("5","撤销转投"),
	ZTCG("6","转投成功");
	
	public final String value;
	
	public final String name;

	private FortuneSwitchApproveStatus(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public static Map<String, FortuneSwitchApproveStatus> switchApproveStatusMap ;
	
	static {
		switchApproveStatusMap = new Hashtable<String, FortuneSwitchApproveStatus>();
		switchApproveStatusMap.put(FortuneSwitchApproveStatus.DSP.value, DSP);
		switchApproveStatusMap.put(FortuneSwitchApproveStatus.SPCG.value, SPCG);
		switchApproveStatusMap.put(FortuneSwitchApproveStatus.SPSB.value, SPSB);
		switchApproveStatusMap.put(FortuneSwitchApproveStatus.WZT.value, WZT);
		switchApproveStatusMap.put(FortuneSwitchApproveStatus.CXZT.value, CXZT);
		switchApproveStatusMap.put(FortuneSwitchApproveStatus.ZTCG.value, ZTCG);
	}
	
	public static FortuneSwitchApproveStatus getSwitchApproveStatus(String value) {
		return switchApproveStatusMap.get(value);
	}

}
