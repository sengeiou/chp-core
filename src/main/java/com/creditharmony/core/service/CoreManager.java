package com.creditharmony.core.service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cache.BaseCache;
import com.creditharmony.core.cache.CacheManager;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.DataEntity;
import com.creditharmony.core.persistence.Page;

/**
 * 核心Manager
 * @Class Name CoreManager
 * @author 张永生
 * @Create In 2015年11月27日
 * @param <D>
 * @param <T>
 */
public abstract class CoreManager<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseManager {
	
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(T entity) {
		BaseCache baseCache = CacheManager.factory(entity.getClass().getName());
		if(null != baseCache){
			logger.info("调用缓存获取对象");
			return (T) baseCache.get(entity.getId());
		}
		return dao.get(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * 此方法已过期,分页请使用新的分页方式
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        PageList<T> pageList = (PageList<T>)dao.findList(entity, pageBounds);
        PageUtil.convertPage(pageList, page);
		return page;
	}

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		if (entity.getIsNewRecord()){
			entity.preInsert();
			dao.insert(entity);
		}else{
			entity.preUpdate();
			dao.update(entity);
		}
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}
	public Object setValue(Object o,Object oldO,Object newO) throws IllegalArgumentException, IllegalAccessException{
		Class<?> claO = oldO.getClass();  
		Class<?> claN = newO.getClass();  	    
		Field[] oInfo = o.getClass().getDeclaredFields();
		for(Field oInfoD:oInfo){
			claO = oldO.getClass();
			claN = newO.getClass();  
			oInfoD.setAccessible(true); 
			for(; claN != Object.class ; claN = claN.getSuperclass()) {
				Field[] newOInfo = claN.getDeclaredFields();
				for(Field newOInfoD:newOInfo){
					newOInfoD.setAccessible(true);
					if(oInfoD.getName().equals(newOInfoD.getName()+"New")){
						if(newOInfoD.get(newO)!=null&&StringUtils.isNotBlank((CharSequence) newOInfoD.get(newO).toString())){
							oInfoD.set(o,newOInfoD.get(newO));
						}
					}
				}
			}
			for(; claO != Object.class ; claO = claO.getSuperclass()) {
				Field[] oldOInfo = claO.getDeclaredFields();
				for(Field oldOInfoD:oldOInfo){
					oldOInfoD.setAccessible(true);  
					if(oInfoD.getName().equals(oldOInfoD.getName())){
						if(oldOInfoD.get(oldO)!=null&&StringUtils.isNotBlank((CharSequence) oldOInfoD.get(oldO).toString())){
							oInfoD.set(o,oldOInfoD.get(oldO));
						}
					}
				}
			}	
		}
		return o;	
	}
	
	
	public Object setValue1(Object o,Object oldO,Object newO) throws Exception{
		BeanInfo oInfo = Introspector.getBeanInfo(o.getClass());
		BeanInfo oldOInfo = Introspector.getBeanInfo(oldO.getClass());
		BeanInfo newOInfo = Introspector.getBeanInfo(newO.getClass());
		
		PropertyDescriptor[] oInfoDesc = oInfo.getPropertyDescriptors();
		PropertyDescriptor[] oldOInfoDesc = oldOInfo.getPropertyDescriptors();
		PropertyDescriptor[] newOInfoDesc = newOInfo.getPropertyDescriptors();
		for(PropertyDescriptor oInfoD:oInfoDesc){
			for(PropertyDescriptor newOInfoD:newOInfoDesc){
				if(oInfoD.getName().equals(newOInfoD.getName()+"New")){
					if(StringUtils.isNotBlank((CharSequence) newOInfoD.getReadMethod().invoke(newO))){
						Method mr = oInfoD.getWriteMethod();
						if (mr != null) {
							Object oParam = new Object[] {newOInfoD.getReadMethod().invoke(newO).toString()}; 
							System.out.println(oInfoD.getName()+"===="+newOInfoD.getReadMethod().invoke(newO)+"");
							mr.invoke(o, oParam);
						}
					}
				}
			}
			for(PropertyDescriptor oldOInfoD:oldOInfoDesc){
				if(oInfoD.getName().equals(oldOInfoD.getName())){
					if(StringUtils.isNotBlank((CharSequence)oldOInfoD.getReadMethod().invoke(oldO))){
						Method mr = oInfoD.getWriteMethod();
						if (mr != null) {
							Object oParam = new Object[] {oldOInfoD.getReadMethod().invoke(oldO).toString()}; 
							//System.out.println(oInfoD.getName()+"===="+oldOInfoD.getReadMethod().invoke(oldO)+"");
							//mr.invoke(o, oParam);
						}
					}
				}
			}
		}
		return o;	
	}
}
