package com.creditharmony.core.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.creditharmony.core.common.entity.DataDomain;
import com.creditharmony.core.common.entity.ex.DataDomainEx;
import com.creditharmony.core.common.entity.ex.StoreAssigned;
import com.creditharmony.core.common.entity.ex.StoresGroupMemberEx;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.User;

@CoreBatisDao
public interface DataDomainDao extends CrudDao<DataDomain> {

	public List<StoresGroupMemberEx> findStoresGroups(DataDomain dataDomain);

	public List<StoresGroupMemberEx> findStoresGroups(DataDomainEx dataDomain,
			PageBounds pageBounds);
	
	/**
	 * 获取当前合同审核组中组员分派的门店
	 * 2016年1月14日
	 * By 陈伟东
	 * @param map 含org（id，type）、dataDomain参数
	 * @param pageBounds
	 * @return
	 */
	public List<StoresGroupMemberEx> findStoresMembers(Map<String,Object> map,
			PageBounds pageBounds);

	public void deleteById(String id);
	
	
	public User getUserOfStoreOwer(DataDomain dataDomain);
	
	/**
	 * 当前登陆人以某种角色身份出现的所有任职部门下的成员的某种门店分配类型的门店分配情况(成员姓名，登陆名，分配门店数量,所属小组)
	 * 
	 * @param param		assignType：门店分配类型（rateApproveMember：利率审核和合同制作分店分配类型，
	 * 												approveMember：合同审核模式为空的门店分配类型，
	 * 												approveMemberTG：同审核模式为TG的门店分配类型）；
	 * 					roleType：角色类型
	 * 					userId：当前登陆用户
	 * @return
	 */
	public List<StoreAssigned> getStoresAssignaList(Map<String,Object> param);
	
	/**
	 * 某种门店分配类型下已分配的门店数量
	 * @param assignType
	 * @return
	 */
	public Integer getTotalCountOfStoreAssigned(@Param("assignType")String assignType);
	
	
	/**
	 * 某种门店分配类型下某门店是否分配
	 * @param param assignType：分配类型，storeId：门店id
	 * @return
	 */
	public Integer getCountTheStoreAssigned(Map<String, Object> param);
	
	
	/**
	 * 某种门店分配类型下某人已分配的门店数量
	 * @param assignType,memberId
	 * @return
	 */
	public Integer getTotalCountOfStoreAssignedAboutPeople(Map<String,Object> param);
	
	/**
	 * 某种门店分配类型下某人已分配的门店
	 * @param assignType,memberId
	 * @return
	 */
	public List<StoreAssigned> getStoreAssignedAboutPeople(Map<String,Object> param);
	
	/**
	 * 某种门店分配类型下尚可分配的门店数量
	 * @param param
	 * @return
	 */
	public Integer getTotalCountOfStoreToAssign(Map<String,String> param);
	
	/**
	 * 某种门店分配类型下尚可分配的门店
	 * @param param
	 * @return
	 */
	public List<Org> getStoresToAssign(Map<String,Object> param);
	
	public Integer getTotalCountOfStoreAssignedByUser(Map<String,Object> param);
}
