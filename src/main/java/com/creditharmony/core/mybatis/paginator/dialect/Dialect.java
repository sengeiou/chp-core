package com.creditharmony.core.mybatis.paginator.dialect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.SimpleTypeRegistry;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.creditharmony.core.common.type.BooleanType;
import com.creditharmony.core.mybatis.paginator.domain.Order;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.BaseEntity;

/**
 * 类似hibernate的Dialect 只精简出分页部分
 * 
 * @Class Name Dialect
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class Dialect {
	protected TypeHandlerRegistry typeHandlerRegistry;
	protected MappedStatement mappedStatement;
	protected PageBounds pageBounds;
	protected Object parameterObject;
	protected BoundSql boundSql;
	protected List<ParameterMapping> parameterMappings;
	protected Map<String, Object> pageParameters = new HashMap<String, Object>();

	private String pageSQL;
	private String countSQL;

	public Dialect(MappedStatement mappedStatement, Object parameterObject,
			PageBounds pageBounds) {
		this.mappedStatement = mappedStatement;
		this.parameterObject = parameterObject;
		this.pageBounds = pageBounds;
		this.typeHandlerRegistry = mappedStatement.getConfiguration()
				.getTypeHandlerRegistry();

		init();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void init() {
		boundSql = mappedStatement.getBoundSql(parameterObject);
		parameterMappings = new ArrayList(boundSql.getParameterMappings());
		if (parameterObject instanceof Map) {
			pageParameters.putAll((Map) parameterObject);
		} else if (parameterObject != null) {
			Class cls = parameterObject.getClass();
			pageParameters.put("DEL_FLAG_NORMAL",BaseEntity.DEL_FLAG_NORMAL);
			if (cls.isPrimitive() || cls.isArray()
					|| SimpleTypeRegistry.isSimpleType(cls)
					|| Enum.class.isAssignableFrom(cls)
					|| Collection.class.isAssignableFrom(cls)) {
				for (ParameterMapping parameterMapping : parameterMappings) {
					pageParameters.put(parameterMapping.getProperty(),
							parameterObject);
				}
			} else {
				Map<Object, Object> params = new org.apache.commons.beanutils.BeanMap(parameterObject);
				for (Object key : params.keySet()) {
					   pageParameters.put(key.toString(),params.get(key));
				}
//				MetaObject metaObject = mappedStatement.getConfiguration()
//						.newMetaObject(parameterObject);
//				ObjectWrapper wrapper = metaObject.getObjectWrapper();
//				for (ParameterMapping parameterMapping : parameterMappings) {
//					PropertyTokenizer prop = new PropertyTokenizer(
//							parameterMapping.getProperty());
//					pageParameters.put(parameterMapping.getProperty(),
//							wrapper.get(prop));
//				}
			}

		}

		StringBuffer bufferSql = new StringBuffer(boundSql.getSql().trim());
		if (bufferSql.lastIndexOf(";") == bufferSql.length() - 1) {
			bufferSql.deleteCharAt(bufferSql.length() - 1);
		}
		String sql = bufferSql.toString();
		pageSQL = sql;
		if (pageBounds.getOrders() != null && !pageBounds.getOrders().isEmpty()) {
			pageSQL = getSortString(sql, pageBounds.getOrders());
		}
		if (pageBounds.getOffset() != RowBounds.NO_ROW_OFFSET
				|| pageBounds.getLimit() != RowBounds.NO_ROW_LIMIT) {
			pageSQL = getLimitString(pageSQL, "__offset",
					pageBounds.getOffset(), "__limit", pageBounds.getLimit());
		}
		String countColumn = "";
		if(StringUtils.isEmpty(pageBounds.getCountBy())){
			countColumn = "id";
		}else{
			countColumn = pageBounds.getCountBy();
		}
		countSQL = getCountString(countColumn, sql, pageBounds.getFilterOrderBy());
	}

	public List<ParameterMapping> getParameterMappings() {
		return parameterMappings;
	}

	public Object getParameterObject() {
		return pageParameters;
	}

	public String getPageSQL() {
		return pageSQL;
	}

	@SuppressWarnings("rawtypes")
	protected void setPageParameter(String name, Object value, Class type) {
		ParameterMapping parameterMapping = new ParameterMapping.Builder(
				mappedStatement.getConfiguration(), name, type).build();
		parameterMappings.add(parameterMapping);
		pageParameters.put(name, value);
	}

	public String getCountSQL() {
		return countSQL;
	}

	/**
	 * 将sql变成分页sql语句
	 */
	protected String getLimitString(String sql, String offsetName, int offset,
			String limitName, int limit) {
		throw new UnsupportedOperationException("paged queries not supported");
	}

	/**
	 * 将sql转换为总记录数SQL
	 * @param countColumn count列名
	 * @param sql SQL语句
	 * @param isFilterOrderBy 是否过滤sql最后的order by片段
	 *        对于sql中子查询中有order by的情况，isFilterOrderBy应设置为false
	 * @return 总记录数的sql
	 */
	protected String getCountString(String countColumn, String sql, String filterOrderBy) {
//		return "select count(1) from (" + removeOrders(sql) + ") tmp_count";
		String isFilterOrderBy = "";
		if(StringUtils.isEmpty(filterOrderBy)){
			isFilterOrderBy = BooleanType.TRUE;
		}else{
			isFilterOrderBy = filterOrderBy;
		}
		if(BooleanType.TRUE.equals(isFilterOrderBy)){
			return "select count(" + countColumn + ") from (" + removeOrders(sql) + ") tmp_count";
		}else{
			return "select count(" + countColumn + ") from (" + sql + ") tmp_count";
		}
	}
	
	protected String removeOrders(String qlString) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(qlString);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 将sql转换为带排序的SQL
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 总记录数的sql
	 */
	protected String getSortString(String sql, List<Order> orders) {
		if (orders == null || orders.isEmpty()) {
			return sql;
		}
		StringBuffer buffer = new StringBuffer("select * from (").append(sql)
				.append(") temp_order order by ");
		for (Order order : orders) {
			if (order != null) {
				buffer.append(order.toString()).append(", ");
			}
		}
		buffer.delete(buffer.length() - 2, buffer.length());
		return buffer.toString();
	}
}