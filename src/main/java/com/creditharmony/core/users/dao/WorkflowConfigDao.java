package com.creditharmony.core.users.dao;

import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.WorkflowConfig;

/**
 * 工作流配置DAO接口
 * @Class Name WorkflowConfigDao
 * @author 何军
 * @Create In 2016年1月7日
 */
@CoreBatisDao
public interface WorkflowConfigDao extends CrudDao<WorkflowConfig> {

	public WorkflowConfig getWorkflowConfig(WorkflowConfig config);
	
	public WorkflowConfig findWorkflowConfigOne(WorkflowConfig config);
	
	public void updateDispatchInfo(WorkflowConfig config);
	
	public WorkflowConfig getByMap(Map<String,Object> map);
}
