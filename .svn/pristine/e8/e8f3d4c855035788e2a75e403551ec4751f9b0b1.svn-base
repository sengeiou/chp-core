package com.creditharmony.core.deduct.dao;

import java.util.List;

import com.creditharmony.core.deduct.entity.BatchLogs;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 批处理工作日志表
 * @author 施大勇
 * 2016年0316日
 */
@CoreBatisDao
public interface BatchLogsMapper {
    
	/**
	 * 以创建日期删除 
	 * @param creatTime 创建日期
	 * @return 结果
	 */
    public int deleteOldLogs(BatchLogs record);
    
    /**
     * 根据参数检索数据
     * @param record 输入参数
     * @return 结果
     */
    public List<BatchLogs> selectByPrams(BatchLogs record);

    /**
     * 插入日志
     * @param record 输入参数
     * @return 结果
     */
    public int insertLogs(BatchLogs record);
    
    /**
     * 检索特定日志件数
     * @param record 输入参数
     * @return 结果
     */
    public Long selectCount(BatchLogs record);

}