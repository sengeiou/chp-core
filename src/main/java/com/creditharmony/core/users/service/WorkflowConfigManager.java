package com.creditharmony.core.users.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.core.cache.WorkflowCache;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.WorkflowConfigDao;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.entity.WorkflowConfig;

/**
 * 工作流配置
 * @Class Name WorkflowConfigManager
 * @author 何军
 * @Create In 2016年1月7日
 */
@Service
public class WorkflowConfigManager extends CoreManager<WorkflowConfigDao, WorkflowConfig> {
	//id=system_flag,workflow_id,system_flag
	public WorkflowConfig getWorkflowConfig(String id){
		WorkflowConfig workflowConfig = get(new WorkflowConfig(id));
		return workflowConfig;
	}
	
	public WorkflowConfig get(String id){
		return dao.get(id);
	}
	
	public List<WorkflowConfig> findList(WorkflowConfig workflowConfig){
		return dao.findList(workflowConfig);
	}
	
	@Transactional(readOnly = false)
	public void save(WorkflowConfig workflowConfig) {
		WorkflowCache wfc=WorkflowCache.getInstance();
		super.save(workflowConfig);
		wfc.save(workflowConfig);
	}
	
	@Transactional(readOnly = false)
	public void delete(WorkflowConfig workflowConfig) {
		WorkflowCache wfc=WorkflowCache.getInstance();
		wfc.remove(workflowConfig.getId());
		super.delete(workflowConfig);
	}
	
	public WorkflowConfig getWorkflowConfig(WorkflowConfig config){
		WorkflowConfig workflowConfig = dao.getWorkflowConfig(config);
		return workflowConfig;
	}
	
	public WorkflowConfig findWorkflowConfigOne(WorkflowConfig config){
		WorkflowConfig workflowConfig = dao.findWorkflowConfigOne(config);
		return workflowConfig;
	}
	
	@Transactional(readOnly=false)
	public void updateDispatchInfo(WorkflowConfig config){
		dao.updateDispatchInfo(config);
	}
	
	
}
