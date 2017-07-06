package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.ProvinceCity;

/**
 * 省市区管理-Dao
 * 
 * @Class Name CityDao
 * @author 张永生
 * @Create In 2015年12月4日
 */
@CoreBatisDao
public interface ProvinceCityDao extends CrudDao<ProvinceCity> {

	public List<ProvinceCity> findByParams(Map<String,Object> params);
	
	/**
	 * 检索省市区及下辖地区
	 * 
	 * @param params
	 * @return List<City>
	 */
	public List<ProvinceCity> selCitySub(ProvinceCity key);
}
