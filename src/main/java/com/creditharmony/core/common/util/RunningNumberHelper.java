package com.creditharmony.core.common.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.common.service.RunningNumberEncodable;
import com.creditharmony.core.common.service.RunningNumberManager;

/**
 * 序列号帮助类
 * @Class Name RunningNumberHelper
 * @author 张永生
 * @Create In 2015年12月11日
 */
public class RunningNumberHelper {

	@Autowired
	private RunningNumberManager runningNumberManager;

	private int getNumber(String type) {
		return this.runningNumberManager.createNextNumber(type, 1)[0];
	}

	private int[] getBatchNumber(String type, int count) {
		return this.runningNumberManager.createNextNumber(type, count);
	}

	public static int getNextNumber(RunningNumberEncodable encodable) {
		RunningNumberHelper helper = (RunningNumberHelper) SpringContextHolder.getBean(RunningNumberHelper.class);
		return helper.getNumber(encodable.getPrefix());
	}

	public static String getCode(RunningNumberEncodable encodable) {
		int indexNumber = getNextNumber(encodable);
		return encodable.encode(indexNumber, 0, null);
	}

	public static String[] getBatchCode(RunningNumberEncodable encodable,
			int count) {
		RunningNumberHelper helper = (RunningNumberHelper) SpringContextHolder
				.getBean(RunningNumberHelper.class);
		int[] indexNumbers = helper
				.getBatchNumber(encodable.getPrefix(), count);
		String[] result = new String[count];
		for (int i = 0; i < count; i++) {
			result[i] = encodable.encode(indexNumbers[i], 0, null);
		}
		return result;
	}

}