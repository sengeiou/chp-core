package com.creditharmony.core.cache;

import com.creditharmony.core.persistence.BaseEntity;

public interface BaseCache {
	@SuppressWarnings("rawtypes")
	public BaseEntity get(String id);
	
	@SuppressWarnings("rawtypes")
	public void save(BaseEntity obj);
	
	public void remove(String id);

}
