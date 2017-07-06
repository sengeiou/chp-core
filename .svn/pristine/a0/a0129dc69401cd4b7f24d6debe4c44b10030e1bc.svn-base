package com.creditharmony.core.permission.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.core.permission.dao.AdditionalPermissionDao;
import com.creditharmony.core.permission.entity.AdditionalPermission;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.OrgDao;

/**
 * 额外权限缓存service
 * 
 * @author chenwd
 *
 */
@Service
public class AdditionalPermissionCacheService extends
		CoreManager<AdditionalPermissionDao, AdditionalPermission> {

	private static Logger logger = LoggerFactory
			.getLogger(AdditionalPermissionCacheService.class);

	private static final String ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID = "additional_permission_cache_key_department_id";

	@Autowired
	AdditionalPermissionDao additionalPermissionDao;
	@Autowired
	OrgDao orgDao;

	/**
	 * 判断缓存中是否包括这个组织机构的id
	 * 
	 * @param orgId
	 * @return true:包含;false:不包含
	 */
	public boolean hasDepartmentId(String orgId) {
		List<String> list = RedisUtils.getList(
				ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID, String.class);
		if (list != null && list.size() > 0) {
			return list.contains(orgId);
		} else {
			List<String> cacheList = addAllAdditionalPermissionOrdId();
			if (cacheList != null && cacheList.size() > 0) {
				return cacheList.contains(orgId);
			}else{
				return false;
			}
		}
	}
	/**
	 * 判断缓存中是否包括这些组织机构中的一个
	 * 
	 * @param orgId
	 * @return true:包含;false:不包含
	 */
	public boolean hasDepartmentId(List<String> orgIds) {
		boolean hasDepartmentId = false;
		if(orgIds != null && orgIds.size() > 0){
			for(String orgId:orgIds){
				hasDepartmentId = this.hasDepartmentId(orgId);
				if(hasDepartmentId){
					break;
				}
			}
		}
		return hasDepartmentId;
	}
	
	/**
	 * 添加相应机构和子机构到缓存中
	 * @param orgId
	 */
	public void addAdditionalPermission(String orgId){
		List<String> list = RedisUtils.getList(
				ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID, String.class);
		
		if(list == null || list.size() == 0){
			list = addAllAdditionalPermissionOrdId();
		}
		
		if(list == null){
			list = new ArrayList<String>();
		}
		
		List<String> orgList = getAllOrgId(orgId);
		if(orgList != null && orgList.size() > 0){
			for(String id:orgList){
				list.add(id);
			}
		}
		
		RedisUtils.saveList(ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID, list);
	}
	private List<String> getAllOrgId(String orgId) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("orgId1", orgId);
		param.put("orgId2", orgId);
		List<String> orgList = orgDao.getAllOrgIdAboutOrg(param);
		return orgList;
	}
	
	/**
	 * 从缓存中移除相应机构和子机构
	 * @param orgId
	 */
	public void removeAdditionalPermission(String orgId){
		List<String> list = RedisUtils.getList(
				ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID, String.class);
		
		if(list == null || list.size() == 0){
			list = addAllAdditionalPermissionOrdId();
		}
		
		List<String> orgList = getAllOrgId(orgId);
		if(orgList != null && orgList.size() > 0){
			for(String id:orgList){
				list.remove(id);
			}
		}
		
		RedisUtils.saveList(ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID, list);
	}

	/**
	 * 添加所有启用的权限例外配置的机构id到缓存中。 如果配置的机构id的控制权限包含子机构，则也一同添加进缓存。
	 */
	public List<String> addAllAdditionalPermissionOrdId() {
		
		List<String> cacheList = new ArrayList<String>();

		Map<String, String> params = new HashMap<String, String>();
		params.put("type", AdditionalPermission.TYPE_ORG);
		params.put("status", AdditionalPermission.STATUS_OPEN);

		List<AdditionalPermission> list = additionalPermissionDao
				.findByParams(params);
		if (list != null && list.size() > 0) {
			Map<String, String> param = new HashMap<String, String>();
			for (AdditionalPermission ap : list) {
				if (AdditionalPermission.SCOPE_10.equals(ap.getScope())) {
					param.put("orgId1", ap.getId());
					param.put("orgId2", ap.getId());
					List<String> orgList = orgDao.getAllOrgIdAboutOrg(param);
					cacheList.addAll(orgList);
				} else {
					logger.warn("目前仅仅处理包含子机构的类型");
				}
			}
		}
		if (cacheList.size() == 0) {
			logger.warn("当前加入缓存的机构id为空");
		}
		RedisUtils.remove(ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID);
		RedisUtils.saveList(ADDITIONAL_PERMISSION_CACHE_KEY_DEPARTMENT_ID,
				cacheList);
		return cacheList;
	}

}
