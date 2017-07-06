package com.creditharmony.core.thd.pools;

import java.util.Properties;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 强制依赖 IObject中public Object getObj();
 * 强制依赖 ObjRepePool01;
 * */
public class MuObjRepePool<T1, T2> {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String strCname = this.getClass().getName();
	private Vector<ObjRepePool01<T2>> objDbPool00;
	private int intBasePidx = 0;
	private int intPidx = 0;
	
	private MuObjRepePool(){}
	
	public MuObjRepePool(int intPnum, int intOnum, Properties ppt, T1 obj){
		String strFname = " disCreate : ";
		try{
			if(intPnum>0 && intOnum>0 && ppt!=null){
				intBasePidx = intPnum;
				objDbPool00 = new Vector<ObjRepePool01<T2>>();
				for(int j=0; j<intPnum; j++){
					IObject objI = (IObject)obj;
					ObjRepePool01<T2> objp = null;
					for(int i=0; i<intPnum; i++){
						if(objp==null){
							objp = new ObjRepePool01<T2>(ppt.getProperty("cnum"), (T2)objI.getObj());
						} else {
							objp.setObject((T2)objI.getObj());
						}
					}
					objDbPool00.add(objp);
				}
			}
		} catch(Exception ex) {
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
	
	public synchronized T2 getObj(){
		String strFname = " getObj : ";
		T2 t = null;
		try {
			if(intPidx>0 && intPidx<intBasePidx){
				t = objDbPool00.get(intPidx).getObject();
			} else if(intPidx>=intBasePidx){
				intPidx = 0;
				t = objDbPool00.get(intPidx).getObject();
			}
			intPidx = intPidx + 1;
		} catch(Exception ex) {
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
		return t;
	}
}
