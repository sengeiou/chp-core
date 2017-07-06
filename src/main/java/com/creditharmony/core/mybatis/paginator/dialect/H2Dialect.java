package com.creditharmony.core.mybatis.paginator.dialect;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;

import org.apache.ibatis.mapping.MappedStatement;

/**
 * H2 database方言
 * @Class Name H2Dialect
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class H2Dialect extends Dialect {

	public H2Dialect(MappedStatement mappedStatement, Object parameterObject,
			PageBounds pageBounds) {
		super(mappedStatement, parameterObject, pageBounds);
	}

	protected String getLimitString(String sql, String offsetName, int offset,
			String limitName, int limit) {
		return new StringBuffer(sql.length() + 40)
				.append(sql)
				.append((offset > 0) ? " limit " + String.valueOf(limit)
						+ " offset " + String.valueOf(offset) : " limit "
						+ String.valueOf(limit)).toString();
	}

}