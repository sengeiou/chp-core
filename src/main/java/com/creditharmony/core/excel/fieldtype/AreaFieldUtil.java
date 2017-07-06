package com.creditharmony.core.excel.fieldtype;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.users.entity.Area;
import com.creditharmony.core.users.util.UserUtils;

/**
 * 地区字段字段类型转换
 * @Class Name AreaFieldUtil
 * @author 张永生
 * @Create In 2015年12月19日
 */
public class AreaFieldUtil {

	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		for (Area e : UserUtils.getAreaList()){
			if (StringUtils.trimToEmpty(val).equals(e.getName())){
				return e;
			}
		}
		return null;
	}

	/**
	 * 获取对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null && ((Area)val).getName() != null){
			return ((Area)val).getName();
		}
		return "";
	}
}
