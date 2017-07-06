package com.creditharmony.core.users.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.dto.ThreeNetUserDto;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.User;

/**
 * 用户DAO接口
 * @Class Name UserDao
 * @author 张永生
 * @Create In 2015年11月27日
 */
@CoreBatisDao
public interface UserDao extends CrudDao<User> {
	
	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	public User getByLoginName(User user);
	
	public List<User> getGroupMembers(Org org);
	
	public List<User> getAllGroupMembers(Org org);

	/**
	 * 通过orgId获取用户列表，仅返回用户id和name（树查询用户时用）
	 * @param user
	 * @return
	 */
	public List<User> findUserByOrgId(User user);
	
	/**
	 * 查询全部用户数目
	 * @return
	 */
	public long findAllCount(Map<String,Object> params);
	
	/**
	 * 条件查询用户
	 * 2015年11月12日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<User> findByParams(Map<String,Object> params);
	
	/**
	 * 以User为条件查询用户
	 * 2015年12月24日
	 * By 陈伟东
	 * @param user
	 * @return
	 */
	public List<User> findUsersByParams(User user);
	
	/**
	 * 获取当前审核小组所有组员
	 * 2016年1月14日
	 * By 陈伟东
	 * @param user 含OrgId:当前审核小组id，type:机构类型为合同审核组
	 * @return
	 */
	public List<User> findContractGroupMember(User user);
	
	/**
	 * 分页查询用户列表
	 * 2015年11月30日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<User> findByParams(Map<String,Object> params, PageBounds pageBounds);
	
	public List<User> findByParamsL(Map<String,Object> params, PageBounds pageBounds);
	
	/**
	 * 此方法是上线之后，为了对迁移过来的没有部门的用户数据进行修正，特添加此方法
	 * 2015年11月30日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<User> findUserByParams(Map<String,Object> params, PageBounds pageBounds);
	
	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	public int updatePasswordById(User user);
	
	/**
	 * 更新登录信息，如：登录IP、登录时间
	 * @param user
	 * @return
	 */
	public int updateLoginInfo(User user);
	
	/**
	 * 更新删除状态
	 * 2016年6月22日
	 * By 张永生
	 * @param user
	 * @return
	 */
	public int updateDeleteFlag(User user);
	
	/**
	 * 更新用户状态
	 * 2016年6月22日
	 * By 张永生
	 * @param user
	 * @return
	 */
	public int updateStatus(User user);
	
	/**
	 * 插入用户角色关联数据
	 * 2015年11月27日
	 * By 张永生
	 * @param user
	 * @return
	 */
	public int insertUserRoleOrg(User user);

	/**
	 * 删除用户角色关联数据
	 * 2015年11月27日
	 * By 张永生
	 * @param user
	 * @return
	 */
	public int deleteUserRoleOrg(Map<String,Object> params);
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public int deleteUserByCodeOrName(User user);
	
	/**
	 * 更新用户信息
	 * 2015年11月27日
	 * By 张永生
	 * @param user
	 * @return
	 */
	public int updateUserInfo(User user);
	
	/**
	 * 批量冻结用户
	 * 2016年3月5日
	 * By 何军
	 * @param parentIds
	 */
	public void updateUserFrozen(Map<String,Object> params);
	
	/**
	 * 根据员工号查询用户
	 * 2016年5月25日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<User> findUsersByCodes(Map<String,Object> params);
	
	/**
	 * 根据用户名查询用户
	 * 2016年5月25日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<User> findUsersByLoginName(Map<String,Object> params);
	
	/**
	 * 条件查询同一个组织机构下的上级领导
	 * 2016年4月5日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<User> findLeaders(Map<String,Object> params);
	
	/**
	 * 根据user_code 查询离职理财经理
	 * 2016年6月21日
	 * By 胡体勇
	 * @param params
	 * @return
	 */
	public ThreeNetUserDto findManagerInfo(Map<String,Object> params);
	
	/**
	 * 查询发送用户信息
	 * 2016年6月21日
	 * By 胡体勇
	 * @param params
	 * @return
	 */
	public ThreeNetUserDto findSendInfo(Map<String,Object> params);
	
	
	public ThreeNetUserDto findSendInfoById(Map<String,Object> params);
	
	
	/**
	 * 新增根据用户ID查找用户的方法
	 * 用于修正迁移过来的用户数据，不从缓存中取用户
	 * 2016年6月27日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public User getUserById(String id);
	
	
	public int checkStoreCodeExist(String username,String phone);
	
	/**
	 * 更新短信验证码
	 * @param user
	 * @return
	 * By zhangyan
	 */
	public int updateCodeByLoginName(User user);
	
	public int updateUserTime(Map<String,Object> params);
	
	public List<User> findUserTemporary(Map<String, Object> params);	
	/**
	 * 根据userCode RoleId OrgId 查询用户
	 * By 任志远 2017年3月28日
	 *
	 * @param params
	 * @return
	 */
	public User findUserByUserCodeAndRoleAndOrg(Map<String, Object> params);
}
