package com.creditharmony.core.system.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.role.type.FortuneRole;
import com.creditharmony.core.users.dao.OrgDao;
import com.creditharmony.core.users.dao.UserRoleOrgDao;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.entity.UserRoleOrg;
import com.creditharmony.core.users.type.BaseDeptOrgType;
import com.creditharmony.core.users.type.FortuneOrgType;
import com.creditharmony.core.users.type.LoanOrgType;
import com.creditharmony.core.users.util.UserUtils;

/**
 * 数据范围工具类
 * @Class Name DataScopeUtil
 * @author 张永生
 * @Create In 2016年1月26日
 */
public class DataScopeUtil {
	protected static Logger logger = LoggerFactory.getLogger(DataScopeUtil.class);
	private static UserRoleOrgDao userRoleOrgDao =  SpringContextHolder.getBean(UserRoleOrgDao.class);
	
	private static OrgDao orgDao = SpringContextHolder.getBean(OrgDao.class);
	
	/**
	 * 获取数据范围
	 * 2016年1月27日
	 * By 张永生
	 * @param bizTableAlias 业务表的别名
	 * @param systemFlag 系统标识
	 * @return
	 */
	public static String getDataScope(String bizTableAlias, int systemFlag) {
		User currentUser = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		String userId = currentUser.getId();
		String orgId = currentUser.getDepartment().getId();
		StringBuilder sqlString = new StringBuilder();
		switch(systemFlag){
			case 2:
				fortuneDataScopeFilter(bizTableAlias, userId, orgId, sqlString);
				break;
			case 3:
				loanDataScopeFilter(bizTableAlias, userId, orgId, sqlString);
				break;
		}
		return sqlString.toString();
	}
	
	/**
	 * 汇金客户咨询数据范围过滤
	 * 2016年3月31日
	 * By 张永生
	 * @param bizTableAlias
	 * @return
	 */
	public static String getLoanConsultDataScope(String bizTableAlias) {
		User currentUser = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		String userId = currentUser.getId();
		String orgId = currentUser.getDepartment().getId();
		StringBuilder sqlString = new StringBuilder();
		loanConsultDataScopeFilter(bizTableAlias, userId, orgId, sqlString);
		return sqlString.toString();
	}
	

	/**
	 * 汇金数据范围过滤
	 * 2016年3月31日
	 * By 张永生
	 * @param bizTableAlias
	 * @param userId
	 * @param orgId
	 * @param sqlString
	 */
	private static void loanDataScopeFilter(String bizTableAlias,
			String userId, String orgId, StringBuilder sqlString) {
		Org org = orgDao.get(orgId);
		String orgType = org != null ? org.getType() : "";
		if (LoanOrgType.TEAM.key.equals(orgType)) {
			sqlString.append(" AND ");
			sqlString.append(bizTableAlias);
			sqlString.append(".loan_team_orgid='");
			sqlString.append(orgId);
			sqlString.append("'");
		} else if (LoanOrgType.STORE.key.equals(orgType)) {
			sqlString.append(" AND ");
			sqlString.append(bizTableAlias);
			sqlString.append(".loan_store_orgid='");
			sqlString.append(orgId);
			sqlString.append("' ");
		} else if (LoanOrgType.PROVINCE_COMPANY.key.equals(orgType)
				|| LoanOrgType.CITY_COMPANY.key.equals(orgType)
				|| LoanOrgType.BUISNESS_DEPT.key.equals(orgType)
				|| LoanOrgType.DISTRICT.key.equals(orgType)) {
			String parentIds = org.getParentIds();
			parentIds = parentIds + org.getId();
			sqlString.append(" AND EXISTS (SELECT 1 FROM jk.t_gl_org bizO ");
			sqlString.append(" WHERE (bizO.parent_ids like ");
			sqlString.append("'");
			sqlString.append(parentIds);
			sqlString.append("%'");
			sqlString.append(" OR ");
			sqlString.append(" bizO.id ='");
			sqlString.append(org.getId());
			sqlString.append("'");
			sqlString.append(") AND bizO.type='");
			sqlString.append(LoanOrgType.STORE.key);
			sqlString.append("'");
			sqlString.append(" AND ");
			sqlString.append(bizTableAlias);
			sqlString.append(".loan_store_orgid=bizO.id");
			sqlString.append(")");
		}else if (BaseDeptOrgType.LOANER_DEPT.key.equals(orgType)) {
			//借款人服务部 查看所有数据,返回的权限sql字符串为空串
		}
	}

