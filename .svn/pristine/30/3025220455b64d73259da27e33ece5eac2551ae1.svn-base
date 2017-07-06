package com.creditharmony.core.permission.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creditharmony.core.permission.entity.AdditionalPermission;
import com.creditharmony.core.permission.entity.ex.AdditionalPermissionEx;
import com.creditharmony.core.permission.service.AdditionalPermissionCacheService;
import com.creditharmony.core.permission.service.AdditionalPermissionManager;
import com.creditharmony.core.web.BaseController;

/**
 * 额外权限控制
 * 
 * @author chenwd
 */
@Controller
@RequestMapping(value = "${adminPath}/additonalPermission")
public class AdditionalPermissionController extends BaseController {

	@Autowired
	AdditionalPermissionManager additionalPermissionManager;
	@Autowired
	AdditionalPermissionCacheService cacheService;

	/**
	 * 显示所有例外权限
	 * @param model
	 * @param orgId
	 * @param orgName
	 * @return
	 */
	@RequestMapping(value = "/showAdditionalPermissionListPage")
	public String showAdditionalPermissionListPage(Model model,
			String orgId,
			String orgName) {
		AdditionalPermission ap = new AdditionalPermission();
		ap.setId(orgId);
		List<AdditionalPermissionEx> list = additionalPermissionManager
				.list(ap);
		model.addAttribute("list", list);
		return "modules/permission/additionalPermissionList";
	}

	@RequestMapping(value = "/showOrgTree")
	public String showOrgTree() {
		return "modules/permission/orgTree";
	}

	/**
	 * 重置所有例外权限的缓存
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/reset")
	public String reset() {
		cacheService.addAllAdditionalPermissionOrdId();
		return "s";
	}
	
	/**
	 * 添加例外
	 * @param orgId
	 * @return
	 */
	@RequestMapping(value = "/setForbiddenOrg")
	public String setForbiddenOrg(String orgId) {
		AdditionalPermission additionalPermission = additionalPermissionManager
				.get(orgId);
		if (additionalPermission != null) {
			return "repeat";
		}
		additionalPermissionManager.addAdditionalPermissionContainSubOrg(orgId);
		return "s";
	}

	/**
	 * 删除例外权限
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(String id) {
		AdditionalPermission ap = new AdditionalPermission();
		ap.setId(id);
		additionalPermissionManager.deleteAdditionalPermission(ap);
		return "s";
	}
}
