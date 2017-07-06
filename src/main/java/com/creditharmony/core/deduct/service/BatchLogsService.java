package com.creditharmony.core.deduct.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.IdGen;
import com.creditharmony.core.deduct.dao.BatchLogsMapper;
import com.creditharmony.core.deduct.entity.BatchLogs;
import com.creditharmony.core.persistence.Page;

/**
 * 批处理工作日志
 * @Class Name BatchLogsService
 * @author 施大勇
 * @Create In 2016年03月16日
 */
@Service
public class BatchLogsService {

	@Resource
	private BatchLogsMapper batchLogsMapper;
	
	
	/**
	 * 插入批处理工作日志
	 * @param serviceName
	 * @param log
	 * @param creator
	 * @param groupName
	 */
	@Transactional(readOnly = false)
	public void logGo(String serviceName,String log, String creator,String groupName) {
		BatchLogs bl = new BatchLogs();
		// 批处理名
		bl.setBatchName(serviceName);
		// logId
		bl.setLogId(IdGen.uuid());
		// 批处理组名
		bl.setGroupName(groupName);
		// Log
		bl.setBatchLog(log);
		// 创建人
		bl.setCreatby(creator);
		// 创建时间
		bl.setCreatTime(new Date());
		// 修改人
		bl.setModifyby(creator);
		// 修改时间
		bl.setModifyTime(new Date());
		// 插入log
		batchLogsMapper.insertLogs(bl);
	}
	
	/**
	 * 检索批处理Log
	 * @param batchLogs
	 * @param groupName
	 * @return
	 */
	public List<BatchLogs> getLogList(BatchLogs batchLogs) {
		return batchLogsMapper.selectByPrams(batchLogs);
	}
	
	/**
	 * 检索批处理Log
	 * @param batchLogs
	 * @param groupName
	 * @return
	 */
	public Page<BatchLogs>  getLogListByPage(Page<BatchLogs> page,BatchLogs batchLogs) {
		batchLogs.setPage(page);
		List<BatchLogs> ls = getLogList(batchLogs);
		page.setList(ls);
		return page ;
	}
	/**
	 * 删除久远历史数据
	 * @param groupName
	 * @param batchName
	 */
	@Transactional(readOnly = false)
	public void deleteLogs(String groupName, String batchName) {
		// 日志表初始化
		BatchLogs batchLogs = new BatchLogs();
		batchLogs.setBatchName(batchName);
		batchLogs.setGroupName(groupName);
		int days = -180;
		if ("finance".equals(groupName)) {
			days = -60;
		}
		Date creatTime = daysLater(new Date(), days);
		batchLogs.setCreatTime(creatTime);
		batchLogsMapper.deleteOldLogs(batchLogs);
	}
	
	/**
	 * 获取制定时间N天前或者N天后日期
	 * By zhaojunlei
	 * @param date 初始日期
	 * @param n 偏移量
	 * @return N天后日期 n 如果是负数，那么就是n天前的日期
	 */
	private Date daysLater(Date date,int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, n);
		return calendar.getTime();
	}
}
