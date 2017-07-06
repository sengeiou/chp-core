package com.creditharmony.core.mybatis.util;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.common.util.ObjectHelper;
import com.creditharmony.core.mybatis.sql.MyBatisSql;

/**
 * mybatis SQL工具类
 * 获取boundSql,然后拼接参数
 * @Class Name MyBatisSqlUtil
 * @author 张永生
 * @Create In 2016年4月14日
 */
public class MyBatisSqlUtil {

	
	public static MyBatisSql getMyBatisSql(String id, 
			Object paramObject,
			SqlSessionFactory sqlSessionFactory) throws SQLException {
		MyBatisSql ibatisSql = new MyBatisSql();
		MappedStatement ms = sqlSessionFactory.getConfiguration().getMappedStatement(id);
		Configuration configuration = sqlSessionFactory.getConfiguration();
		TypeHandlerRegistry typeHandlerRegistry = ms.getConfiguration().getTypeHandlerRegistry();
		BoundSql boundSql = ms.getBoundSql(paramObject);
		ibatisSql.setSql(boundSql.getSql());
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		if (parameterMappings != null) {
			Object[] parameterArray = new Object[parameterMappings.size()];
			ParameterMapping parameterMapping = null;
			Object value = null;
			MetaObject metaObject = paramObject == null ? null : configuration.newMetaObject(paramObject);
			String propertyName = null;
			for (int i = 0; i < parameterMappings.size(); i++) {
				parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
                    propertyName = parameterMapping.getProperty();
                    if (boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (paramObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry.hasTypeHandler(paramObject.getClass())) {
                        value = paramObject;
                    } else {
                        value = metaObject == null ? null : metaObject.getValue(propertyName);
                    }
					if (value instanceof java.lang.String) {
						parameterArray[i] = (String) "'" + value + "'";
					} else if(value instanceof java.util.Date){
						String targetValue = DateUtils.getFormateDate((Date)value);
						parameterArray[i] = "'" + targetValue + "'";;
						
					}else if(!ObjectHelper.isEmpty(value)){
						parameterArray[i] = value;
					}
				}
			}
			ibatisSql.setParameters(parameterArray);
		}
		return ibatisSql;
	}

}
