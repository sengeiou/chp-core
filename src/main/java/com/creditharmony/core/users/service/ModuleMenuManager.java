package com.creditharmony.core.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.constants.MenuConstants;
import com.creditharmony.core.users.dao.MenuDao;
import com.creditharmony.core.users.dao.ModuleMenuDao;
import com.creditharmony.core.users.entity.Menu;
import com.creditharmony.core.users.entity.ModuleMenu;

/**
 * 模块菜单Manager
 * @Class Name ModuleMenuManager
 * @author 张永生
 * @Create In 2015年11月3日
 */
@Service
public class ModuleMenuManager extends CoreManager<ModuleMenuDao, ModuleMenu> {
	
	@Autowired
	private MenuDao menuDao;
	
	public Page<ModuleMenu> findPage(Page<ModuleMenu> page, ModuleMenu moduleMenu) {
		return super.findPage(page, moduleMenu);
	}

	public ModuleMenu getModuleMenu(String id){
		return dao.get(id);
	}
	
	public List<ModuleMenu> findAll(){
		return dao.findAllList(new ModuleMenu());
	}
	
	public ModuleMenu findByModuleId(String moduleId){
		Map<String,String> params = new HashMap<String,String>();
		params.put("moduleId", moduleId);
		params.put("delFlag", DeleteFlagType.NORMAL);
		List<ModuleMenu> dataList = dao.findByModuleId(params);
		return ArrayHelper.isNotEmpty(dataList) ? dataList.get(0) : null;
	}
	
	@Transactional(readOnly = false)
	public void saveModule(ModuleMenu moduleMenu) {
		if(StringUtils.isEmpty(moduleMenu.getId())){
			moduleMenu.preInsert();
			dao.insert(moduleMenu);
			// 保存模块菜单时，需要初始化一条功能菜单，即每个系统菜单的根节点
			saveMenu(moduleMenu);
		}else{
			moduleMenu.preUpdate();
			dao.update(moduleMenu);
		}
	}

	@Transactional(readOnly = false)
	public void saveMenu(ModuleMenu moduleMenu) {
		Menu menu = new Menu();
		Menu parentMenu = new Menu();
		parentMenu.setId(MenuConstants.PARENT_ID);
		menu.preInsert();
		menu.setModuleMenu(moduleMenu);
		menu.setName(moduleMenu.getName());
		menu.setParent(parentMenu);
		menu.setParentIds(MenuConstants.ROOT_PARENT_IDS);
		menu.setSort(MenuConstants.ROOT_SORT);
		menu.setIsShow(MenuConstants.ROOT_IS_SHOW);
		menuDao.insert(menu);
	}
	
	@Transactional(readOnly = false)
	public void deleteModule(ModuleMenu moduleMenu) {
		super.delete(moduleMenu);
	}
	
	@Transactional(readOnly = false)
	public ModuleMenu getMenuByKey(String key) {
		Map<String,String> keyMap = new HashMap<String,String>();
		keyMap.put("menuKey", key);
		keyMap.put("delFlag", DeleteFlagType.NORMAL);
		return dao.getByParams(keyMap);
	}
	
}
