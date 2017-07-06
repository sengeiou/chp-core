package com.creditharmony.core.users.util;

import com.creditharmony.core.type.PartyType;
import com.creditharmony.core.type.SystemFlag;

/**
 * 系统标志工具类
 * @Class Name SystemFlagHelper
 * @author 张永生
 * @Create In 2016年5月10日
 */
public class SystemFlagHelper {

	/**
	 * 根据机构的主体类型获取系统标识
	 * 2016年5月10日
	 * By 张永生
	 * @param partyType
	 * @return
	 */
	public static int getSystemFlag(String partyType){
		int flag = SystemFlag.OTHER.value;
		if(PartyType.CAIFU.value.equals(partyType)){
			flag = SystemFlag.FORTUNE.value;
			return flag;
		}
		if(PartyType.HUIJIN.value.equals(partyType)){
			flag = SystemFlag.LOAN.value;
			return flag;
		}
		if(PartyType.HUICHENG.value.equals(partyType)){
			flag = SystemFlag.CHECK.value;
			return flag;
		}
		if(PartyType.HUIMIN.value.equals(partyType)){
			flag = SystemFlag.HEAD.value;
			return flag;
		}
		return flag;
	}
}
