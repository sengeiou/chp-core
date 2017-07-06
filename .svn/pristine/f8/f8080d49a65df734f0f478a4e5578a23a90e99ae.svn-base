package com.creditharmony.core.proxys;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;

import com.alibaba.fastjson.JSON;
import com.creditharmony.core.thd.AbsThrdSendMsg;
import com.creditharmony.core.thd.pools.ThreadPool01;
import com.creditharmony.core.thd.runs.ThreadRun01;
import com.creditharmony.core.users.entity.User;

public class CtlrAspectProcess {
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//	private final String strCname = this.getClass().getName();
	private String strFlg;
	private CtlrAspectProcess(){}
	
	public CtlrAspectProcess(String strFlg){
		if(strFlg!=null && strFlg.trim().length()>0){
			this.strFlg = strFlg;
		}
	}
	
	public void disBefore(String strFlg
			, String strSys
			, String strAopFlg
			, JoinPoint joinpoint
			, User userObj
			, ThreadLocal<HashMap<String, Object>> tdl
			, ThreadPool01<AbsThrdSendMsg> thdpMang_MsgSend
			, ThreadRun01 thdrMang_MsgSend) throws Exception{
		if(strFlg!=null && strFlg.trim().length()>0 && strFlg.equals(this.strFlg)
				&& joinpoint!=null 
				&& userObj!=null
				&& tdl!=null
				&& thdpMang_MsgSend!=null
				&& thdrMang_MsgSend!=null){ 
			String strClassName = joinpoint.getTarget().getClass().getName();
			String methodName = joinpoint.getSignature().getName();
			Object[] subArg = joinpoint.getArgs();
			if(subArg!=null && subArg.length>0){
				Object obj = null;
				int i=0;
				int intLength = subArg.length;
				for(; i<intLength; i++){
					obj = subArg[i];
					if(obj!=null){
						String strArgClassName = obj.getClass().getName();
						if(strArgClassName!=null && strArgClassName.trim().length()>0
								&& strArgClassName.toUpperCase().indexOf("HTTPSERVLETREQUEST")>-1){
							HttpServletRequest reqObj = (HttpServletRequest)obj;
							AopobjProcess objAp = new AopobjProcess(reqObj, userObj, methodName);
							HashMap<String, Object> hmp = objAp.getMap();
							hmp.put("runClassName", strClassName);
							hmp.put("methodFlg", "Befrore");
							hmp.put("AopFlg", strAopFlg);
							if(hmp!=null && hmp.size()>0){
//								tdl.set(hmp);
								disMsgOutput(hmp, strSys, thdpMang_MsgSend, thdrMang_MsgSend);
							}
							break;
						}
					}
				}
			}
			System.out.println("前置通知：The method "+ methodName + " starts");
		}
	}

	public void disAfter(String strFlg
			, String strSys
			, String strAopFlg
			, JoinPoint joinpoint
			, ThreadLocal<HashMap<String, Object>> tdl
			, ThreadPool01<AbsThrdSendMsg> thdpMang_MsgSend
			, ThreadRun01 thdrMang_MsgSend) throws Exception{
		if(strFlg!=null && strFlg.trim().length()>0 && strFlg.equals(this.strFlg)
				&& joinpoint!=null 
				&& tdl!=null
				&& thdpMang_MsgSend!=null
				&& thdrMang_MsgSend!=null){
			String methodName = joinpoint.getSignature().getName();
			HashMap<String, Object> hmp = ThreadLocalManage.tdl.get();
			if(methodName!=null && methodName.trim().length()>0
					&& hmp!=null && hmp.size()>0
					&& hmp.containsKey("runMethodName") && hmp.get("runMethodName")!=null){
				String strTdlMethodname = hmp.get("runMethodName")==null? "":hmp.get("runMethodName").toString();
				if(strTdlMethodname.trim().length()>0
						&& methodName.trim().equals(strTdlMethodname.trim())){
//					disMsgOutput(hmp);
					hmp.put("methodFlg", "After");
					hmp.put("AopFlg", strAopFlg);
					disMsgOutput(hmp, strSys, thdpMang_MsgSend, thdrMang_MsgSend);
				}
			}
			ThreadLocalManage.tdl.set(null);
			System.out.println("后置通知：The method "+ methodName +" ends ");
		}
	}
	
	public void disAfterThrowing(String strFlg
			, String strSys
			, String strAopFlg
			, JoinPoint joinpoint
			, User userObj
			, Throwable thrEx
			, ThreadLocal<HashMap<String, Object>> tdl
			, ThreadPool01<AbsThrdSendMsg> thdpMang_MsgSend
			, ThreadRun01 thdrMang_MsgSend) throws Exception{
		if(strFlg!=null && strFlg.trim().length()>0 && strFlg.equals(this.strFlg)
				&& joinpoint!=null 
				&& userObj!=null
				&& thrEx!=null
				&& tdl!=null
				&& thdpMang_MsgSend!=null
				&& thdrMang_MsgSend!=null){
			String methodName = joinpoint.getSignature().getName();
			if(methodName!=null && methodName.trim().length()>0){
				Object[] subArg = joinpoint.getArgs();
				if(subArg!=null && subArg.length>0){
					Object obj = null;
					int i=0;
					int intLength = subArg.length;
					for(; i<intLength; i++){
						obj = subArg[i];
						String strArgClassName = obj.getClass().getName();
						if(strArgClassName!=null && strArgClassName.trim().length()>0
								&& strArgClassName.toUpperCase().indexOf("HTTPSERVLETREQUEST")>-1){
//							User userObj = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
							HttpServletRequest reqObj = (HttpServletRequest)obj;
							AopobjProcess objAp = new AopobjProcess(reqObj, userObj, methodName);
							HashMap<String, Object> hmp = objAp.getMap();
							hmp.put("pUuid","AfterThrowingUuid");
							hmp.put("methodFlg", "AfterThrowing");
							hmp.put("AopFlg", strAopFlg);
							hmp.put("thrEx", thrEx);
							hmp.put("thrExStr", thrEx.getMessage());
//							disMsgOutput(hmp);
							disMsgOutput(hmp, strSys, thdpMang_MsgSend, thdrMang_MsgSend);
							break;
						}
					}
				}
			}
			ThreadLocalManage.tdl.set(null);
			System.out.println("异常通知：The method "+ methodName +" ends ");
		}
	}
	
	private void disMsgOutput(HashMap<String, Object> hmp
			, String strSys
			, ThreadPool01<AbsThrdSendMsg> thdpMang_MsgSend
			, ThreadRun01 thdrMang_MsgSend) throws Exception{
		hmp.put("sysFlg", strSys);
		hmp.put("endTime", System.currentTimeMillis());
		String json0 = JSON.toJSONString(hmp);
		System.out.println(" runProcessOutput---- " + json0);
//		ThrdSendMsg obj = (ThrdSendMsg)ThreadPoolManage.thdpMang_MsgSend.getThread();
		AbsThrdSendMsg obj = (AbsThrdSendMsg)thdpMang_MsgSend.getThread();
		obj.setMsg(json0);
		obj.setSys(strSys);
//		ThreadRunManage.thdrMang_MsgSend.putThread2Mlt((Runnable)obj);
		thdrMang_MsgSend.putThread2Mlt((Runnable)obj);
	}
}
