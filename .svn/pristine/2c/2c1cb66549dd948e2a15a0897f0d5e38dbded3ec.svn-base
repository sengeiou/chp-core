package com.creditharmony.core.users.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.core.role.type.ApproveRole;
import com.creditharmony.core.role.type.BaseRole;
import com.creditharmony.core.role.type.FortuneRole;
import com.creditharmony.core.role.type.LoanRole;
import com.creditharmony.core.type.AdminUserFlag;
import com.creditharmony.core.users.dao.UserRoleOrgDao;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.entity.UserRoleOrg;
import com.google.common.collect.Maps;

/**
 * 用户角色机构服务类
 * @Class Name UserRoleOrgManager
 * @author 张永生
 * @Create In 2016年5月10日
 */
@Service
public class UserRoleOrgManager {


	@Autowired
	private UserRoleOrgDao userRoleOrgDao;
	
	/**
	 * 条件查询用户角色机构o
	 * 2016年5月10日
	 * By 张永生
	 * @param params
	 * @return
	 */
    public List<UserRoleOrg> findList(Map<String, Object> params){
    	return userRoleOrgDao.query(params);
    }
    
	/**
	 * 判断当前登录用户是否是财富人管室的管理员
	 * 2016年6月16日
	 * By 张永生
	 * @param userInfo
	 * @return
	 */
	public String getAdminUserFlag(User userInfo) {
		String deptId = getCurrentDepartmentId(userInfo);
		String adminUserFlag = null;
		Map<String,Object> params = Maps.newHashMap();
		params.put("userId", userInfo.getId());
		params.put("orgId", deptId);
		List<UserRoleOrg> userRoleOrgs = findList(params);
		for(UserRoleOrg uro : userRoleOrgs){
			if(FortuneRole.PERSONNEL_ADMIN.id.equals(uro.getRoleId())){
				adminUserFlag = AdminUserFlag.FORTUNE_HUMAN_OFFICE_ADMIN;
				break;
			}
			if(LoanRole.LOAN_PERSONNEL_ADMIN.id.equals(uro.getRoleId())){
				adminUserFlag = AdminUserFlag.LOAN_HUMAN_OFFICE_ADMIN;
				break;
			}
			if(ApproveRole.APPROVE_PERSONNEL_ADMIN.id.equals(uro.getRoleId())){
				adminUserFlag = AdminUserFlag.APPROVE_HUMAN_OFFICE_ADMIN;
				break;
			}
			if(BaseRole.LOANER_DEPT_ADMIN.id.equals(uro.getRoleId())){
				adminUserFlag = AdminUserFlag.LOANER_DEPT_ADMIN;
				break;
			}
			if(BaseRole.LENDER_DEPT_ADMIN.id.equals(uro.getRoleId())){
				adminUserFlag = AdminUserFlag.LENDER_DEPT_ADMIN;
				break;
			}
			if(BaseRole.HUIMIN_BIZ_DEPT_ADMIN.id.equals(uro.getRoleId())){
				adminUserFlag = AdminUserFlag.HUIMIN_BIZ_DEPT_ADMIN;
				break;
			}
			if(LoanRole.DIAN_XIAO_DEPT_ADMIN.id.equals(uro.getRoleId())){
				adminUserFlag = AdminUserFlag.DIAN_XIAO_DEPT_ADMIN;
				break;
			}
		}
		return adminUserFlag;
	}
	
	/**
	 * 获得当前登录人的部门Id
	 * 2016年6月16日
	 * By 张永生
	 * @param userInfo
	 * @return
	 */
	public String getCurrentDepartmentId(User userInfo) {
		String deptId = userInfo.getDepartment() != null ? userInfo
				.getDepartment().getId() : "";
		return deptId;
	}
}
