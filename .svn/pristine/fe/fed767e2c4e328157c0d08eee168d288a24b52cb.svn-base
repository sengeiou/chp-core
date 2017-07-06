package com.creditharmony.core.dict.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.core.cache.DictCache;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.common.util.RunningNumberHelper;
import com.creditharmony.core.dict.dao.DictDao;
import com.creditharmony.core.dict.entity.Dict;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.sync.data.dao.SyncDataBatchDao;
import com.creditharmony.core.sync.data.dao.SyncDictDao;
import com.creditharmony.core.sync.data.entity.SyncDataBatch;
import com.creditharmony.core.sync.data.entity.SyncDict;
import com.creditharmony.core.sync.data.type.NeedSyncTableName;
import com.creditharmony.core.sync.data.type.SyncBizConstants;
import com.creditharmony.core.sync.data.type.SyncGroupKeyType;
import com.creditharmony.core.sync.data.type.SyncSupportModule;
import com.creditharmony.core.sync.data.type.SyncType;
import com.creditharmony.core.sync.data.util.GroupByCaseType;
import com.creditharmony.core.sync.data.util.SyncAssembleHelper;
import com.google.common.collect.Lists;

/**
 * 字典服务
 * @Class Name DictManager
 * @author 张永生
 * @Create In 2015年12月18日
 */
@Service
public class DictManager extends CoreManager<DictDao, Dict> {
	

	@Autowired
	private SyncDataBatchDao syncDataBatchDao;
	@Autowired
	private SyncDictDao syncDictDao;
	
	/**
	 * 查询字典列表
	 * @return
	 */
	public List<String> findTypeList(){
//		return dao.findTypeList(new Dict());//2016-1-25 by何军 从缓存获取数据
		List<Dict> dictList = DictCache.getInstance().getList();
		Set<String> typeSet = new HashSet<String>();
		for(Dict dict:dictList){
			typeSet.add(dict.getType());
		}
		return new ArrayList<String>(typeSet);
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		String syncBizType = "";
		if(dict.getIsNewRecord()){
			syncBizType = SyncType.TYPE_ADD.value;
		}else{
			syncBizType = SyncType.TYPE_MODIFY.value;
		}
		super.save(dict);
		// 插入同步数据表
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncDict);
		saveSyncDict(dict, syncBizType, batchNo);
	}

	@Transactional(readOnly = false)
	public void delete(Dict dict) {
		super.delete(dict);
		// 插入同步数据表
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncDict);
		String syncBizType = SyncType.TYPE_DELETE.value;
		saveSyncDict(dict, syncBizType, batchNo);
	}
	
	public List<Dict> findListByParams(Map<String, Object> params){
		return dao.findListByParams(params);
	}
	
	public Dict getByParams(Map<String, Object> params){
		return dao.getByParams(params);
	}
	
	public Page<Dict> findDictByPage(Page<Dict> page, Map<String,Object> filter) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        PageList<Dict> pageList = (PageList<Dict>)dao.findByParams(filter, pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	/**
	 * 保存同步数据字典对象
	 * 2015年12月28日
	 * By 陈伟东
	 * @param dict
	 * @param syncType
	 * @param batchNo
	 */
	@Transactional(readOnly = false)
	public void saveSyncDict(Dict dict, String syncType, int batchNo) {
		for(Map.Entry<String, String> entry : SyncSupportModule.getSupportModule().entrySet()){
			SyncDataBatch syncDataBatch = SyncAssembleHelper
					.assembleSyncDataBatch(dict.getId(), batchNo,
							entry.getValue(),
							NeedSyncTableName.SYNC_DICT.value,
							SyncGroupKeyType.DICTID_MODULENAME,
							GroupByCaseType.CASE_DICT);
			syncDataBatchDao.insert(syncDataBatch);
			SyncDict syncDict = SyncAssembleHelper.assembleSyncDict(dict,
					syncType, entry.getValue(), batchNo);
			syncDictDao.insert(syncDict);
		}
	}
	
	
	public List<Dict> findListByTypes(List<String> typeList){
		List<Dict> dictNList = Lists.newArrayList();
		List<Dict> dictList = DictCache.getInstance().getList();
		for(Dict dict:dictList){
			if(typeList.contains(dict.getType())){
				dictNList.add(dict);
			}
		}
		return dictNList;
	}

}
