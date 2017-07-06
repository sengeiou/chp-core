package com.creditharmony.core.permission.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.permission.entity.AdditionalPermission;
import com.creditharmony.core.permission.entity.ex.AdditionalPermissionEx;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 额外权限控制dao
 * @author chenwd
 *
 */
@CoreBatisDao
public interface AdditionalPermissionDao extends CrudDao<AdditionalPermission> {
	public List<AdditionalPermissionEx> list(AdditionalPermission entity);
	public List<AdditionalPermission> findByParams(Map<String, String> params);
}
