package com.creditharmony.core.cms.dao;

import com.creditharmony.core.cms.entity.Site;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
/**
 * 站点DAO接口
 * @author zhoushuhua
 * @version 2015-11-23
 */
@CoreBatisDao
public interface SiteDao extends CrudDao<Site> {

}
