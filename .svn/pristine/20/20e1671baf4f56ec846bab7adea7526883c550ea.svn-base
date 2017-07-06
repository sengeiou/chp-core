package com.creditharmony.core.security.dao;

import java.util.List;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.security.entity.PageAuth;

/**
 * 页面权限控制DAO接口
 * @author 周亮
 * @version 2015-11-02
 */
@CoreBatisDao
public interface PageAuthDao extends CrudDao<PageAuth> {
	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	public List<PageAuth> getPageAuthInfo(PageAuth pa);
}
