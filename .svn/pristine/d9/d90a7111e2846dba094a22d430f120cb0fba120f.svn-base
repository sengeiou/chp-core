package com.creditharmony.core.users.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cache.OrgCache;
import com.creditharmony.core.common.type.BooleanType;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.type.DictTypeIndex;
import com.creditharmony.core.common.type.DomainType;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.dict.entity.Dict;
import com.creditharmony.core.dict.service.DictManager;
import com.creditharmony.core.dict.util.DictUtils;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.role.type.BaseRole;
import com.creditharmony.core.single.SingleType;
import com.creditharmony.core.users.constants.OrgConstants;
import com.creditharmony.core.users.entity.Area;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.ProvinceCity;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.entity.UserRoleOrg;
import com.creditharmony.core.users.service.OrgManager;
import com.creditharmony.core.users.service.ProvinceCityManager;
import com.creditharmony.core.users.service.UserManager;
import com.creditharmony.core.users.service.UserRoleOrgManager;
import com.creditharmony.core.users.type.BaseDeptOrgType;
import com.creditharmony.core.users.type.OrgType;
import com.creditharmony.core.users.util.AdminUserUtil;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.core.web.BaseController;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


/**
 * 组织机构控制器
 * @Class Name OrgController
 * @author 张永生
 * @Create In 2015年12月16日
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/org")
public class OrgController extends BaseController {
	
	@Autowired
	private OrgManager orgManager;
	@Autowired
	private ProvinceCityManager provinceCityManager;
	@Autowired
	private UserManager userManager;
	@Autowired
	private DictManager dictManager;
	@Autowired
	private UserRoleOrgManager userRoleOrgManager;
	
	@RequestMapping(value = {""})
	public String index(Model model) {
		model.addAttribute("org", new Org());
		return "modules/sys/orgIndex";
	}

	@RequestMapping(value = {"list"})
	public String list(Org org,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String hasInclude = request.getParameter("hasInclude");
		String orgExtId = "";
		if(null != UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO)){
			User user = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
			String adminUserFlag = userRoleOrgManager.getAdminUserFlag(user);
			if(AdminUserUtil.isFortuneAdmin(user, adminUserFlag)){
				orgExtId = OrgConstants.ORG_ROOT_ID + "," + OrgConstants.ORG_FORTUNE_ROOT+",";
			} else if(AdminUserUtil.isApproveAdmin(user, adminUserFlag)){
				orgExtId = OrgConstants.ORG_ROOT_ID + "," + OrgConstants.ORG_APPROVE_ROOT+",";
			} else if(AdminUserUtil.isLoanAdmin(user, adminUserFlag)){
				orgExtId = OrgConstants.ORG_ROOT_ID + "," + OrgConstants.ORG_LOAN_ROOT+",";
			} else if(AdminUserUtil.isLoanerDeptAdmin(adminUserFlag)){
				orgExtId = OrgConstants.ORG_ROOT_ID + "," + OrgConstants.LOANER_DEPT_ROOT+",";
			} else if(AdminUserUtil.isLenderDeptAdmin(adminUserFlag)){
				orgExtId = OrgConstants.ORG_ROOT_ID + "," + OrgConstants.LENDER_DEPT_ROOT + ",";
			} else if(AdminUserUtil.isHuiMinBizDeptAdmin(adminUserFlag)){
				orgExtId = OrgConstants.ORG_ROOT_ID + "," + OrgConstants.HUIMIN_BIZ_DEPT_ROOT + ",";
			}
		}
		String parantIds = "on".equals(hasInclude)?"-1,"+orgExtId+"%":"-1,"+orgExtId;
		if(StringUtils.isNotEmpty(org.getId())){
			parantIds = "on".equals(hasInclude)?org.getParentIds()+org.getId()+",%":org.getParentIds()+org.getId()+",";
		}
		if(StringUtils.isNotEmpty(request.getParameter("orgParentIds"))){
			parantIds = request.getParameter("orgParentIds");
		}
		org.setParentIds(parantIds);
		Page<Org> page = orgManager.findListPage(new Page<Org>(request, response), org);
        model.addAttribute("page", page);
		return "modules/sys/orgList";
	}
	
	@RequestMapping(value = "form")
	public String form(Org org, Model model) {
		if (StringUtils.isNotBlank(org.getId())){
			org = orgManager.get(new Org(org.getId()));
			org.setFrozenUser(StringUtils.isEmpty(org.getFrozenUser())?Global.NO:org.getFrozenUser());
		}else{
			Org parent = org.getParent();
			if(parent!=null){
				parent = orgManager.get(new Org(parent.getId()));
			}
			org = new Org();
			org.setParent(parent);
			org.setFrozenUser(Global.NO);
		}
		setOrgCode(org);
		model.addAttribute("org", org);
		List<ProvinceCity> provinceList = provinceCityManager.findProvince();
		model.addAttribute("provinceList", provinceList);
		if(org!=null && StringUtils.isNotEmpty(org.getProvinceId())){
			List<ProvinceCity> cityList = provinceCityManager.findCity(org.getProvinceId());
			model.addAttribute("cityList", cityList);
		}
		if(org!=null && StringUtils.isNotEmpty(org.getCityId())){
			List<ProvinceCity> districtList = provinceCityManager.findDistrict(org.getCityId());
			model.addAttribute("districtList", districtList);
		}
		setPartyType(model);
		setOrgType(org, model);
		List<Dict> yesNoList = DictUtils.getDictList(DictTypeIndex.YES_NO);
		model.addAttribute("yesNoList", yesNoList);
		return "modules/sys/orgForm";
	}

	private void setOrgType(Org org, Model model) {
		if(StringUtils.isNotEmpty(org.getPartyType())){
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("deleteFlag", DeleteFlagType.NORMAL);
			params.put("type", DictTypeIndex.COM_PARTY_TYPE);
			params.put("value", org.getPartyType());
			Dict dict = dictManager.getByParams(params);
			Map<String, Object> filter = new HashMap<String, Object>();
			filter.put("deleteFlag", DeleteFlagType.NORMAL);
			filter.put("type", DictTypeIndex.COM_ORG_TYPE);
			filter.put("parentId", dict!=null ? dict.getId() : null);
			model.addAttribute("typeList", dictManager.findListByParams(filter));
		}
	}

	private void setPartyType(Model model) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		params.put("type", DictTypeIndex.COM_PARTY_TYPE);
		model.addAttribute("partyTypeList", dictManager.findListByParams(params));
	}

	@SuppressWarnings("unused")
	private boolean checkParentIsNull(Org org) {
		return org.getParent()==null || org.getParent().getId()==null;
	}

	@RequestMapping(value = "save")
	public String save(Org org, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, org)){
			return form(org, model);
		}
		String name = org.getName();
		orgManager.save(org);
		addMessage(redirectAttributes, "保存机构'" + name + "'成功");
		return "redirect:" + adminPath + "/sys/org/form?id="+org.getId();
	}
	
	@RequestMapping(value = "delete")
	public String delete(Org org, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		org = orgManager.get(new Org(org.getId()));
		String parentId = org.getParentId();
		orgManager.delete(org);
		addMessage(redirectAttributes, "删除机构成功");
		return "redirect:" + adminPath + "/sys/org/form?id="+parentId;
	}

	/**
	 * 获取机构JSON数据。
	 * @param extId 排除的ID
	 * @param type	类型（1：公司；2：部门/小组/其它：3：用户）
	 * @param grade 显示级别
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(
		@RequestParam(required = false) String extId,
		@RequestParam(required = false) String type,
		@RequestParam(required = false) Long grade,
		@RequestParam(required = false) Boolean isAll,
		HttpServletResponse response
	) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Org> list = OrgCache.getInstance().getList();//2016-1-25 by何军 从缓存获取数据
		if(null != UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO)){
			User user = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
			String adminUserFlag = userRoleOrgManager.getAdminUserFlag(user);
			if (AdminUserUtil.isFortuneAdmin(user, adminUserFlag)) {
				extId = OrgConstants.ORG_FORTUNE_ROOT;
			} else if (AdminUserUtil.isApproveAdmin(user, adminUserFlag)) {
				extId = OrgConstants.ORG_APPROVE_ROOT;
			} else if (AdminUserUtil.isLoanAdmin(user, adminUserFlag)) {
				extId = OrgConstants.ORG_LOAN_ROOT;
			} else if (AdminUserUtil.isLoanerDeptAdmin(adminUserFlag)) {
				extId = OrgConstants.LOANER_DEPT_ROOT;
			} else if (AdminUserUtil.isLenderDeptAdmin(adminUserFlag)) {
				extId = OrgConstants.LENDER_DEPT_ROOT;
			} else if (AdminUserUtil.isHuiMinBizDeptAdmin(adminUserFlag)) {
				extId = OrgConstants.HUIMIN_BIZ_DEPT_ROOT;
			} else if (AdminUserUtil.isDianXiaoZhongXinDeptAdmin(adminUserFlag)) {
				extId = OrgConstants.DIAN_XIAO_DEPT_ROOT;
			}
		}
		//List<Org> list = orgManager.findList(isAll);
		Collections.sort(list);  
		for (int i = 0; i < list.size(); i++) {
			Org e = list.get(i);
			if (
				(StringUtils.isBlank(extId) || 
				(
					extId != null && 
					(extId.equals(e.getId()) || 
					e.getParentIds().indexOf("," + extId + ",") > -1))
				) && 
				(
					type == null || 
					(type != null && (OrgType.COMPANY.value.equals(type) ? type.equals(e.getType()) : true)))
					&& (grade == null || (grade != null && Integer.parseInt(e.getGrade()) <= grade.intValue()))
//					&& Global.YES.equals(e.getUseable())
			) {
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("pIds", e.getParentIds());
				map.put("type", e.getType());
				map.put("name", e.getName());
				if (type != null && OrgType.DEPARTMENT.value.equals(type)){
					map.put("isParent", true);
				}
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	/**
	 * 获取当前用户机构及下属机构(tree)
	 * @param orgType
	 * @return List<Map<String, Object>>
	 */
	@ResponseBody
	@RequestMapping(value = "treeUserSubOrg")
	public List<Map<String, Object>> treeUserSubOrg(
		@RequestParam(required = false) String orgType
	) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		User user = UserUtils.getUser();
		List<UserRoleOrg> lsUserOrg = userManager.selUserOrg(user.getId());
		for (int j = 0; j < lsUserOrg.size(); j++) {
			String orgId = lsUserOrg.get(j).getOrgId();
			List<Org> ls = orgManager.selUserSubOrg(orgId, orgType);
			for (int i = 0; i < ls.size(); i++) {
				Org rec = ls.get(i);
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", rec.getId());
				map.put("pId", rec.getParent().getId());
				map.put("pIds", rec.getParentIds());
				map.put("name", rec.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
			
	
	/**
	 * 异步加载城市
	 * 2015年12月10日
	 * By 张永生
	 * @param provinceId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "asynLoadCity", method = RequestMethod.POST)
	public String asynLoadCity(String provinceId) {
		List<ProvinceCity> cityList = provinceCityManager.findCity(provinceId);
		return jsonMapper.toJson(cityList);
	}
	
	/**
	 * 异步加载区县
	 * 2015年12月10日
	 * By 张永生
	 * @param cityId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "asynLoadDistrict", method = RequestMethod.POST)
	public String asynLoadDistrict(String cityId) {
		List<ProvinceCity> districtList = provinceCityManager.findDistrict(cityId);
		return jsonMapper.toJson(districtList);
	}
	
	/**
	 * 设置组织机构编码
	 * 2015年12月16日
	 * By 张永生
	 * @param org
	 */
	private void setOrgCode(Org org) {
		if (StringUtils.isBlank(org.getId()) && org.getParent() != null) {
			int size = 0;
			List<Org> list = orgManager.findAll();
			for (int i=0; i<list.size(); i++){
				Org e = list.get(i);
				if (e.getParent()!=null && e.getParent().getId()!=null
						&& e.getParent().getId().equals(org.getParent().getId())){
					size++;
				}
			}
			org.setCode(org.getParent().getCode()
					+ StringUtils.leftPad(
							String.valueOf(size > 0 ? size + 1 : 1), 3, "0"));
		}
	}
	
	/**
	 * 验证页面输入的机构编码是否可用
	 * true: 有效，数据库中不存在相同code的组织机构
	 * false:无效，数据库中已存在相同code的组织机构
	 * @param oldCode
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "asynCheckCode")
	public String asynCheckCode(String oldCode, String code) {
		if (code!=null && code.equals(oldCode)) {
			return BooleanType.TRUE;
		} else if (code!=null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("code", code);
			List<Org> orgList = orgManager.findByCode(params);
			if (ArrayHelper.isNotEmpty(orgList) && orgList.size() > 0) {
				return BooleanType.FALSE;
			} else {
				return BooleanType.TRUE;
			}
		}
		return BooleanType.FALSE;
	}
	
	/**
	 * 验证页面输入的机构名称是否可用
	 * true: 有效，数据库中不存在相同name的组织机构
	 * false:无效，数据库中已存在相同name的组织机构
	 * @param oldName
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "asynCheckName")
	public String asynCheckName(String oldName, String name) {
		if (name!=null && name.equals(oldName)) {
			return BooleanType.TRUE;
		} else if (name!=null) {
			Org orgN = new Org();
			orgN.setDelFlag(Org.DEL_FLAG_NORMAL);
			orgN.setName(name);
			List<Org> list = orgManager.selOrg(orgN);
			if(null!=list && list.size()>0){
				return BooleanType.FALSE;
			}else{
				return BooleanType.TRUE;
			}
		}
		return BooleanType.FALSE;
	}
	
	/**
	 * 验证页面输入的机构名称是否可用
	 * true: 有效，数据库中不存在相同name的组织机构
	 * false:无效，数据库中已存在相同name的组织机构
	 * @param oldName
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "asynCheckType")
	public String asynCheckType(String oldType,String type,String orgId) {
		if (type!=null && type.equals(oldType)) {
			return BooleanType.TRUE;
		} else if (type!=null) {
			Org org = orgManager.get(new Org(orgId));
			if("".equals(orgId) || null==org){
				return BooleanType.TRUE;
			}
			org.setName(null);
			org.setCode(null);
			List<Org> list = orgManager.findList(org);
			if(null!=list && list.size()>0){
				return BooleanType.FALSE;
			}else{
				return BooleanType.TRUE;
			}
		}
		return BooleanType.FALSE;
	}
	@ResponseBody
	@RequestMapping(value = "asynCheckSon")
	public String asynCheckSon(String orgId) {
		Org org = orgManager.get(new Org(orgId));
		if("".equals(orgId) || null==org){
			return BooleanType.TRUE;
		}
		org.setName(null);
		org.setCode(null);
		List<Org> list = orgManager.findList(org);
		if(null!=list && list.size()>0){
			return BooleanType.FALSE;
		}else{
			return BooleanType.TRUE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "asynLoadOrgType", method = RequestMethod.POST)
	public String asynLoadOrgType(String partyType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		params.put("type", DictTypeIndex.COM_PARTY_TYPE);
		params.put("value", partyType);
		Dict dict = dictManager.getByParams(params);
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("deleteFlag", DeleteFlagType.NORMAL);
		filter.put("type", DictTypeIndex.COM_ORG_TYPE);
		filter.put("parentId", dict.getId());
		List<Dict> list = dictManager.findListByParams(filter);
		return jsonMapper.toJson(list);
	}
	
	@RequestMapping(value = "selectOrgList")
	public String selectStorePage(Org org, HttpServletRequest request,
			HttpServletResponse response, String isSingle, Model model) {
		if (null == org.getArea()) {
			Area area = new Area();
			org.setArea(area);
		}
		String orgName = org.getName();
		if(null !=org.getName() && org.getName().indexOf(",") >-1){
			String[] names = org.getName().split(",");
			List<Org> orgList = Lists.newArrayList();
			for(String name:names){
				Org orgN = new Org();
				orgN.setName(name);
				orgList.add(orgN);
			}
			org.setChildren(orgList);
			org.setName(null);
		}
		Page<Org> orgs = orgManager.findStoresPage(new Page<Org>(request,
				response), org);
		org.setName(orgName);
		model.addAttribute("page", orgs);
		model.addAttribute("storesSelected", org.getStoresSelected());

		model.addAttribute("queryURL", "selectOrgList");
		if ("1".equals(isSingle)) {
			return "modules/single/storesSingleList";
		}
		return "modules/single/storesList";
	}
	
	/**
	 * 选择当前合同审核组未被分派分派给组的门店
	 * 2016年2月18日
	 * By 陈伟东
	 * @param org 检索条件，含门店名称、区域名称
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "findStoresNotAssigned/{singleType}")
	public String findStoresNotAssigned(Org org, HttpServletRequest request,
			HttpServletResponse response, Model model,
			@PathVariable("singleType") String singleType) {
		if(null==org.getArea()){
			Area area = new Area();
			org.setArea(area);
		}
		String domainType = "";
		if(SingleType.CONTRACT_STORE_CONFIG.equals(singleType)){
			domainType = DomainType.CONTRACT_APPROVE_GROUP;
		}else{
			domainType = DomainType.RATE_APPROVE_GROUP;
		}
		org.setSourceType(domainType);
				
		Page<Org> orgs = orgManager.findStoresNotAssigned(new Page<Org>(request, response),org);
		model.addAttribute("page", orgs);
		model.addAttribute("storesSelected", org.getStoresSelected());
		model.addAttribute("queryURL", "findStoresNotAssigned");
		model.addAttribute("singleType", singleType);
		return "modules/single/storesList";
	}
	
	/**
	 * 选择当前合同审核组未被分派分派给组员的门店
	 * 2016年1月14日
	 * By 陈伟东
	 * @param org 检索条件，含门店名称、区域名称
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "findContractGroupStoresNotAssigned/{singleType}")
	public String findContractGroupStoresNotAssigned(Org org,
			HttpServletRequest request, HttpServletResponse response,
			Model model, @PathVariable("singleType") String singleType) {
	   	User userInfo = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		if(null==org.getArea()){
			Area area = new Area();
			org.setArea(area);
		}
		
		String domainType = "";
		String orgType = "";
		String roleType = "";
		if(SingleType.CONTRACT_STORE_CONFIG.equals(singleType)){
			domainType = DomainType.CONTRACT_APPROVE_MEMBER;
			orgType = BaseDeptOrgType.CONTRACT_APPROVE_TEAM.key;
			roleType = BaseRole.CONTRACT_APPROVE_LEADER_ROLE_TYPE.id;
		}else{
			domainType = DomainType.RATE_APPROVE_MEMBER;
			orgType = BaseDeptOrgType.CONTRACT_RATEAPPROVE_TEAM.key;
			roleType = BaseRole.RATE_APPROVE_LEADER_ROLE_TYPE.id;
		}
		org.setSourceType(domainType);
		
		Page<Org> orgs = orgManager.findContractGroupStoresNotAssigned(new Page<Org>(request, response),userInfo,org,orgType,roleType);
		model.addAttribute("page", orgs);
		model.addAttribute("queryURL", "findContractGroupStoresNotAssigned");
		model.addAttribute("singleType", singleType);
		return "modules/single/storesList";
	}

}
