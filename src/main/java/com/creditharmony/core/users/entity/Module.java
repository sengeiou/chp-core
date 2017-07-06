package com.creditharmony.core.users.entity;

import com.creditharmony.core.persistence.DataEntity;

/**
 * 模块实体
 * 模块即代表系统
 * 用于定义全局的系统：汇金、财富、报表、系统管理子系统等。
 * @Class Name SystemInfo
 * @author 张永生
 * @Create In 2015年11月3日
 */
public class Module extends DataEntity<Module> {

	private static final long serialVersionUID = -472224752526823048L;
	private String name;
	private String shortName;       //模块简称
	private String moduleKey;
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModuleKey() {
		return moduleKey;
	}
	public void setModuleKey(String moduleKey) {
		this.moduleKey = moduleKey;
	}
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public Module() {
		super();
	}
	
	public Module(String id) {
		super(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((moduleKey == null) ? 0 : moduleKey.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((shortName == null) ? 0 : shortName.hashCode());
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
		Module other = (Module) obj;
		if (moduleKey == null) {
			if (other.moduleKey != null)
				return false;
		} else if (!moduleKey.equals(other.moduleKey))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (shortName == null) {
			if (other.shortName != null)
				return false;
		} else if (!shortName.equals(other.shortName))
			return false;
		return true;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
