package com.creditharmony.core.common.dao;

import com.creditharmony.core.common.entity.RunningNumber;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;


@CoreBatisDao
public interface RunningNumberDao extends CrudDao<RunningNumber> {
	
	public RunningNumber findByType(String type);
	
}