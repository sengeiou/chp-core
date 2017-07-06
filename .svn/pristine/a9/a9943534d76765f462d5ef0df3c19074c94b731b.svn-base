package com.creditharmony.core.persistence;

import java.util.List;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;

/**
 * DAO支持类实现
 * @author ThinkGem
 * @version 2014-05-16
 * @param <T>
 */
public interface TreeDao<T extends TreeEntity<T>> extends CrudDao<T> {

	/**
	 * 找到所有子节点
	 * @param entity
	 * @return
	 */
	public List<T> findByParentIdsLike(T entity);
	
	/**
	 * 找到所有子节点（分页）
	 * @param entity
	 * @param pageBounds
	 * @return
	 */
	public List<T> findByParentIdsLike(T entity,PageBounds pageBounds);

	/**
	 * 更新所有父节点字段
	 * @param entity
	 * @return
	 */
	public int updateParentIds(T entity);
	
}