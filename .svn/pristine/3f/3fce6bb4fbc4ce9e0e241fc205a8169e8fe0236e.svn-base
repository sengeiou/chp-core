package com.creditharmony.core.permission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.core.permission.dao.AdditionalPermissionDao;
import com.creditharmony.core.permission.entity.AdditionalPermission;
import com.creditharmony.core.permission.entity.ex.AdditionalPermissionEx;
import com.creditharmony.core.service.CoreManager;

/**
 * 额外权限service
 * @author chenwd
 *
 */
@Service
public class AdditionalPermissionManager extends CoreManager<AdditionalPermissionDao, AdditionalPermission> {
	
	@Autowired
	AdditionalPermissionDao additionalPermissionDao;
	@Autowired
	AdditionalPermissionCacheService additionalPermissionCacheService;
	
	/**
	 * 添加包含子机构的例外权限,更新緩存
	 * @param orgId
	 */
	@Transactional(readOnly = false)
	public void addAdditionalPermissionContainSubOrg(String orgId){
		AdditionalPermission ap = new AdditionalPermission();
		ap.setId(orgId);
		ap.setType(AdditionalPermission.TYPE_ORG);
		ap.setStatus(AdditionalPermission.STATUS_OPEN);
		ap.setScope(AdditionalPermission.SCOPE_10);
		additionalPermissionDao.insert(ap);
		additionalPermissionCacheService.addAdditionalPermission(orgId);
	}
	
	public List<AdditionalPermissionEx> list(AdditionalPermission entity){
		return additionalPermissionDao.list(entity);
	}
	
	/**
	 * 刪除机构的例外权限,更新緩存
	 */
	@Transactional(readOnly = false)
	public void deleteAdditionalPermission(AdditionalPermission entity){
		additionalPermissionDao.delete(entity);
		additionalPermissionCacheService.removeAdditionalPermission(entity.getId());
	}
	
}