	/**
	 * 财富数据范围过滤
	 * 2016年3月31日
	 * By 张永生
	 * @param bizTableAlias
	 * @param userId
	 * @param orgId
	 * @param sqlString
	 */
	private static void fortuneDataScopeFilter(String bizTableAlias, String userId, String orgId,
			StringBuilder sqlString) {
		Org org = orgDao.get(orgId);
		//出借人服务部,数据管理部,财富数据部,呼叫中心的人员查看所有的数据
		if (!BaseDeptOrgType.LENDER_DEPT.key.equals(org != null ? org
				.getType() : "")
				&& !BaseDeptOrgType.DATA_DEPT.key.equals(org != null ? org
						.getType() : "")
						&& !FortuneOrgType.DATA_DEPT.key.equals(org != null ? org
								.getType() : "")
								&& !BaseDeptOrgType.CALL_CUSTOMER_SERVICE.key.equals(org != null ? org
										.getType() : "")) {
			UserRoleOrg uro = new UserRoleOrg();
			uro.setUserId(userId);
			uro.setOrgId(orgId);
			List<UserRoleOrg> uroList = userRoleOrgDao.selUserRoleOrg(uro);
			logger.info("userId="+userId+",orgId="+orgId+"uroList="+uroList);
			if (ArrayHelper.isNotEmpty(uroList) && uroList.size() ==1 && FortuneRole.FINANCING_MANAGER.id.equals(uroList.get(0).getRoleId())) {
				sqlString.append(" AND " + bizTableAlias + ".manager_code ='" + userId +"'");
			}else{
				if(!FortuneOrgType.TEAM.key.equals(org.getType())){
					String parentIds = org.getParentIds();
					parentIds = parentIds + org.getId();
					sqlString.append(" AND EXISTS (SELECT 1 FROM tz.t_gl_org bizO ");
					sqlString.append(" WHERE bizO.parent_ids like ");
					sqlString.append("'");
					sqlString.append(parentIds);
					sqlString.append("%'");
					sqlString.append(" AND ");
					sqlString.append(bizTableAlias);
					sqlString.append(".team_org_id=bizO.id");
					sqlString.append(")");
				}else{
					sqlString.append(" AND ");
					sqlString.append(bizTableAlias);
					sqlString.append(".team_org_id=");
					sqlString.append("'");
					sqlString.append(orgId);
					sqlString.append("'");
				}
			}
		}
		logger.info("当前登录人" + userId + ",权限控制语句：" + sqlString);
	}
	
	/**
	 * 汇金客户咨询数据范围过滤
	 * 2016年3月31日
	 * By 张永生
	 * @param bizTableAlias
	 * @param userId
	 * @param orgId
	 * @param sqlString
	 */
	private static void loanConsultDataScopeFilter(String bizTableAlias,
			String userId, String orgId, StringBuilder sqlString) {
		Org org = orgDao.get(orgId);
		String orgType = org != null ? org.getType() : "";
		if (LoanOrgType.TEAM.key.equals(orgType)) {
			sqlString.append(" AND ");
			sqlString.append(bizTableAlias);
			sqlString.append(".cons_team_orgcode='");
			sqlString.append(orgId);
			sqlString.append("'");
		} else if (LoanOrgType.STORE.key.equals(orgType)) {
			sqlString.append(" AND ");
			sqlString.append(bizTableAlias);
			sqlString.append(".store_orgid='");
			sqlString.append(orgId);
			sqlString.append("' ");
		} else if (LoanOrgType.PROVINCE_COMPANY.key.equals(orgType)
				|| LoanOrgType.CITY_COMPANY.key.equals(orgType)
				|| LoanOrgType.BUISNESS_DEPT.key.equals(orgType)
				|| LoanOrgType.DISTRICT.key.equals(orgType)) {
			String parentIds = org.getParentIds();
			parentIds = parentIds + org.getId();
			sqlString.append(" AND EXISTS (SELECT 1 FROM jk.t_gl_org bizO ");
			sqlString.append(" WHERE (bizO.parent_ids like ");
			sqlString.append("'");
			sqlString.append(parentIds);
			sqlString.append("%'");
			sqlString.append(" OR ");
			sqlString.append(" bizO.id ='");
			sqlString.append(org.getId());
			sqlString.append("'");
			sqlString.append(") AND ");
			sqlString.append(bizTableAlias);
			sqlString.append(".store_orgid=bizO.id");
			sqlString.append(")");
		}else if (LoanOrgType.PROVINCE_COMPANY.key.equals(orgType)
				|| LoanOrgType.CITY_COMPANY.key.equals(orgType)
				|| LoanOrgType.BUISNESS_DEPT.key.equals(orgType)) {
			String parentIds = org.getParentIds();
			parentIds = parentIds + org.getId();
			sqlString.append(" AND EXISTS (SELECT 1 FROM jk.t_gl_org bizO ");
			sqlString.append(" WHERE (bizO.parent_ids like ");
			sqlString.append("'");
			sqlString.append(parentIds);
			sqlString.append("%'");
			sqlString.append(" OR ");
			sqlString.append(" bizO.id ='");
			sqlString.append(org.getId());
			sqlString.append("')");
			sqlString.append(" AND bizO.type='");
			sqlString.append(LoanOrgType.STORE.key);
			sqlString.append("'");
			sqlString.append(" AND ");
			sqlString.append(bizTableAlias);
			sqlString.append(".store_orgid=bizO.id");
			sqlString.append(")");
		}
	}
}
