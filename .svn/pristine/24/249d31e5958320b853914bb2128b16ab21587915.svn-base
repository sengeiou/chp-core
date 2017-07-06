package com.creditharmony.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.users.dao.OrgDao;
import com.creditharmony.core.users.entity.Org;
import com.google.common.collect.Lists;

/**
 * 组织机构缓存
 * 
 * @Class Name OrgCache
 * @author 张永生
 * @Create In 2016年1月25日
 */
public class OrgCache implements BaseCache {

	private static OrgCache cache = new OrgCache();
	private static String key = Org.class.getName();

	public static OrgCache getInstance() {
		return cache;
	}
	
	public List<Org> getList() {
		Map<String,Org> orgMap = getMap();
		List<Org> orgList = Lists.newArrayList();
		if(null != orgMap){
			for (Object obj : orgMap.values()) {
				orgList.add((Org)obj);
		    }
		}
		return orgList;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Org> getMap() {
		Map<String,Org> orgMap =  (Map<String,Org>) RedisUtils.getMap(key);
		if (orgMap == null) {
			OrgDao orgDao = SpringContextHolder.getBean(OrgDao.class);
			List<Org> orgList = orgDao.findAllList(new Org());
			orgMap = new HashMap<String,Org>();
			for(Org org:orgList){
				orgMap.put(org.getId(), org);
			}
			RedisUtils.saveMap(key, orgMap);
		}
		return orgMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Org> getMapByTypeId(String typeId){
		Map<String,Org> orgMap =  (Map<String,Org>) RedisUtils.getMap(typeId);
		if (orgMap == null || orgMap.isEmpty()) {
			OrgDao orgDao = SpringContextHolder.getBean(OrgDao.class);
			Org org = new Org();
			org.setTypeId(typeId);
			List<Org> orgList = orgDao.findAllList(org);
			orgMap = new HashMap<String,Org>();
			for(Org orgTemp:orgList){
				orgMap.put(orgTemp.getId(), orgTemp);
			}
			RedisUtils.saveMap(typeId, orgMap);
		}
		return orgMap;
	}
	
	public Org getByTypeIdAndId(String typeId,String id){
		Map<String,Org> orgMap = getMapByTypeId(typeId);
		if ( null != orgMap && null != orgMap.get(id) && orgMap.get(id) instanceof Org){
			return (Org)orgMap.get(id);
		}
		return null;
	}

	@Override
	public Org get(String id) {
		Map<String,Org> orgMap = getMap();
		if ( null != orgMap && null != orgMap.get(id) && orgMap.get(id) instanceof Org){
			return (Org)orgMap.get(id);
		}
		return null;
	}
	
	public Org getByName(String name) {
		Map<String,Org> orgMap = getMap();
		Org orgN = null;
		if (null != orgMap){
			for(Map.Entry<String, Org> entry : orgMap.entrySet()){
				Org item = entry.getValue();
				if (StringUtils.isNotEmpty(item.getName())
						&& name.equals(item.getName())) {
					orgN = item;
					break;
				}
			}
		}
		return orgN;
	}
	
	/**
	 * 根据门店编码查找门店
	 * @param storeCode
	 * @return
	 */
	public Org getByStoreCode(String storeCode) {
		Map<String,Org> orgMap = getMap();
		Org orgN = null;
		if (null != orgMap){
			for(Map.Entry<String, Org> entry : orgMap.entrySet()){
				Org item = entry.getValue();
				if (StringUtils.isNotEmpty(item.getStoreCode())
						&& storeCode.equals(item.getStoreCode())) {
					orgN = item;
					break;
				}
			}
		}
		return orgN;
	}
	
	/**
	 * 根据车借编码查找门店
	 * @param carLoanCode
	 * @return
	 */
	public Org getByCarLoanCode(String carLoanCode) {
		Map<String,Org> orgMap = getMap();
		Org orgN = null;
		if (null != orgMap){
			for(Map.Entry<String, Org> entry : orgMap.entrySet()){
				Org item = entry.getValue();
				if (StringUtils.isNotEmpty(item.getCarLoanCode())
						&& carLoanCode.equals(item.getCarLoanCode())) {
					break;
				}
			}
		}
		return orgN;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void save(BaseEntity obj) {
		Map<String,Org> orgMap = getMap();
		if (null != obj && obj instanceof Org && null != orgMap){
			Org org = (Org)obj;
			org.setParent(get(org.getParentId()));
			orgMap.put(obj.getId(),org);
//			RedisUtils.remove(key);
			RedisUtils.saveMap(key,orgMap);
		}
	}

	@Override
	public void remove(String id) {
		Map<String,Org> orgMap = getMap();
		if (null != orgMap && null != orgMap.get(id) && orgMap.get(id) instanceof Org){
			orgMap.remove(id);
//			RedisUtils.remove(key);
			RedisUtils.saveMap(key,orgMap);
		}
	}

}
