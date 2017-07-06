package com.creditharmony.core.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 报表使用的dao注解
 * 注:连接报表数据库时使用
 * @Class Name ReportBatisDao
 * @author 张永生
 * @Create In 2015年12月11日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface ReportBatisDao {
	
	String value() default "";

}