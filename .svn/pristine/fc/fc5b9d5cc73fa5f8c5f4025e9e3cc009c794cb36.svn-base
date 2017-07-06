package com.creditharmony.core.cms.dao;

import java.util.List;

import com.creditharmony.core.cms.entity.Link;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
/**
 * 链接DAO接口
 * @author zhoushuhua
 * @version 2015-11-23
 */
@CoreBatisDao
public interface LinkDao extends CrudDao<Link> {
	
	public List<Link> findByIdIn(String[] ids);
	
	public int updateExpiredWeight(Link link);
	
}
