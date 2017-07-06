package com.creditharmony.core.cache;

import java.util.HashMap;
import java.util.Map;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.users.dao.WorkflowConfigDao;
import com.creditharmony.core.users.entity.WorkflowConfig;

/**
 * 用户缓存
 * @Class Name WorkflowConfigCache
 * @author 张永生
 * @Create In 2016年1月25日
 */
public class WorkflowCache implements BaseCache {
	
	private static WorkflowCache cache = new WorkflowCache();
	private static String key = WorkflowConfig.class.getName();
	
	private WorkflowConfigDao workflowConfigDao = SpringContextHolder.getBean(WorkflowConfigDao.class);
	
	public static final String SPLIT_CHAR = ":";
	
	public static WorkflowCache getInstance(){
		return cache;
	}
	
	public WorkflowConfig getObject(String id) {
		WorkflowConfig WorkflowConfig = (WorkflowConfig) RedisUtils.getObject(key + SPLIT_CHAR + id);
		return WorkflowConfig;
	}

	@Override
	public WorkflowConfig get(String id) {
		WorkflowConfig WorkflowConfig = getObject(id);
		if (null == WorkflowConfig){
			Map<String,Object> m=new HashMap<String,Object>();
			String[] tmp=id.split(",");
			m.put("systemFlag", tmp[0]);
			m.put("workflowId", tmp[1]);
			m.put("nodeId", tmp[2]);
			WorkflowConfig = workflowConfigDao.getByMap(m);
			if (WorkflowConfig != null) {
				RedisUtils.saveObject(key + SPLIT_CHAR + WorkflowConfig.getId(), WorkflowConfig);
			}
		}
		return WorkflowConfig;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void save(BaseEntity obj) {
		if (null != obj && obj instanceof WorkflowConfig){
			WorkflowConfig WorkflowConfig = (WorkflowConfig)obj;
			RedisUtils.saveObject(key + SPLIT_CHAR + obj.getId(), WorkflowConfig);
		}
	}

	@Override
	public void remove(String id) {
		RedisUtils.remove(key + SPLIT_CHAR + id);
	}
	
}
