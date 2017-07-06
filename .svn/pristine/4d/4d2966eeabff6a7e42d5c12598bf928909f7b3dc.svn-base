package com.creditharmony.core.users.dao;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.AdditionalUser;

@CoreBatisDao
public interface AdditionalUserDao extends CrudDao<AdditionalUser>{
	
	AdditionalUser selectAdditionalUser(AdditionalUser additionalUser);
	
	/** 
	 * 根据代管账号登录名称 查询代管账号
	 * By 任志远 2017年3月28日
	 *
	 * @param loginName 登录名称
	 * @return
	 */
	AdditionalUser selectAdditionalUserByLoginName(String loginName);

}
