package com.creditharmony.core.proxys;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.creditharmony.core.users.dao.UserDao;

@Component
@Service
public class DaoProxyProcess {
	private final String strCname = this.getClass().getName();

	@Autowired
	private UserDao userDao;
	
	public void disLogProcessBefore(ArrayList altArgs){
		String strFname = " disLogProcessBefore : ";
		HashMap<String, Object> hmpInfo = new HashMap<String, Object>();
		Object objRe = null;
		try{
			System.out.println(strFname + " Start");
			if(altArgs!=null && altArgs.size()==6){
				Object proxy = null;
				Method method = null;
				Object[] args = null;
//				MapperMethod mapperMethod = null;
//				SqlSession sqlSession = null;
				method = (Method)altArgs.get(1);
				
				HashMap<String, Object> hmp = ThreadLocalManage.tdl.get();
				if(hmp==null || (hmp!=null && hmp.size()==0)){
					return;
				}
				if(method!=null){
					String strMethodname = method.getName();
					if(strMethodname!=null && strMethodname.trim().length()>0){
						if("update".equals(strMethodname.trim()) 
								|| "save".equals(strMethodname.trim())){
							proxy = (Object)altArgs.get(0);
							if(proxy!=null){
								String strDaoPath = proxy.getClass().getInterfaces()[0].getName();
								if(strDaoPath!=null && strDaoPath.trim().length()>0){
									String[] subProxy = strDaoPath.split("\\.");
									if(subProxy!=null && subProxy.length>0){
										args =  (Object[])altArgs.get(2);
										if(args!=null && args.length==1){
											String strId = null;
											String strEntityName = args[0].getClass().getSuperclass().getSuperclass().getName()+":";
											String strE = "BaseEntity:";
											if(strEntityName!=null && strEntityName.indexOf(strE)>-1){
												Field[] subField = args[0].getClass().getSuperclass().getSuperclass().getDeclaredFields();
												if(subField!=null && subField.length>0){
													int i = 0;
													int intLength = subField.length;
													for(; i<intLength; i++){
														if(subField[i]!=null && "id".toUpperCase().equals(subField[i].getName().toUpperCase())){
															subField[i].setAccessible(true);
															strId = subField[i].get(args[0])==null? "":subField[i].get(args[0]).toString();
															if(strId!=null && strId.trim().length()>0){
																Method methodToExecute = proxy.getClass().getDeclaredMethod("get", new Class[]{String.class});
																Object obj = methodToExecute.invoke(proxy, strId);
//																System.out.println(strFname + "---- " + obj);
																if(obj!=null){
//																	String strObjReClass = obj.getClass().getName();
//																	hmpInfo.put("objReClass", strObjReClass);
																	hmpInfo.put("getObjRe", disGetObjval(obj, hmpInfo, 9999));
																	HashMap<String, Object> hmpAll = new HashMap<String, Object>();
																	hmpAll.putAll(hmpInfo);
																	hmpAll.putAll(hmp);
																	hmpAll.put("daoMethodName", method.getName());
																	disLogSave(hmpAll);
																	break;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch(Exception ex){
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		} finally {
			hmpInfo = null;
		}
	}
	public void disLogProcess(ArrayList altArgs){
		String strFname = " disLogProcess : ";
		HashMap<String, Object> hmpInfo = new HashMap<String, Object>();
		Object objRe = null;
		try{
			System.out.println(strFname + " Start");
			if(altArgs!=null && altArgs.size()==6){
				Object proxy = null;
				Method method = null;
				Object[] args = null;
				MapperMethod mapperMethod = null;
				SqlSession sqlSession = null;
				method = (Method)altArgs.get(1);
				
				HashMap<String, Object> hmp = ThreadLocalManage.tdl.get();
				if(hmp==null || (hmp!=null && hmp.size()==0)){
					return;
				}
				//验证：此method的name是否需要进行后续拦截处理
				if(disCheckMothed(method, hmpInfo)){
					proxy = (Object)altArgs.get(0);
					args = (Object[])altArgs.get(2);
					mapperMethod = (MapperMethod)altArgs.get(3);
					sqlSession = (SqlSession)altArgs.get(4);
					objRe = altArgs.get(5);
					
					hmpInfo.put("mapperMethod", mapperMethod);
					
					if(method!=null  
							&& proxy!=null
							&& args!=null
							&& mapperMethod!=null 
							&& sqlSession!=null){
						//验证：此dao的class是否需要进行后续拦截处理
						if(disCheckDao(proxy, hmpInfo)){
							String[] subSqlMaps = sqlSession.getConfiguration().getMappedStatementNames().toArray(new String[0]);
							//获取当前Dao操作sql
							if(disGetSql(sqlSession, subSqlMaps, hmpInfo)){
								//获取当前dao执行参数集合
								if(disGetArgs(args, hmpInfo)){
									//存储此dao操作信息
									if(hmpInfo!=null && hmpInfo.containsKey("methodName")){
//										if("get".equals(hmpInfo.get("methodName"))){
//											hmpInfo.put("getObjRe", disGetObjval(objRe, hmpInfo, 0));
//										}
										HashMap<String, Object> hmpAll = new HashMap<String, Object>();
										hmpAll.putAll(hmpInfo);
										hmpAll.putAll(hmp);
										hmpAll.put("daoMethodName", method.getName());
										disLogSave(hmpAll);
									}
								}
							}
						}
					}
				}
			}
		} catch(Exception ex){
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		} finally {
			hmpInfo = null;
		}
	}
	
	private void disLogSave(HashMap<String, Object> hmpAll){
		String strFname = " disLogSave : ";
		try{
			if(hmpAll!=null && hmpAll.size()>0){
				hmpAll.remove("mapperMethod");
				hmpAll.remove("proxy");
				hmpAll.remove("method");
				hmpAll.remove("args");
				hmpAll.remove("sqlSession");
				hmpAll.remove("subSqlMaps");
				
				String json0 = JSON.toJSONString(hmpAll);
				System.out.println(strFname + " runProcessOutput---- " + json0);
			}
		} catch(Exception ex) {
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
	}
	
	/**
	 * 获取args值集合
	 * */
	private boolean disGetArgs(Object[] args, HashMap<String, Object> hmpInfo){
		String strFname = " disGetArgs : ";
		boolean booRe = false;
		try {
			if(args!=null 
					&& hmpInfo!=null){
				HashMap<String, Object> hmpArgs = new HashMap<String, Object>();
				hmpInfo.put("args", args);
				Set<String> setType = disCreateAtttpyeSet();
				if(setType!=null){
					
					int i = 0;
					int intLength = args.length;
					for(; i<intLength; i++){
						Object obj = args[i];
						if(obj!=null){
							if(setType.contains(obj.getClass().getName())){
								hmpArgs.put("arg"+i, obj.toString());
							} else {
								hmpArgs.put("arg"+i, disGetObjval(obj, hmpInfo, i));
							}
						}
						
//						System.out.println(strFname + " pro000");
					}
					
					booRe = true;
				}
				hmpInfo.put("argsVal", hmpArgs);
			}
		} catch(Exception ex) {
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
		return booRe;
	}
	/**
	 * 获取arg对象的属性值
	 * */
	private HashMap<String, String> disGetObjval(Object obj, HashMap<String, Object> hmpInfo, int ii){
		String strFname = " disGetObjval : "; 
		HashMap<String, String> hmpRe = new HashMap<String, String>();
		try{
			if(obj!=null 
					&& hmpInfo!=null){
//					&& hmpInfo.containsKey("proxyDaoname")){
				String strObjName = obj.getClass().getName();
				hmpRe.put("obj"+ii+"Name", strObjName);
				Field[] subField =  obj.getClass().getDeclaredFields(); 
				if(subField!=null && subField.length>0){
					int i = 0;
					int intLength = subField.length;
					for(; i<intLength; i++){
						if(subField[i]!=null){
							subField[i].setAccessible(true);
							String strField = subField[i].getName();
							String strFieldVal = subField[i].get(obj)==null? "":subField[i].get(obj).toString();
							if(strField!=null && strField.trim().length()>0
									&& strFieldVal!=null){
								hmpRe.put(strField, strFieldVal);
							}
						}
//						System.out.println("");
					}
				}
			}
		} catch(Exception ex) {
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
			hmpRe = new HashMap<String, String>();
		}
		return hmpRe;
	}
	/**
	 * 创建属性类型Set
	 * */
	private Set<String> disCreateAtttpyeSet(){
		String strFname = " disCreateAtttpyeSet : ";
		Set<String> setRe = null;
		try{
			setRe = new HashSet<String>();
			setRe.add("java.lang.Integer");
			setRe.add("java.lang.Double");
			setRe.add("java.lang.Float");
			setRe.add("java.lang.Long");
			setRe.add("java.lang.Short");
			setRe.add("java.lang.Byte");
			setRe.add("java.lang.Boolean");
			setRe.add("java.lang.Character");
			setRe.add("java.lang.String");
			setRe.add("int");
			setRe.add("double");
			setRe.add("long");
			setRe.add("short");
			setRe.add("byte");
			setRe.add("boolean");
			setRe.add("char");
			setRe.add("float");
		} catch(Exception ex){
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
		return setRe;
	}
	
	/**
	 * 获取当前dao操作sql
	 * */
	private boolean disGetSql(SqlSession sqlSession, String[] subSqlMaps, HashMap<String, Object> hmpInfo){
		String strFname = " disGetSql : ";
		boolean booRe = false;
		
		try{
			if(sqlSession!=null
					&& subSqlMaps!=null && subSqlMaps.length>0
					&& hmpInfo!=null
					&& hmpInfo.containsKey("methodName") && hmpInfo.containsKey("proxyDaoname")){
				hmpInfo.put("sqlSession", sqlSession);
				hmpInfo.put("subSqlMaps", subSqlMaps);
				String strMethodName = hmpInfo.get("methodName")==null? null:hmpInfo.get("methodName").toString();
				String strProxyDaoname = hmpInfo.get("proxyDaoname")==null? null:hmpInfo.get("proxyDaoname").toString();
				//验证methodName\proxyDaoname存在
				if(strMethodName!=null && strMethodName.trim().length()>0
						&& strProxyDaoname!=null && strProxyDaoname.trim().length()>0){
					String strIfbase = "."+strProxyDaoname+"."+strMethodName+":";
					int i = 0;
					int intLength = subSqlMaps.length;
					for(; i<intLength; i++){
						String strTmp = subSqlMaps[i]+":";
						if(strTmp!=null && strTmp.trim().length()>0
								&& strTmp.indexOf(strIfbase)>0){
//							System.out.println(strFname + "---- " + strTmp);
							strIfbase = strTmp.substring(0, strTmp.length()-1);
							break;
						}
					}
					hmpInfo.put("sql", null);
					if(strIfbase!=null && strIfbase.trim().length()>0){
						try{
							String strSql = sqlSession.getConfiguration()
									.getMappedStatement(strIfbase)
									.getBoundSql(null).getSql()==null? "": sqlSession.getConfiguration()
																				.getMappedStatement(strIfbase)
																				.getBoundSql(null).getSql();
							hmpInfo.put("sqlMap", strIfbase);
							hmpInfo.put("sql", strSql.trim());
							
						} catch(Exception exx) {
							System.out.println(strCname + strFname + exx);
							StackTraceElement[] subste = exx.getStackTrace();
							for(StackTraceElement ste : subste){
								System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
							}
						}
					}
				}
				booRe = true;
			}
		} catch(Exception ex) {
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
		return booRe;
	}
	/**
	 * 验证method是否符合拦截
	 * */
	private boolean disCheckMothed(Method method, HashMap<String, Object> hmpInfo){
		String strFname = " disCheckMothed : ";
		boolean booRe = false;
		try{
			if(hmpInfo!=null 
					&& method!=null){
				hmpInfo.put("method", method);
				String strMothedName = method.getName();
				
				Set<String> set = disCreateMethodSet();
				if(strMothedName!=null && strMothedName.trim().length()>0
						&& set!=null){
					hmpInfo.put("methodName", strMothedName);
					if(set.contains(strMothedName)){
						booRe = true;
					}
				}
			}
		} catch(Exception ex) {
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
		return booRe;
	}
	/**
	 * method的set对象的构建
	 * */
	private Set<String> disCreateMethodSet(){
		String strFname = " disCreateProxySet : ";
		Set<String> setRe = null;
		try{
			setRe = new HashSet<String>();
//			setRe.add("get");
			setRe.add("insert");
			setRe.add("update");
			setRe.add("delete");
		} catch(Exception ex){
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
		return setRe;
	}
	
	/**
	 * 验证传入参数（dao的class）是否在拦截范围内
	 * @return true:需要拦截  false:不需要拦截
	 * */
	private boolean disCheckDao(Object proxy, HashMap<String, Object> hmpInfo) {
		String strFname = " disChec : ";
		boolean booRe = false;
		try{
			
			//验证：proxy对象存在；proxy的class是数组；proxy的class数组有一个以上内容
			if(hmpInfo!=null 
					&& proxy!=null 
					&& proxy.getClass().getInterfaces().getClass().isArray()
					&& proxy.getClass().getInterfaces().length>0){
				hmpInfo.put("proxy", proxy);
				//取得Dao完整path
				String strDaoPath = proxy.getClass().getInterfaces()[0].getName();
				//验证：dao完整path存在；dap完整path有长度
				if(strDaoPath!=null && strDaoPath.trim().length()>0){
					hmpInfo.put("proxyAllpath", strDaoPath);
					//拆解：dao的path成为数组
					String[] subStrDaoPath = strDaoPath.split("\\.");
					//验证：dao完整path数组存在；
					if(subStrDaoPath!=null && subStrDaoPath.length>0){
						//取得dao的class的自身名
						String strDaoName = subStrDaoPath[subStrDaoPath.length-1];
						Set<String> set = disCreateProxySet();
						if(strDaoName!=null && strDaoName.trim().length()>0 
								&& set!=null){
							hmpInfo.put("proxyDaoname", strDaoName);
							if(set.contains(strDaoName)){
								booRe = true;
							}
						}
					}
				}
			}
		} catch(Exception ex){
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
		return booRe;
	}
	/**
	 * proxy的set对象的构建
	 * */
	private Set<String> disCreateProxySet(){
		String strFname = " disCreateProxySet : ";
		Set<String> setRe = null;
		try{
			setRe = new HashSet<String>();
//			setRe.add("AreaDao");
//			setRe.add("MenuDao");
//			setRe.add("ModuleDao");
//			setRe.add("ModuleMenuDao");
//			setRe.add("ProvinceCityDao");
//			setRe.add("RoleDao");
			setRe.add("UserDao");
//			setRe.add("UserRoleOrgDao");
//			setRe.add("WorkflowConfigDao");
		} catch(Exception ex){
			System.out.println(strCname + strFname + ex);
			StackTraceElement[] subste = ex.getStackTrace();
			for(StackTraceElement ste : subste){
				System.out.println(strCname + strFname + ste.getClassName() + ste.getMethodName() + " : " + ste.getLineNumber());
			}
		}
		return setRe;
	}
}
