package com.creditharmony.core.common.dao;

import org.apache.ibatis.annotations.Param;

import com.creditharmony.core.common.entity.BusinessSeq;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 业务流水号dao
 * @Class Name BusinessSeqDao
 * @author 陈伟东
 * @Create In 2015年12月11日
 */
@CoreBatisDao
public interface BusinessSeqDao extends CrudDao<BusinessSeq> {

	/**
	 * 根据流程类型和代表日期的数值获取业务流水号对象
	 * 2015年12月14日
	 * By 陈伟东
	 * @param flowType 流程类型
	 * @param day 代表日期的数值
	 * @return
	 */
	public int findBusinessSeq(@Param("flowType")String flowType,
											 @Param("day")int day);
	
	/**
	 * 插入业务流程信息
	 * 2015年12月14日
	 * By 陈伟东
	 * @param flowType 流程类型
	 * @param day 代表日期的数值
	 * @param seq 流水号
	 * @return
	 */
	public int insertBusinessSeq(@Param("flowType")String flowType,
								 @Param("day")int day, 
								 @Param("seq")int seq);
	
	/**
	 * 根据流程类型和日期数值对流水号seq增加1
	 * 2015年12月14日
	 * By 陈伟东
	 * @param flowName 流程类型
	 * @param day 代表日期的数值
	 * @return
	 */
	public int updateBusinessSeq(@Param("flowType")String flowType, 
								 @Param("day")int day);
	/**
	 * 根据流程类型和日期数值对流水号seq增加1
	 * 2016年5月7日
	 * By 陈伟东
	 * @param flowName 查询条件，流程类型
	 * @param day 查询条件，代表日期的数值
	 * @param seq 查询条件，当前seq作为version条件
	 * @return
	 */
	public int updateSeq(@Param("flowType")String flowType, 
			@Param("day")int day,@Param("seq")int seq);
}
