package com.creditharmony.core.cache;

import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditharmony.cache.redis.service.RedisService;
import com.creditharmony.common.util.SpringContextHolder;

/**
 * 验证码缓存
 * 
 * @Class Name UserCache
 * @author zy
 * @Create In 2016年1月25日
 */
public class ValidateCodeCacheSingle {
	private static final Logger logger = LoggerFactory
			.getLogger("com.creditharmony.core.cache.ValidateCodeCache");
	private static final String strCname = "com.creditharmony.core.cache.ValidateCodeCache";

	// private static ValidateCodeCache cache = new ValidateCodeCache();
	private static final String key = "validateCode";
	// private static RedisService redisService =
	// ((RedisService)SpringContextHolder.getBean("redisService"));
	private static final String SPLIT_CHAR = ":";

	// public static ValidateCodeCache getInstance(){
	// return cache;
	// }

	public static boolean save(String id, String random) {
		String strFname = " save : ";
		boolean booRe = false;
		try {
			RedisService redisService = disGetRd();
			if (redisService != null) {
				redisService.saveOrUpdate(key + SPLIT_CHAR + id,
						(Object) random, 180);
				disReback(redisService);
				booRe = true;
			}
		} catch (Exception ex) {
			logger.error(System.currentTimeMillis() + " ---- " + strCname
					+ strFname + ex);
			StackTraceElement[] subSte = ex.getStackTrace();
			for (StackTraceElement obj : subSte) {
				logger.error(" ---- " + strCname + strFname
						+ obj.getMethodName() + ":" + obj.getLineNumber());
			}
		}
		return booRe;
	}

	public static String get(String id) {
		// return (String) RedisUtils.getObject(key + SPLIT_CHAR + id);
		String strFname = " get : ";
		String strRe = null;
		try {
			RedisService redisService = disGetRd();
			if (redisService != null) {
				strRe = (String) redisService.getObject(key + SPLIT_CHAR + id);
				disReback(redisService);
			}
		} catch (Exception ex) {
			logger.error(System.currentTimeMillis() + " ---- " + strCname
					+ strFname + ex);
			StackTraceElement[] subSte = ex.getStackTrace();
			for (StackTraceElement obj : subSte) {
				logger.error(" ---- " + strCname + strFname
						+ obj.getMethodName() + ":" + obj.getLineNumber());
			}
		}
		return strRe;
	}

	public static boolean remove(String id) {
		// RedisUtils.remove(key + SPLIT_CHAR + id);
		String strFname = " remove : ";
		boolean booRe = false;
		try {
			RedisService redisService = disGetRd();
			if (redisService != null) {
				redisService.delete(key + SPLIT_CHAR + id);
				disReback(redisService);
				booRe = true;
			}
		} catch (Exception ex) {
			logger.error(System.currentTimeMillis() + " ---- " + strCname
					+ strFname + ex);
			StackTraceElement[] subSte = ex.getStackTrace();
			for (StackTraceElement obj : subSte) {
				logger.error(" ---- " + strCname + strFname
						+ obj.getMethodName() + ":" + obj.getLineNumber());
			}
		}
		return booRe;
	}

	private static Vector<RedisService> lstRconn = new Vector<RedisService>();

	private static void disCreate() {
		String strFname = " disCreate : ";
		try {
			lstRconn = new Vector(20);
			for (int i = 0; i < 20; i++) {
				lstRconn.add(((RedisService) SpringContextHolder
						.getBean("redisService")));
			}
		} catch (Exception ex) {
			logger.error(System.currentTimeMillis() + " ---- " + strCname
					+ strFname + ex);
			StackTraceElement[] subSte = ex.getStackTrace();
			for (StackTraceElement obj : subSte) {
				logger.error(" ---- " + strCname + strFname
						+ obj.getMethodName() + ":" + obj.getLineNumber());
			}
		}
	}

	private static RedisService disGetRd() {
		String strFname = " disGetRd : ";
		RedisService redisService = null;
		try {
			synchronized (lstRconn) {
				if (lstRconn == null
						|| (lstRconn != null && lstRconn.size() == 0)) {
					disCreate();
				} else {
					if (lstRconn.size() > 0) {
						redisService = lstRconn.remove(0);
					} else {
						redisService = ((RedisService) SpringContextHolder
								.getBean("redisService"));
					}
				}
			}
		} catch (Exception ex) {
			logger.error(System.currentTimeMillis() + " ---- " + strCname
					+ strFname + ex);
			StackTraceElement[] subSte = ex.getStackTrace();
			for (StackTraceElement obj : subSte) {
				logger.error(" ---- " + strCname + strFname
						+ obj.getMethodName() + ":" + obj.getLineNumber());
			}
		}
		return redisService;
	}

	private static void disReback(RedisService redisService) {
		String strFname = " disReback : ";
		try {
			synchronized (lstRconn) {
				if (lstRconn != null && lstRconn.size() < 20) {
					lstRconn.add(redisService);
				} else {
					redisService = null;
				}
			}
		} catch (Exception ex) {
			logger.error(System.currentTimeMillis() + " ---- " + strCname
					+ strFname + ex);
			StackTraceElement[] subSte = ex.getStackTrace();
			for (StackTraceElement obj : subSte) {
				logger.error(" ---- " + strCname + strFname
						+ obj.getMethodName() + ":" + obj.getLineNumber());
			}
		}
	}
}

