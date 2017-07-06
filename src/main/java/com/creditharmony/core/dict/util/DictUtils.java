package com.creditharmony.core.dict.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.creditharmony.core.cache.DictCache;
import com.creditharmony.core.dict.entity.Dict;
import com.creditharmony.core.mapper.JsonMapper;
import com.google.common.collect.Lists;

/**
 * 字典工具类
 * @Class Name DictUtils
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class DictUtils {
	
	
	public static String getDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}
	
	public static String getDictLabels(String values, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getDictLabel(value, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}
	
	/**
	 * 2016年1月11日
	 * By 李静辉
	 * @param values 需要获取相应的值对应的下拉选项  '1,2'  等 查询到对应type下 值为1,2的选项
	 * @param type
	 * @return
	 */
	public static List<Dict> getDictLists(String values, String type){
		List<Dict> dictList = getDictList(type);
		List<Dict> dictList1 = Lists.newArrayList();
		if ( dictList != null && StringUtils.isNotBlank(values)){
			for (String value : StringUtils.split(values, ",")){
				for (Dict dict : dictList) {
					if(value.equals(dict.getValue())) dictList1.add(dict);
				}
			}
		}
		return dictList1;
	}
	
	/**
	 * 根据type获取字典集合，涉及申请表需要的字典时，旧版使用这个方法
	 * By 任志远	2016年9月20号
	 * 
	 * @param type
	 * @return
	 */
	public static List<Dict> getDictList(String type){
		return DictCache.getInstance().getListByType(type);
	}
	
	/**
	 * 根据type获取字典集合 (涉及申请表需要的字典时，新版使用这个方法)
	 * By 任志远	2016年9月20号
	 * 
	 * @param type
	 * @return
	 */
	public static List<Dict> getNewDictList(String type){
		
		return DictCache.getInstance().getNewListByType(type);
	}
	
	/**
	 * 根据type获取字典集合, (涉及申请表需要的字典时，获取新旧版本所有字典)
	 * By 任志远	2016年9月20号
	 * 
	 * @param type
	 * @return
	 */
	public static List<Dict> getAllDictList(String type){
		return DictCache.getInstance().getAllListByType(type);
	}
	
	public static List<Dict> getDictList(String type, boolean emptyRowFlag){
		List<Dict> dl1 = getDictList(type);
		List<Dict> dl2 = new ArrayList<Dict>();
		if (emptyRowFlag) {
			dl2.add(new Dict("", "请选择"));
		}
		dl2.addAll(dl1);
		return dl2;
	}
	
	public static Map<String, String> getDictMap(String type, boolean emptyRowFlag){
		List<Dict> dl = getDictList(type, emptyRowFlag);
		Map<String, String> dm = new LinkedHashMap<String, String>();
		for (Dict dict : dl){
			dm.put(dict.getValue(), dict.getLabel());
		}
		return dm;
	}
	
	public static Dict getDict(String id, String type){
		List<Dict> dictList = getDictList(type);
		Dict item = new Dict(id);
		if (dictList.contains(item)) {
			   return dictList.get(dictList.indexOf(item));
		}else{
			return item;
		}
	}
	
	/**
	 * 返回字典列表（JSON）
	 * @param type
	 * @return
	 */
	public static String getDictListJson(String type){
		return JsonMapper.toJsonString(getDictList(type));
	}
	
	public static String getLabel(Map<String,Dict> dictMap, String type, String value){
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

	public static String getValue(Map<String,Dict> dictMap, String type, String label){
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
}
