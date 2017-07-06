package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.TreeDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.Org;

/**
 * 组织结构DAO
 * @Class Name OrgDao
 * @author 张永生
 * @Create In 2015年11月16日
 */
@CoreBatisDao
public interface OrgDao extends TreeDao<Org> {
	
	/**
	 * 检索机构
	 * 
	 * @param org
	 * @return List<Org>
	 */
	public List<Org> selOrg(Org org);	
	
	/**
	 * 条件查询组织机构数据
	 * 2015年11月19日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Org> findByParams(Map<String,Object> params);
	
	/**
	 * 根据组织机构编码查询组织机构
	 * 2015年11月19日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public Org getByParams(Map<String,Object> params);
	
	/**
	 * 根据机构编码查询组织机构
	 * 2016年5月17日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Org> findByCode(Map<String,Object> params);
	
	/**
	 * 根据查询条件加载组织机构树
	 * 2015年11月27日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Org> loadByParams(Map<String,Object> params);
	
	/**
	 * 
	 * 2015年11月27日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Org> queryByParams(Map<String,Object> params);
	/**
	 * 
	 * 2015年12月25日
	 * By hejun
	 * @param params
	 * @return
	 */
	public List<Org> queryByUserId(Map<String,Object> params);
	
	/**
	 * 检索员工关联机构
	 * 
	 * @param params
	 * @return
	 */
	public List<Org> selUserSubOrg(Org key);	
	
	/**
	 * 检索所有未被分派的门店
	 * 
	 * 2015年12月24日
	 * By 陈伟东
	 * @param map 含org和area
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Org> findStoresNotAssigned(Map map,PageBounds pageBounds);
	
	/**
	 * 根据Org的条件检索相关机构
	 * 2015年12月24日
	 * By 陈伟东
	 * @param org
	 * @return
	 */
	public List<Org> findOrgsByParams(Org org);
	
	/**
	 * 获取当前登陆人为出借人服务部合同审核组组长角色，且当前所在组织机构为合同审核小组的所有未分配的门店
	 * 
	 * 2016年1月14日
	 * By 陈伟东
	 * @param map 包含user\org\role\area，分别含有当前登陆人id,当前登陆人当前机构id、机构类型、角色类型、区域名称
	 * @param pageBounds
	 * @return
	 */
	public List<Org> findContractGroupStoresNotAssigned(Map<String, Object> map,PageBounds pageBounds);
	
	/**
	 * 获取当前登陆人为出借人服务部合同审核组组长角色，且当前所在组织机构为合同审核小组的所有门店
	 * 
	 * 2016年1月15日
	 * By 陈伟东
	 * @param map 
	 * @return
	 */
	public List<Org> getContractGroupStores(Map<String, Object> map);
	
	/**
	 * 分页查询
	 * 2015年12月30日
	 * By 何军
	 * @param org
	 * @param pageBounds
	 * @return
	 */
	public List<Org> findOrgsByParams(Org org,PageBounds pageBounds);
	
	/**
	 * 分页查询
	 * 2015年12月30日
	 * By 何军
	 * @param org
	 * @param pageBounds
	 * @return
	 */
	public List<Org> findByParentId(Org org,PageBounds pageBounds);
	
	/**
	 * 根据用户获取机构
	 * 2016年5月28日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Map<String,String>> selUserOrgByUserId(Map<String, Object> params);
	
	/**
	 * 更新车借编码
	 * @param org
	 */
	public void updateCarLoanCode(Org org);
	
	/**
	 * 获取用户的所有orgId
	 * 
	 * @param userId
	 * @return
	 */
	public List<String> getAllOrgIdAboutUser(@Param("userId")String userId);
	
	/**
	 * 获取所有指定机构下的所有机构id，包括指定机构自身。
	 * @param orgId
	 * @return
	 */
//	public List<String> getAllOrgIdAboutOrg(@Param("orgId")String orgId);
	public List<String> getAllOrgIdAboutOrg(Map<String, String> param);
	
	/**
	 * 查询所有的机构
	 * 2016年6月27日
	 * By 张永生
	 * @return
	 */
	public List<Org> queryAll();
	
	/**
	 * 找到所有子节点（分页）
	 * 用途：查找所有状态的机构，修正数据使用
	 * 2016年6月27日
	 * By 张永生
	 * @param org
	 * @param pageBounds
	 * @return
	 */
	public List<Org> findByParentIds(Org org,PageBounds pageBounds);
	/**
	 * 校验IP的门店编码或机构编码是否存在
	 * @param org
	 * @return
	 */
	public List<Org> findIpConfigByStoreCode(Org org);
	/**
	 * 指定机构id查出所有的下属
	 * zmq
	 * @param children
	 * @return
	 */
	public List<Org> getOrgByParentIds(Map<String, Object> params);	
	/**
	 * 指定机构id查出所有的下属与得到的storeOrgId是否包含在内
	 * zmq
	 * @param children
	 * @return
	 */
	public List<Org> getOrgByParentIdsAndStoreOrgId(Map<String, Object> params);

	/** 
	 * 根据省、市、区、机构类型查机构
	 * By 任志远 2017年3月9日
	 *
	 * @param params
	 * @return
	 */
	public List<Org> getOrgByTypeAndProvinceAndCityAndDistrict(Map<String, Object> params);	
}
