package com.creditharmony.core.excel.fieldtype;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.util.UserUtils;

/**
 * 组织机构字段类型转换工具类
 * @Class Name OrgFieldUtil
 * @author 张永生
 * @Create In 2015年12月19日
 */
public class OrgFieldUtil {

	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		for (Org e : UserUtils.getOrgList()){
			if (StringUtils.trimToEmpty(val).equals(e.getName())){
				return e;
			}
		}
		return null;
	}

	/**
	 * 设置对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null && ((Org)val).getName() != null){
			return ((Org)val).getName();
		}
		return "";
	}
}
