package com.creditharmony.core.deduct.dao;


import org.apache.ibatis.annotations.Param;

import com.creditharmony.core.deduct.bean.in.DeductReq;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 划扣请求表Dao
 * 
 * @Class Name DeductReqestDao
 * @author 施大勇
 * @Create In 2016年01月26日
 */
@CoreBatisDao
public interface DeductReqDao {

	/**
	 * 插入数据
	 * 
	 * @param record 划扣请求表实体类
	 * @return 插入结果
	 */
    public int insert(DeductReq record);
    /**
     * 更新数据
     * @param requestId 请求ID
     * @param status 状态
     * @return 结果
     */
    public int update(
    		@Param(value = "requestId") String requestId, 
    		@Param(value = "status") String status,
    		@Param(value = "table") String table);
    /**
     * 删除数据 
     * @param requestId 请求ID
     * @return 结果
     */
    public int delete(
    		@Param(value = "requestId") String requestId,
    		@Param(value = "table") String table
    		);
    /**
     * 查看处理状态
     * @param requestId 请求ID
     * @return 结果
     */
    public String selectStatus(
    		@Param(value = "requestId") String requestId,
    		@Param(value = "table") String table
    		);
    /**
     * 查看存在件数
     * @param requestId 请求ID
     * @return 结果
     */
    public Integer selectCount(
    		@Param(value = "requestId") String requestId,
    		@Param(value = "table") String table);
}