package com.creditharmony.core.excel.fieldtype;

import java.util.List;

import com.creditharmony.common.util.Collections3;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.service.RoleManager;
import com.google.common.collect.Lists;

/**
 * 角色字段类型转换工具类
 * @Class Name RoleFieldUtil
 * @author 张永生
 * @Create In 2015年12月19日
 */
public class RoleFieldUtil {

	private static RoleManager roleManager = SpringContextHolder.getBean(RoleManager.class);
	
	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		List<Role> roleList = Lists.newArrayList();
		List<Role> allRoleList = roleManager.findAllRole();
		for (String s : StringUtils.split(val, ",")){
			for (Role e : allRoleList){
				if (StringUtils.trimToEmpty(s).equals(e.getName())){
					roleList.add(e);
				}
			}
		}
		return roleList.size()>0?roleList:null;
	}

	/**
	 * 设置对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null){
			@SuppressWarnings("unchecked")
			List<Role> roleList = (List<Role>)val;
			return Collections3.extractToString(roleList, "name", ", ");
		}
		return "";
	}
	
}
