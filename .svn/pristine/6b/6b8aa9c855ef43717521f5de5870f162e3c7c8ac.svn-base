package com.creditharmony.core.users.entity;

import com.creditharmony.core.persistence.DataEntity;

/**
 * 模块菜单实体
 * 用来定义每个子系统的菜单
 * @Class Name ModuleMenu
 * @author 张永生
 * @Create In 2015年11月4日
 */
public class ModuleMenu extends DataEntity<ModuleMenu> {

	private static final long serialVersionUID = 1332878094612037231L;

	private Module module;        //所属模块
	private String name;          //菜单名字，例如：出借系统菜单
	private String menuKey;       //菜单关键字，预留
	
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenuKey() {
		return menuKey;
	}
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuKey == null) ? 0 : menuKey.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleMenu other = (ModuleMenu) obj;
		if (menuKey == null) {
			if (other.menuKey != null)
				return false;
		} else if (!menuKey.equals(other.menuKey))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
