package com.creditharmony.core.users.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.common.service.SystemManager;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.type.ModuleMenuName;
import com.creditharmony.core.users.constants.MenuConstants;
import com.creditharmony.core.users.entity.Menu;
import com.creditharmony.core.users.entity.ModuleMenu;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.service.MenuManager;
import com.creditharmony.core.users.service.ModuleMenuManager;
import com.creditharmony.core.users.util.OperationHelper;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.core.users.view.MenuSearchView;
import com.creditharmony.core.web.BaseController;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 菜单Controller
 * @Class Name MenuController
 * @author 张永生
 * @Create In 2016年1月7日
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/menu")
public class MenuController extends BaseController {

	@Autowired
	private SystemManager systemManager;
	@Autowired
	private ModuleMenuManager moduleMenuManager;
	@Autowired
	private MenuManager menuManager;
	
	@ModelAttribute("menu")
	public Menu get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return systemManager.getMenu(id);
		}else{
			return new Menu();
		}
	}

	@RequestMapping(value = {"list", ""})
	public String list(Model model, MenuSearchView searchView) {
		List<Menu> list = Lists.newArrayList();
		String moduleMenuId = searchView.getModuleMenuId();
		List<ModuleMenu> moduleMenuListN = Lists.newArrayList();
		List<ModuleMenu> moduleMenuList = moduleMenuManager.findAll();
		String moduleMenuKey = "";
		if(null != UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO)){
			User userInfo = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
			if(userInfo.isFortuneAdmin()){
				moduleMenuKey = ModuleMenuName.MENU_FORTUNE.value;
			}else if(userInfo.isApproveAdmin()){
				moduleMenuKey = ModuleMenuName.MENU_APPROVE.value;
			}else if(userInfo.isLoanAdmin()){
				moduleMenuKey = ModuleMenuName.MENU_LOAN.value;
			}
		}
		for(ModuleMenu moduleMenu:moduleMenuList){
			if("".equals(moduleMenuKey) || moduleMenuKey.equals(moduleMenu.getMenuKey())){
				moduleMenuListN.add(moduleMenu);
			}
		}
		if(!StringUtils.isNotBlank(moduleMenuId)){
			if(ArrayHelper.isNotEmpty(moduleMenuList)){
				moduleMenuId = moduleMenuListN.get(0).getId();
			}
		}
		List<Menu> sourceList = menuManager.findAll(moduleMenuId);
		Menu rootMenu = null;
		if(ArrayHelper.isNotEmpty(sourceList)){
			rootMenu = menuManager.findMenu(moduleMenuId, MenuConstants.PARENT_ID);
		}
		Menu.sortList(list, sourceList, rootMenu != null ? rootMenu.getId()
				: Menu.getRootId(), true);
        model.addAttribute("list", list);
        model.addAttribute("rootMenu", rootMenu!=null ? rootMenu : new Menu(MenuConstants.DEFAULT_ROOT_ID));
        model.addAttribute("moduleMenuList", moduleMenuListN);
        model.addAttribute("searchView", searchView);
		return "modules/sys/menuList";
	}

	/**
	 * 编辑菜单：新增，修改，添加下一级菜单
	 * 2015年11月5日 By 张永生
	 * @param menu
	 * @param model
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "form")
	public String form(Menu menu, Model model) {
		List<ModuleMenu> moduleMenuList = moduleMenuManager.findAll();
		
		String menuKey = "";
		if(null != UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO)){
			User user = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
			if(user.isFortuneAdmin()){
				menuKey = ModuleMenuName.MENU_FORTUNE.value;
			}else if(user.isApproveAdmin()){
				menuKey = ModuleMenuName.MENU_APPROVE.value;
			}else if(user.isLoanAdmin()){
				menuKey = ModuleMenuName.MENU_LOAN.value;
			}
		}
		List<ModuleMenu> moduleMenuListN = Lists.newArrayList();
		for(ModuleMenu moduleMenu:moduleMenuList){
			if("".equals(menuKey) || menuKey.equals(moduleMenu.getMenuKey())){
				moduleMenuListN.add(moduleMenu);
			}
		}
		
//		if (menu.getParent()==null||menu.getParent().getId()==null){
//			if(ArrayHelper.isNotEmpty(moduleMenuList)){
//				ModuleMenu moduleMenu = moduleMenuList.get(0);
//				Menu rootMenu = menuManager.findMenu(moduleMenu.getId(), MenuConstants.ROOT_PARENT_ID);
//				menu.setParent(rootMenu);
//			}
//		}
		if (menu.getParent() != null && StringUtils.isNotEmpty(menu.getParent().getId())) {
			Menu parentMenu = menuManager.get(menu.getParent().getId());
			menu.setParent(parentMenu);
		}
//		menu.setParent(systemManager.getMenu(menu.getParent().getId()));
//		// 获取排序号，最末节点排序号+30
//		if (StringUtils.isBlank(menu.getId())){
//			List<Menu> list = Lists.newArrayList();
//			List<Menu> sourcelist = systemManager.findAllMenu();
//			Menu.sortList(list, sourcelist, menu.getParentId(), false);
//			if (list.size() > 0){
//				menu.setSort(list.get(list.size()-1).getSort() + 30);
//			}
//		}
		
		
		//menuForm.jsp根据flag来判断 所属模块菜单 字段 是否可以编辑
		model.addAttribute("disabled", OperationHelper.isModuleMenuDisabled(menu.getFlag())); 
		model.addAttribute("menu", menu);
		model.addAttribute("moduleMenuList", moduleMenuListN);
		return "modules/sys/menuForm";
	}
	
	@RequestMapping(value = "save")
	public String save(Menu menu, Model model, RedirectAttributes redirectAttributes) {
//		if(!UserUtils.getUser().isAdmin()){
//			addMessage(redirectAttributes, "越权操作，只有超级管理员才能添加或修改数据！");
//			return "redirect:" + adminPath + "/sys/role/?repage";
//		}
		if (!beanValidator(model, menu)){
			return form(menu, model);
		}
		systemManager.saveMenu(menu);
		ModuleMenu moduleMenu = moduleMenuManager.get(menu.getModuleMenu().getId());
		addMessage(redirectAttributes, "保存[" + moduleMenu.getName() + "]模块的菜单:'"
				+ menu.getName() + "'成功");
		return "redirect:" + adminPath + "/sys/menu/?moduleMenuId="+menu.getModuleMenu().getId();
	}
	
	@RequestMapping(value = "delete")
	public String delete(Menu menu, RedirectAttributes redirectAttributes) {
		systemManager.deleteMenu(menu);
		addMessage(redirectAttributes, "删除菜单成功");
		return "redirect:" + adminPath + "/sys/menu/";
	}

	@RequestMapping(value = "tree")
	public String tree() {
		return "modules/sys/menuTree";
	}

	@RequestMapping(value = "treeselect")
	public String treeselect(String parentId, Model model) {
		model.addAttribute("parentId", parentId);
		return "modules/sys/menuTreeselect";
	}
	
	/**
	 * 批量修改菜单排序
	 */
	@RequestMapping(value = "updateSort")
	public String updateSort(String[] ids, Integer[] sorts, RedirectAttributes redirectAttributes) {
    	for (int i = 0; i < ids.length; i++) {
    		Menu menu = new Menu(ids[i]);
    		menu.setSort(sorts[i]);
    		systemManager.updateMenuSort(menu);
    	}
    	addMessage(redirectAttributes, "保存菜单排序成功");
		return "redirect:" + adminPath + "/sys/menu/";
	}
	
	/**
	 * isShowHide是否显示隐藏菜单
	 * @param extId
	 * @param isShowHidden
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(
			@RequestParam(required = false) String extId,
			@RequestParam(required = false) String isShowHide,
			@RequestParam(required = false) String mmId,
			HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Menu> list = menuManager.findAll(mmId);
		for (int i=0; i<list.size(); i++){
			Menu e = list.get(i);
			if (StringUtils.isBlank(extId)
					|| (extId != null && !extId.equals(e.getId()) && e
							.getParentIds().indexOf("," + extId + ",") == -1)) {
				if (isShowHide != null && isShowHide.equals("0")
						&& e.getIsShow().equals("0")) {
					continue;
				}
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
}
