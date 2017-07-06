package com.creditharmony.core.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.ObjectHelper;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.dict.dao.DictDao;
import com.creditharmony.core.dict.entity.Dict;
import com.creditharmony.core.persistence.BaseEntity;
import com.google.common.collect.Lists;

public class DictCache implements BaseCache {
	private static DictCache self = new DictCache();
	private static String key = Dict.class.getName();

	public static DictCache getInstance() {
		return self;
	}

	@SuppressWarnings("unchecked")
	public Map<String,Dict> getMap() {
		Map<String,Dict> dictMap =  (Map<String,Dict>) RedisUtils.getMap(key);
		if (dictMap == null) {
			DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
			List<Dict> dictList = dictDao.findAllList(new Dict());
			dictMap = new HashMap<String,Dict>();
			for(Dict dict:dictList){
				dictMap.put(dict.getId(), dict);
			}
			RedisUtils.saveMap(key, dictMap);
		}
		return dictMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Dict> getDicts(String keyType) {
		Map<String,Dict> dictMap = null;
		if(keyType!=null && !keyType.equals("")){
			dictMap = (Map<String,Dict>) RedisUtils.getMap(keyType);
		}
		if (dictMap == null) {
			DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
			Dict d = new Dict();
			d.setType(keyType);
			List<Dict> dictList = dictDao.findAllList(d);
			dictMap = new HashMap<String,Dict>();
			for(Dict dict:dictList){
				dictMap.put(dict.getId(), dict);
			}
			RedisUtils.saveMap(keyType, dictMap);
		}
		return dictMap;
	}

	@Override
	public Dict get(String id) {
		Map<String,Dict> dictMap =  getMap();
		if ( null != dictMap && null != dictMap.get(id) && dictMap.get(id) instanceof Dict){
			return dictMap.get(id);
		}
		return null;
	}

	/**
	 * 根据type获取字典集合，涉及申请表需要的字典时，旧版使用这个方法
	 * By 任志远	2016年9月20号
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dict> getListByType(String type) {
		Map<String,Dict> dictMap =  getMap();
		List<Dict> dictList = Lists.newArrayList();
		if(null != dictMap){
			for (Dict dict : dictMap.values()) {
				if (null != dict.getType() && dict.getType().equals(type) && matchingDict(dict, false)) {
					//获取申请表旧版本的字典值(过滤掉新版字典值)
					dictList.add(dict);
				}
		    }
		}
		Collections.sort(dictList);
		return dictList;
	}
	
	/**
	 * 根据type获取字典集合 (涉及申请表需要的字典时，新版使用这个方法)
	 * By 任志远	2016年9月20号
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dict> getNewListByType(String type) {
		List<Dict> dictList = RedisUtils.getList(type, Dict.class);
		if(ObjectHelper.isEmpty(dictList)){
			dictList = new ArrayList<Dict>();
			//查询数据库
			DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("type", type);
			List<Dict> dbDictList = dictDao.findListByParams(params);
			for (Dict dict : dbDictList) {
				//获取申请表新版本的字典值(过滤掉旧版字典值)
				if (null != dict.getType() && dict.getType().equals(type) && matchingDict(dict, true)) {
					dictList.add(dict);
				}
		    }
			RedisUtils.saveList(type, dictList);
		}
		Collections.sort(dictList);
		return dictList;
	}
	
	/**
	 * 根据type获取字典集合, (涉及申请表需要的字典时，获取新旧版本所有字典)
	 * By 任志远	2016年9月20号
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dict> getAllListByType(String type) {
		Map<String,Dict> dictMap =  getMap();
		List<Dict> dictList = Lists.newArrayList();
		if(null != dictMap){
			for (Dict dict : dictMap.values()) {
				if (null != dict.getType() && dict.getType().equals(type)) {
					dictList.add(dict);
				}
		    }
		}
		Collections.sort(dictList);
		return dictList;
	}
	
	public String getDictLabelTemp(String type,String value){
		Map<String, Dict> dictMap = getDicts(type);
		String label = StringUtils.EMPTY;
		if (null != dictMap) {
			for (Dict dict : dictMap.values()) {
				if (null != dict.getType() && dict.getType().equals(type)
						&& dict.getValue().equals(value)) {
					label = dict.getLabel();
				}
			}
		}
		return label;
	}
	public String getDictLabel(String type, String value) {
		Map<String, Dict> dictMap = getMap();
		String label = StringUtils.EMPTY;
		if (null != dictMap) {
			for (Dict dict : dictMap.values()) {
				if (null != dict.getType() && dict.getType().equals(type)
						&& dict.getValue().equals(value)) {
					label = dict.getLabel();
				}
			}
		}
		return label;
	}
	public String getDictValue(String type, String label) {
		Map<String, Dict> dictMap = getMap();
		String value = StringUtils.EMPTY;
		if (null != dictMap) {
			for (Dict dict : dictMap.values()) {
				if (null != dict.getType() && dict.getType().equals(type)
						&& dict.getLabel().equals(label)) {
					value = dict.getValue();
				}
			}
		}
		return value;
	}
	
	public List<Dict> getList() {
		Map<String,Dict> dictMap =  getMap();
		List<Dict> dictList = Lists.newArrayList();
		if(null != dictMap){
			for (Dict dict : dictMap.values()) {
				dictList.add(dict);
			}
		}
		return dictList;
	}

	@SuppressWarnings("unchecked")
	public List<Dict> getListByPid(String parentId,String type) {
		Map<String,Dict> dictMap =  getMap();
		List<Dict> dictList = Lists.newArrayList();
		if(null != dictMap){
			for (Dict dict : dictMap.values()) {
				if (null != dict.getType() && dict.getType().equals(type) && null != dict.getParentId()&& dict.getParentId().equals(parentId)) {
					dictList.add(dict);
				}
		    }
		}
		Collections.sort(dictList);
		return dictList;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void save(BaseEntity obj) {
		Map<String,Dict> dictMap =  getMap();
		if (null != obj && obj instanceof Dict && null != dictMap){
			dictMap.put(obj.getId(),(Dict)obj);
//			RedisUtils.remove(key);
			RedisUtils.saveMap(key,dictMap);
		}
	}

	@Override
	public void remove(String id) {
		Map<String,Dict> dictMap =  getMap();
		if (null != dictMap && null != dictMap.get(id) && dictMap.get(id) instanceof Dict){
			dictMap.remove(id);
//			RedisUtils.remove(key);
			RedisUtils.saveMap(key,dictMap);
		}
	}
	
	/**
	 * 新版申请表和旧版申请表同时运行，字典要分开使用
	 * 只有新旧版本与对应的字典value匹配上才返回true
	 * By 任志远 2016年9月19日
	 * 
	 * @param	Dict	字典实体
	 * @param	isNew	新版本为true, 旧版本为false
	 * 
	 * @return Boolean
	 */
	private Boolean matchingDict(Dict dict, boolean isNew){
		
		switch (dict.getType()) {
			//借款用途
			case "jk_loan_use":
				if(isNew && Integer.parseInt(dict.getValue()) > 2){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 3){
					return true;
				}else{
					return false;
				}
			//住房性质	
			case "jk_house_nature":
				if(isNew && Integer.parseInt(dict.getValue()) > 3){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 8){
					return true;
				}else{
					return false;
				}
			//职务	
			case "jk_job_type":
				if(isNew && ("0".equals(dict.getValue()) || "1".equals(dict.getValue()) || "4".equals(dict.getValue()) || "5".equals(dict.getValue()))){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 4){
					return true;
				}else{
					return false;
				}
			//行业类型
			case "jk_industry_type":
				if(isNew && !"8".equals(dict.getValue()) && (Integer.parseInt(dict.getValue()) < 11 || Integer.parseInt(dict.getValue()) > 14)){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 15){
					return true;
				}else{
					return false;
				}
			//单位类型
			case "jk_unit_type":
				if(isNew && !"3".equals(dict.getValue())){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 7){
					return true;
				}else{
					return false;
				}
			//规划用途,设计用途
			case "jk_design_use":
				if(isNew && Integer.parseInt(dict.getValue()) > 4){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 6){
					return true;
				}else{
					return false;
				}
			//房屋共有情况
			case "jk_house_common_type":
				if(isNew && ("0".equals(dict.getValue()) || "4".equals(dict.getValue()) || "5".equals(dict.getValue()))){
					return true;
				}else if(!isNew && ("0".equals(dict.getValue()) || "1".equals(dict.getValue()) || "2".equals(dict.getValue()) || "3".equals(dict.getValue()))){
					return true;
				}else{
					return false;
				}
				//学历
			case "jk_degree":
				if(isNew && Integer.parseInt(dict.getValue()) < 4){
					return true;
				}else if(!isNew){
					return true;
				}else{
					return false;
				}
			//联系人 亲属	
			case "jk_loan_family_relation":
				if(isNew && !"3".equals(dict.getValue())){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 4){
					return true;
				}else{
					return false;
				}
			//联系人 工作证明人
			case "jk_loan_workmate_relation":
				if(isNew && Integer.parseInt(dict.getValue()) > 1){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 3){
					return true;
				}else{
					return false;
				}
			//联系人 其他	
			case "jk_loan_other_relation":
				if(isNew && "3".equals(dict.getValue())){
					return true;
				}else if(!isNew && Integer.parseInt(dict.getValue()) < 3){
					return true;
				}else{
					return false;
				}
			//股东关系
			case "jk_shareholder_re":
				if(isNew){
					return true;
				}else if(!isNew && !"03".equals(dict.getValue()) ){
					return true;
				}else{
					return false;
				}	
			default:
				return true;
		}
	}
}
