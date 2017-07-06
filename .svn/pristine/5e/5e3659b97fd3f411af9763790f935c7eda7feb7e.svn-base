package com.creditharmony.core.mybatis.paginator.dialect;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;

import org.apache.ibatis.mapping.MappedStatement;

/**
 * HSQLDB 方言
 * @Class Name HSQLDialect
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class HSQLDialect extends Dialect {

	public HSQLDialect(MappedStatement mappedStatement, Object parameterObject,
			PageBounds pageBounds) {
		super(mappedStatement, parameterObject, pageBounds);
	}

	protected String getLimitString(String sql, String offsetName, int offset,
			String limitName, int limit) {
		boolean hasOffset = offset > 0;
		return new StringBuffer(sql.length() + 10)
				.append(sql)
				.insert(sql.toLowerCase().indexOf("select") + 6, hasOffset ? " limit " + String.valueOf(offset) + " "
								+ String.valueOf(limit) : " top "
								+ String.valueOf(limit)).toString();
	}

}
