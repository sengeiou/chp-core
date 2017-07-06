package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.UserRoleOrg;

/**
 * 员工组织结构-dao
 * @Class Name UserOrgDao
 * @author 张永生
 * @Create In 2015年11月16日
 */
@CoreBatisDao
public interface UserRoleOrgDao {
    
    /**
     * 检索员工关联机构
     * @param key
     * @return List<UserOrg>
     */
    List<UserRoleOrg> selUserRoleOrg(UserRoleOrg key);
    
    /**
     * 根据用户获取数据
     * @param key
     * @return
     */
    List<Map<String,String>> selUserRoleOrgByUserId(UserRoleOrg key);
    
    /**
     * 条件查询用户角色机构
     * 2016年1月8日
     * By 张永生
     * @param params
     * @return
     */
    List<UserRoleOrg> query(Map<String,Object> params);
    
    List<UserRoleOrg> findUsersByRidAndOid(List<Map<String,String>> mapList);

	public List<UserRoleOrg> checkHaveAuditor(@Param("orgs") List<String> orgs, @Param("menuId") String menuId);
}