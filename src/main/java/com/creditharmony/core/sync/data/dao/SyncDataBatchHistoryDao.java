package com.creditharmony.core.sync.data.dao;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncDataBatchHistory;

/**
 * 同步数据批次的历史dao
 * @Class Name SyncDataBatchHistoryDao
 * @author 张永生
 * @Create In 2015年12月2日
 */
@CoreBatisDao
public interface SyncDataBatchHistoryDao extends CrudDao<SyncDataBatchHistory> {

}
