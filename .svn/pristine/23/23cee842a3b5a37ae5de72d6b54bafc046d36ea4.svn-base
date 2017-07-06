package com.creditharmony.core.cms.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.cms.entity.PolicyRoleOrg;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface PolicyRoleOrgDao  extends CrudDao<PolicyRoleOrg> {
    int insert(PolicyRoleOrg record);

    int insertSelective(PolicyRoleOrg record);
    
    int deletePolicyRoleOrg(Map<String,Object> par);

	void insertPolicyRoleOrg(List<PolicyRoleOrg> policyRoleOrgList);
    
	public List<PolicyRoleOrg> query(String id);
	
	public List<PolicyRoleOrg> selPolicyRoleOrg(String id);
	
}