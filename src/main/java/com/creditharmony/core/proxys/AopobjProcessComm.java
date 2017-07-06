package com.creditharmony.core.proxys;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.creditharmony.core.common.util.RemoteAddrUtils;

public class AopobjProcessComm {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String strCname = getClass().getName();
	private	HashMap<String, Object> hmp = new HashMap<String, Object>();
	
	private AopobjProcessComm(){}
	
	public AopobjProcessComm(HttpServletRequest req, String user, String methodName){
		if(methodName!=null && methodName.trim().length()>0
				&& req!=null && user!=null
				&& req instanceof HttpServletRequest
				&& user instanceof String){
			disSetMap(req, user, methodName);
		}
	}
	
	private void disSetMap(HttpServletRequest req, String user, String methodName){
		String strFname = " disSetMap : ";
		try {
			String strUrl = req.getServletPath().toString();
//			String strIp = StringUtils.getRemoteAddr(req);
			String strIp = 	RemoteAddrUtils.getRemoteAddr(req);
			String strUserId = "";
			String strUserLoginname = "";
			String strUserDep = "";
			String strUserDepstr = "";
			Map<String, String> mapUser = null;
			try {
				mapUser = JSON.parseObject(user, HashMap.class);
				if(mapUser!=null 
						&& mapUser.containsKey("strId")
						&& mapUser.containsKey("strLoginName")
						&& mapUser.containsKey("strDepartmentName")
						&& mapUser.containsKey("strDepartmentStr")){
					strUserId = mapUser.get("strId")==null ? "":mapUser.get("strId").toString();
					strUserLoginname = mapUser.get("strLoginName")==null ? "":mapUser.get("strLoginName").toString();
					strUserDep = mapUser.get("strDepartmentName")==null ? "":mapUser.get("strDepartmentName").toString();
					strUserDepstr = mapUser.get("strDepartmentStr")==null ? "":mapUser.get("strDepartmentStr").toString();
				}
			} catch(Exception ex0) {
				logger.error(strCname + strFname + ex0);
			}
			
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
