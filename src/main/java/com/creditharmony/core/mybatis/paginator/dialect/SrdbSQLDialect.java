package com.creditharmony.core.mybatis.paginator.dialect;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;

import org.apache.ibatis.mapping.MappedStatement;

/**
 * 上容db方言
 * @Class Name SrdbSQLDialect
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class SrdbSQLDialect extends Dialect{

    public SrdbSQLDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
        super(mappedStatement, parameterObject, pageBounds);
    }

    protected String getLimitString(String sql, String offsetName,int offset, String limitName, int limit) {
        StringBuffer buffer = new StringBuffer( sql.length()+20 ).append(sql);
        if(offset > 0){
            buffer.append(" limit ? offset ?");
            setPageParameter(limitName, limit, Integer.class);
            setPageParameter(offsetName, offset, Integer.class);

        }else{
            buffer.append(" limit ?");
            setPageParameter(limitName, limit, Integer.class);
        }
		return buffer.toString();
	}
}
