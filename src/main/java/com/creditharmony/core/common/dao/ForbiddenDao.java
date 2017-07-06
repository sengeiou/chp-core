package com.creditharmony.core.common.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.creditharmony.core.common.entity.Forbidden;
import com.creditharmony.core.common.entity.ex.ForbiddenEx;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.User;

/**
 * 冻结取新单的数据库操作
 * 
 * @Class Name ForbiddenDao
 * @author 罗俊平
 * @Create In 2016年11月29日
 */
@CoreBatisDao
public interface ForbiddenDao extends CrudDao<Forbidden> {

	/**
	 * 根据当前时间，查出开始时间小于等于当前时间，结束时间大于当前时间的所有委托记录 2016年11月30日 By 罗俊平
	 * 
	 * @param date
	 * @return 将多条记录封装到list中并返回
	 */
	public List<Forbidden> searchForbidden(Date date);

	/**
	 * 插入一条记录 2015年11月30日 By 罗俊平
	 * 
	 * @param record
	 * @return 插入记录数
	 */
	public int insertForbidden(Forbidden record);

	/**
	 * 插入只有某几个字段有值的一条记录 2016年11月30日 By 罗俊平
	 * 
	 * @param record
	 * @return 插入记录数
	 */
	public int insertSelective(Forbidden record);

	/**
	 * 根据用户编码，查找该用户的当前冻结信息 2015年11月30日 By 罗俊平
	 * 
	 * @param param
	 * @return 将多条记录封装到list中并返回
	 */
	public List<Forbidden> findByUserCode(Map<String, Object> param);

	/**
	 * 根据id查找某一条记录 2016年11月30日 By 罗俊平
	 * 
	 * @param id
	 * @return 返回某一条记录
	 */
	public ForbiddenEx getByPrimaryId(String id);

	/**
	 * 更新某几个字段 2016年11月30日 By 罗俊平
	 * 
	 * @param forbidden
	 * @return 更新记录的条数
	 */
	public int updateSelective(Forbidden forbidden);

	/**
	 * 根据主键id删除某一条记录 2016年11月30日 By 罗俊平
	 * 
	 * @param id
	 * @return 删除记录的条数
	 */
	public int deleteByPrimaryId(String id);

	/**
	 * 更新是否启用的状态 2016年11月30日 By 罗俊平
	 * 
	 * @param forbidden
	 */
	public void updateValid(ForbiddenEx forbidden);

	/**
	 * 根据角色(及级别),查出所有用户 2016年11月30日 By 罗俊平
	 * 
	 * @param param
	 * @return 将用户封装到list中并返回
	 */
	public List<User> selectUserByRole(Map<String, Object> param);

	/**
	 * 根据输入的查询条件，返回封装的List信息，其中包含分页信息 2016年11月30日 By 罗俊平
	 * 
	 * @param params
	 * @param pageBounds
	 * @return 将多条记录封装到list中并返回
	 */
	public List<ForbiddenEx> findListByParams(Map<String, Object> params, PageBounds pageBounds);

}