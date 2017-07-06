package com.creditharmony.core.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creditharmony.core.cache.ProvinceCityCache;
import com.creditharmony.core.common.type.CityConstant;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.ProvinceCityDao;
import com.creditharmony.core.users.entity.ProvinceCity;

/**
 * 省市县服务类
 * @Class Name ProvinceCityManager
 * @author 张永生
 * @Create In 2015年12月4日
 */
@Service
public class ProvinceCityManager extends CoreManager<ProvinceCityDao, ProvinceCity> {
	
	public List<ProvinceCity> findCity(String provinceId){
		return ProvinceCityCache.getInstance().getListByParentId(provinceId);
	}
	
	public List<ProvinceCity> findProvince(){
		return ProvinceCityCache.getInstance().getListByParentId(CityConstant.ROOT_ID+"");
	}
	
	public ProvinceCity get(String id){
		return ProvinceCityCache.getInstance().get(id);
	}
	
	public List<ProvinceCity> findDistrict(String cityId){
		return ProvinceCityCache.getInstance().getListByParentId(cityId);
	}
	
	public String getProvinceCity(String province, String city, String area){
		return ProvinceCityCache.getInstance().getProvinceCity(province, city, area);
	}
}
