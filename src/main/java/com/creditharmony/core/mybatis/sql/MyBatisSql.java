package com.creditharmony.core.mybatis.sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.creditharmony.common.util.ObjectHelper;

/**
 * 自定义的mybatis sql类
 * @Class Name MyBatisSql
 * @author 张永生
 * @Create In 2016年4月14日
 */
public class MyBatisSql {

    private String sql;  
    
    private Object[] parameters;  
    
    public void setSql(String sql) {    
        this.sql = sql;    
    }    
    
    public String getSql() {    
        return sql;    
    }    
    
    public void setParameters(Object[] parameters) {    
        this.parameters = parameters;    
    }    
    
    public Object[] getParameters() {    
        return parameters;    
    }    
      
    @Override  
	public String toString() {
		if (parameters == null || sql == null) {
			return "";
		}
		List<Object> parametersArray = Arrays.asList(parameters);
		List<Object> list = new ArrayList<Object>(parametersArray);
		while (sql.indexOf("?") != -1 && list.size() > 0
				&& parameters.length > 0) {
			String tempVal = "";
			if(!ObjectHelper.isEmpty(list.get(0))){
				tempVal = list.get(0).toString();
			}
			sql = sql.replaceFirst("\\?", tempVal);
			list.remove(0);
		}
		return sql.replaceAll("(\r?\n(\\s*\r?\n)+)", "\r\n");
	}
}
