package com.creditharmony.core.threenet.entity;

import java.util.Date;

import com.creditharmony.core.persistence.SyncEntity;

/**
 * 同步三网数据批次历史实体
 * 主要用于存储三网中间表数据的同步历史
 * @Class Name ThreeNetDataBatchHistory
 * @author 张永生
 * @Create In 2016年2月29日
 */
public class ThreeNetDataBatchHistory extends SyncEntity<ThreeNetDataBatchHistory>{

	private static final long serialVersionUID = 6908047869948263832L;
	
	private String syncDataBatchId;             // 同步数据批次表的Id
	private Date finishTime;                    // 完成时间
	protected int batchNo;       			    // 批次号,每一次操作就是一个批次
	protected String groupKey;					// 分组key,存储数据格式: userId_moduleName
	protected String groupKeyDesc;				// 分组key的描述,例如t_gl_threenet_user表同步时,此数据列存储的数据格式: userId_moduleName
	protected String syncTableName;             // 同步数据的表名,例如: t_gl_threenet_user
	protected Integer syncStatus;               // 数据同步状态:参见SyncStatus:0-未同步;1-同步失败;2-同步成功
	protected String syncModuleName;			// 需要同步数据到哪个模块的名称
	
	public String getSyncDataBatchId() {
		return syncDataBatchId;
	}
	public void setSyncDataBatchId(String syncDataBatchId) {
		this.syncDataBatchId = syncDataBatchId;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public int getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}
	public String getGroupKey() {
		return groupKey;
	}
	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
	public String getGroupKeyDesc() {
		return groupKeyDesc;
	}
	public void setGroupKeyDesc(String groupKeyDesc) {
		this.groupKeyDesc = groupKeyDesc;
	}
	public String getSyncTableName() {
		return syncTableName;
	}
	public void setSyncTableName(String syncTableName) {
		this.syncTableName = syncTableName;
	}
	public Integer getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	public String getSyncModuleName() {
		return syncModuleName;
	}
	public void setSyncModuleName(String syncModuleName) {
		this.syncModuleName = syncModuleName;
	}
	
	
	
}