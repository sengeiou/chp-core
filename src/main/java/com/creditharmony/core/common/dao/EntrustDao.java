package com.creditharmony.core.common.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.creditharmony.core.common.entity.Entrust;
import com.creditharmony.core.common.entity.ex.EntrustEx;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.User;

/**
 * 委托管理的数据库操作
 * @Class Name EntrustDao
 * @author 王浩
 * @Create In 2015年12月9日
 */
@CoreBatisDao
public interface EntrustDao extends CrudDao<Entrust>{
	
	/**
	 * 根据当前时间，查出开始时间小于等于当前时间，结束时间大于当前时间的所有委托记录
	 * 2016年1月29日
	 * By 王浩
	 * @param date
	 * @return 将多条记录封装到list中并返回
	 */
	public List<Entrust> searchEntrust(Date date); 
	
    /**
     * 插入一条记录
     * 2015年12月9日
     * By 王浩
     * @param record
     * @return 插入记录数
     */
	public int insertEntrust(Entrust record);

    /**
     * 插入只有某几个字段有值的一条记录
     * 2015年12月9日
     * By 王浩
     * @param record
     * @return 插入记录数
     */
	public int insertSelective(Entrust record);
    
    /**
     * 根据输入的查询条件，返回封装的List信息，其中包含分页信息
     * 2015年12月9日
     * By 王浩
     * @param params
     * @param pageBounds
     * @return 将多条记录封装到list中并返回
     */
	public List<EntrustEx> findListByParams(Map<String,Object> params, PageBounds pageBounds);  
    
    /**
     * 根据用户编码，查找该用户的当前委托
     * 2015年12月9日
     * By 王浩
     * @param param
     * @return 将多条记录封装到list中并返回
     */
	public List<Entrust> findByUserCode(Map<String,Object> param);
    
	/**
	 * 根据id查找某一条记录
	 * 2015年12月9日
	 * By 王浩
	 * @param id
	 * @return 返回某一条记录
	 */
	public EntrustEx getByPrimaryId(String id);
	
	/**
	 * 根据id查找某一条记录
	 * 2016年12月23日
	 * @param id
	 * @return 返回某一条记录
	 */
	public EntrustEx getByPrimaryIdNew(String id);
    
    /**
     * 更新某几个字段
     * 2015年12月9日
     * By 王浩
     * @param entrust
     * @return 更新记录的条数
     */
	public int updateSelective(Entrust entrust);
    
    /**
     * 根据主键id删除某一条记录
     * 2015年12月9日
     * By 王浩
     * @param id
     * @return 删除记录的条数
     */
	public int deleteByPrimaryId(String id);
	
	/**
	 * 更新是否启用的状态
	 * 2016年2月5日
	 * By 王浩
	 * @param entrust 
	 */
	public void updateValid(EntrustEx entrust);	
        
    /**
     * 根据输入的机构、部门的参数，查找同部门下的用户
     * 2015年12月9日
     * By 王浩
     * @param param
     * @return 将用户封装到list中并返回
     */
	public List<User> selectUserByParams(Map<String,Object> param);
	
	/**
	 * 根据前一个用户的角色，查出角色相同的其他用户
	 * 2016年1月22日
	 * By 王浩
	 * @param param
	 * @return 将用户封装到list中并返回
	 */
	public List<User> selectOtherByPrevUser(Map<String,Object> param);
	
	/**
	 * 根据角色(及级别),查出所有用户
	 * 2016年1月22日
	 * By 王浩
	 * @param param
	 * @return 将用户封装到list中并返回
	 */
	public List<User> selectUserByRole(Map<String,Object> param);
	
	/**
	 * 根据list中的用户id，查处用户的名字
	 * 2016年1月22日
	 * By 王浩
	 * @param itemList
	 * @return 将用户封装到list中并返回
	 */
	public List<User> selectUserNames(List<String> itemList);
	
	/**
	 * 获取当前用户的机构及级别信息
	 * 2016年3月15日
	 * By 王浩
	 * @param param
	 * @return 封装信息
	 */
	public EntrustEx getCurrenUserInfo(Map<String,Object> param);
	
}