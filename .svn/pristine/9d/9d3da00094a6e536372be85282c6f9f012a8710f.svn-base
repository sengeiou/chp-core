package com.creditharmony.core.common.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteAddrUtils {
	private static Logger logger = LoggerFactory.getLogger(RemoteAddrUtils.class);
	  public static String getRemoteAddr(HttpServletRequest request) { 
		    String scheme = request.getScheme();
		    String ip = request.getHeader("X-Forwarded-For");
		    logger.info("RemoteAddrUtils:X-Forwarded-For:{},scheme:{}",ip,scheme);
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			    ip = request.getHeader("X-Real-IP"); 
			    logger.info("RemoteAddrUtils:X-Real-IP:{},scheme:{}",ip,scheme);
			} 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("Proxy-Client-IP"); 
		      logger.info("RemoteAddrUtils:Proxy-Client-IP:{},scheme:{}",ip,scheme);
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("WL-Proxy-Client-IP"); 
		      logger.info("RemoteAddrUtils:WL-Proxy-Client-IP:{},scheme:{}",ip,scheme);
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("HTTP_CLIENT_IP");
		      logger.info("RemoteAddrUtils:HTTP_CLIENT_IP:{},scheme:{}",ip,scheme);
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		      logger.info("RemoteAddrUtils:HTTP_X_FORWARDED_FOR:{},scheme:{}",ip,scheme);
		    } 		    
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getRemoteAddr(); 
		      logger.info("RemoteAddrUtils:RemoteAddr:{},scheme:{}",ip,scheme);
		    }
		    if(ip!=null && ip.trim().length()>0){
//		    if(StringUtils.isNotBlank(ip)){
		    	ip=ip.split(",")[0];
		    	logger.info("RemoteAddrUtils:ip[0]:{},scheme:{}",ip,scheme);
			}
		    return ip; 
		  } 
}
