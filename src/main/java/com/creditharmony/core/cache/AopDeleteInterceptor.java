package com.creditharmony.core.cache;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.creditharmony.core.persistence.BaseEntity;

@Component
@Aspect
public class AopDeleteInterceptor {

	@SuppressWarnings("rawtypes")
	private ThreadLocal threadLocal = new ThreadLocal();

	@Pointcut("execution(public * com.creditharmony.core.*.service.*.delete(..))")
	public void anyMethod() {
	}

	@SuppressWarnings({"unchecked","rawtypes"})
	@After("anyMethod()")
	public void doAfter(JoinPoint point) {
		if (point.getArgs()[0] instanceof BaseEntity) {
			BaseEntity entity = (BaseEntity) point.getArgs()[0];
			if (null != entity){
				BaseCache baseCache = CacheManager.factory(entity.getClass()
						.getName());
				if (null != baseCache) {
					threadLocal.set(baseCache.get(entity.getId()));
					baseCache.remove(entity.getId());
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@AfterThrowing(pointcut = "anyMethod()", throwing = "e")
	// 定义异常通知（当所拦截的方法出现异常时）
	public void doAfterThrowing() {
		if (null != threadLocal && null != threadLocal.get() && threadLocal.get() instanceof BaseEntity) {
			BaseEntity entity = null==threadLocal.get()?null:(BaseEntity) threadLocal.get();
			if (null != entity && null != CacheManager.factory(entity.getClass().getName())) {
				BaseCache baseCache = CacheManager.factory(entity.getClass().getName());
				baseCache.save(entity);
			}
		}
		
	}

}
