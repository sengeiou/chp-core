package com.creditharmony.core.persistence.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 汇金使用的dao注解
 * @Class Name LoanBatisDao
 * @author 张永生
 * @Create In 2015年12月3日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface LoanBatisDao {
	
	String value() default "";

}