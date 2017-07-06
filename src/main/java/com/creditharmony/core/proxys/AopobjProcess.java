package com.creditharmony.core.proxys;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.common.util.RemoteAddrUtils;
import com.creditharmony.core.users.entity.User;

public class AopobjProcess {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String strCname = getClass().getName();
	private	HashMap<String, Object> hmp = new HashMap<String, Object>();
	
	private AopobjProcess(){}
	
	public AopobjProcess(HttpServletRequest req, User user, String methodName){
		if(methodName!=null && methodName.trim().length()>0
				&& req!=null && user!=null
				&& req instanceof HttpServletRequest
				&& user instanceof User){
			disSetMap(req, user, methodName);
		}
	}
	
	private void disSetMap(HttpServletRequest req, User user, String methodName){
		String strFname = " disSetMap : ";
		try {
//			String strUrl = req.getServletPath().toString();
			String strUrl = req.getContextPath() + " || " + req.getRequestURI() + " || " + req.getServletPath()  ; 
//			String strIp = 	StringUtils.getRemoteAddr(req);
			String strIp = 	RemoteAddrUtils.getRemoteAddr(req);
			
			String strUserId = user.getId();
			String strUserLoginname = user.getLoginName();
			String strUserDep = user.getDepartment().getName();
			String strUserDepstr = user.getDepartmentStr();
			
			hmp.put("runMethodName", methodName);
			hmp.put("strUrl", strUrl);
			hmp.put("strIp", strIp);
			hmp.put("strUserId", strUserId);
			hmp.put("strUserLoginname", strUserLoginname);
			hmp.put("startTime", System.currentTimeMillis());
			hmp.put("pUuid", UUID.randomUUID());
			hmp.put("strUserDep", strUserDep);
			hmp.put("strUserDepstr", strUserDepstr);
			
			Map<String, String[]> params = req.getParameterMap();
			HashMap<String, String> mapPar = new HashMap<String, String>();
			for (String key : params.keySet()){
				if(key!=null && key.indexOf(".")>-1){
					key = key.replaceAll("\\.", "__");
				}
				String strVals = "";
				String[] values = params.get(key);
				if(values!=null && values.length>0){
					for (int i = 0; i < values.length; i++) {
						String value = values[i];
						strVals = strVals + "," + value;
					}
				}
				mapPar.put(key, strVals);
			}
			hmp.put("reqParams", mapPar);
			
		} catch(Exception ex) {
			hmp = null;
			long lonFlg = System.currentTimeMillis();
			logger.error(strCname + strFname + ex + "||" + lonFlg);
			StackTraceElement[] subSte = ex.getStackTrace();
			for(int i=0; i<subSte.length; i++){
				logger.error(
						subSte[i].getClassName() 
						+ subSte[i].getMethodName() 
						+ ":" + subSte[i].getLineNumber() 
						+ "||" + lonFlg );
			}
		}
	}
	
	public HashMap<String, Object> getMap(){
		return hmp;
	}
}
