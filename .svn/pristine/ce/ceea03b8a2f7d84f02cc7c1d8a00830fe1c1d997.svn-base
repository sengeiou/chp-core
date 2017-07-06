package com.creditharmony.core.users.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cache.DictCache;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.type.DictTypeIndex;
import com.creditharmony.core.common.type.SelectOptionType;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.dict.entity.Dict;
import com.creditharmony.core.dict.service.DictManager;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.type.PartyType;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.core.web.BaseController;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 字典控制器
 * @Class Name DictController
 * @author 张永生
 * @Create In 2016年1月8日
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/dict")
public class DictController extends BaseController {

	@Autowired
	private DictManager dictManager;
	
	@ModelAttribute
	public Dict get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return dictManager.get(new Dict(id));
		}else{
			return new Dict();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = {"list", ""})
	public String list(Dict dict, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<String> typeList = dictManager.findTypeList();
		model.addAttribute("typeList", typeList);
		Map<String, Object> filter = new HashMap<String, Object>();
		filter = jsonMapper.convertValue(dict, Map.class);
		filter.put("deleteFlag", DeleteFlagType.NORMAL);
		if(SelectOptionType.STRING_DEFAULT_VALUE.equals(filter.get("syncType"))){
			filter.put("type", SelectOptionType.DEFAULT_NULL);
		}
        Page<Dict> page = dictManager.findDictByPage(new Page<Dict>(request, response), filter); 
        model.addAttribute("page", page);
		return "modules/sys/dictList";
	}

	@RequestMapping(value = "form")
	public String form(Dict dict, Model model) {
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}

	@RequestMapping(value = "save")//@Valid 
	public String save(Dict dict, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dict)){
			return form(dict, model);
		}
		dictManager.save(dict);
		RedisUtils.remove(dict.getClass().getName());
		addMessage(redirectAttributes, "保存字典'" + dict.getLabel() + "'成功");
		return "redirect:" + adminPath + "/sys/dict/?repage&type="+dict.getType();
	}
	
	@RequestMapping(value = "delete")
	public String delete(Dict dict, RedirectAttributes redirectAttributes) {
		dictManager.delete(dict);
		RedisUtils.remove(dict.getClass().getName());
		addMessage(redirectAttributes, "删除字典成功");
		return "redirect:" + adminPath + "/sys/dict/?repage&type="+dict.getType();
	}
	
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(
			@RequestParam(required = false) String type,
			HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
//		Dict dict = new Dict();
//		dict.setType(type);
//		List<Dict> list = dictManager.findList(dict);//2016-1-25 by何军 从缓存获取数据
		List<Dict> list = DictCache.getInstance().getListByType(type);
		for (int i=0; i<list.size(); i++){
			Dict e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentId());
			map.put("name", StringUtils.replace(e.getLabel(), " ", ""));
			mapList.add(map);
		}
		return mapList;
	}
	
	@ResponseBody
	@RequestMapping(value = "listData")
	public List<Dict> listData(@RequestParam(required=false) String type) {
//		Dict dict = new Dict();
//		dict.setType(type);
		return DictCache.getInstance().getListByType(type);
	}
	
	@ResponseBody
	@RequestMapping(value = "findList")
	public List<Dict> listData(Dict dict) {
		if(dict == null){
			return null;
		}else if(null != dict.getType()&&!"".equals(dict.getType())&&null != dict.getParentId()&&!"".equals(dict.getParentId())){
			return DictCache.getInstance().getListByPid(dict.getParentId(), dict.getType());
		}else if(null != dict.getType()&&!"".equals(dict.getType())){
			return DictCache.getInstance().getListByType(dict.getType());
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "treeDatas")
	public List<Map<String, Object>> treeDatas(
			@RequestParam(required = true) String extId,
			HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		String partType = "";
		if(null != UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO)){
			User userInfo = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
			if(userInfo.isFortuneAdmin()){
				partType = PartyType.CAIFU.value;
			}else if(userInfo.isApproveAdmin()){
				partType = PartyType.HUICHENG.value;
			}else if(userInfo.isLoanAdmin()){
				partType = PartyType.HUIJIN.value;
			}
		}
		List<Dict> list =  new ArrayList<Dict>();
		if(!"".equals(partType)){
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("type", DictTypeIndex.COM_PARTY_TYPE);
			params.put("value", partType);
			List<Dict> dictList = dictManager.findListByParams(params);
			if(dictList!=null && dictList.size()>0){
				list.addAll(dictList);
				list.addAll(DictCache.getInstance().getListByPid(dictList.get(0).getId(), DictTypeIndex.COM_ORG_TYPE));
			}
		}else{
			String[] typesStr = extId.split(",");
			for(String type:typesStr){
				list.addAll(DictCache.getInstance().getListByType(type));
			}
		}
		if(list.size()>0){
			for (int i=0; i<list.size(); i++){
				Dict e = list.get(i);
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", StringUtils.replace(e.getLabel(), " ", ""));
				mapList.add(map);
			}
		}
		return mapList;
	}

}
