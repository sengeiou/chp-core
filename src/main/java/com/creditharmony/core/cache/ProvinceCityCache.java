package com.creditharmony.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.users.dao.ProvinceCityDao;
import com.creditharmony.core.users.entity.ProvinceCity;
import com.google.common.collect.Lists;

/**
 * 省市级缓存
 * 
 * @Class Name RoleCache
 * @author 何军
 * @Create In 2016年1月25日
 */
public class ProvinceCityCache implements BaseCache {

	private static ProvinceCityCache self = new ProvinceCityCache();
	private static String key = ProvinceCity.class.getName();

	public static ProvinceCityCache getInstance() {
		return self;
	}

	@SuppressWarnings("unchecked")
	public Map<String, ProvinceCity> getMap() {
		Map<String, ProvinceCity> provinceCityMap = (Map<String, ProvinceCity>) RedisUtils
				.getMap(key);
		if (provinceCityMap == null) {
			ProvinceCityDao ProvinceCityDao = SpringContextHolder
					.getBean(ProvinceCityDao.class);
			List<ProvinceCity> provinceCityList = ProvinceCityDao
					.findAllList(new ProvinceCity());
			provinceCityMap = new HashMap<String, ProvinceCity>();
			for (ProvinceCity provinceCity : provinceCityList) {
				provinceCityMap.put(provinceCity.getId(), provinceCity);
			}
			RedisUtils.saveMap(key, provinceCityMap);
		}
		return provinceCityMap;
	}

	/**
	 * id获取省市级信息
	 * 
	 * @param uid
	 * @return
	 */
	public ProvinceCity get(String id) {
		Map<String, ProvinceCity> provinceCityMap = getMap();
		if (null != provinceCityMap && null != provinceCityMap.get(id)) {
			return provinceCityMap.get(id);
		}
		return null;
	}

	/**
	 * 根据proviceId, cityId, areaId来查找省市区的中文名称
	 * 格式：山东省济南市历下区
	 * 2016年3月3日
	 * By 张永生
	 * @param province
	 * @param city
	 * @param area
	 * @return
	 */
	public String getProvinceCity(String province, String city, String area) {
		ProvinceCity provinceP = get(province);
		ProvinceCity cityP = get(city);
		ProvinceCity areaP = get(area);
		if (null != provinceP && null != cityP && null != areaP) {
			return provinceP.getAreaName() + cityP.getAreaName()
					+ areaP.getAreaName();
		} else {
			return null;
		}

	}
	
	public List<ProvinceCity> getList() {
		Map<String, ProvinceCity> provinceCityMap = getMap();
		List<ProvinceCity> provinceCityList = Lists.newArrayList();
		if (null != provinceCityMap) {
			for (ProvinceCity provinceCity : provinceCityMap.values()) {
				provinceCityList.add(provinceCity);
			}
		}
		return provinceCityList;
	}
	
	public List<ProvinceCity> getListByParentId(String pid) {
		Map<String, ProvinceCity> provinceCityMap = getMap();
		List<ProvinceCity> provinceCityList = Lists.newArrayList();
		if (null != provinceCityMap) {
			for (ProvinceCity provinceCity : provinceCityMap.values()) {
				if (StringUtils.isNotEmpty(pid)
						&& pid.equals(provinceCity.getParentId())) {
					provinceCityList.add(provinceCity);
				}
			}
		}
		return provinceCityList;
	}

	/**
	 * 根据areaType获取省市级
	 */
	public List<ProvinceCity> getListByType(String areaType) {
		Map<String, ProvinceCity> provinceCityMap = getMap();
		List<ProvinceCity> provinceCityList = Lists.newArrayList();
		if (null != provinceCityMap) {
			for (ProvinceCity provinceCity : provinceCityMap.values()) {
				if (StringUtils.isNotEmpty(areaType)
						&& areaType.equals(provinceCity.getAreaType())) {
					provinceCityList.add(provinceCity);
				}
			}
		}
		return provinceCityList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void save(BaseEntity obj) {
		Map<String, ProvinceCity> provinceCityMap = getMap();
		if (null != obj && obj instanceof ProvinceCity
				&& null != provinceCityMap
				&& null != provinceCityMap.get(obj.getId())
				&& provinceCityMap.get(obj.getId()) instanceof ProvinceCity) {
			provinceCityMap.put(obj.getId(), (ProvinceCity) obj);
			// RedisUtils.remove(key);
			RedisUtils.saveMap(key, provinceCityMap);
		}
	}

	@Override
	public void remove(String id) {
		Map<String, ProvinceCity> provinceCityMap = getMap();
		if (null != provinceCityMap && null != provinceCityMap.get(id)
				&& provinceCityMap.get(id) instanceof ProvinceCity) {
			provinceCityMap.remove(id);
			// RedisUtils.remove(key);
			RedisUtils.saveMap(key, provinceCityMap);
		}
	}
}
