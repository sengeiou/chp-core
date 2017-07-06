package com.creditharmony.core.thd.pools;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用对象控制pool
 * */
public class ThreadPool01<T> {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String strCname = this.getClass().getName();
	
	
	private int intBSize;
	private Vector<T> altThd;

	private T t;
	private ThreadPool01(){}
	/**
	 * @param num 缓存对象数
	 * @param cls 缓存对象Class
	 * */
	public ThreadPool01(int num, Class<T> cls){
		String strFname = " ThreadPool01 : ";
		try {
			this.t = cls.newInstance();
			this.intBSize = num;
			this.altThd = new Vector<T>(intBSize); 
			disInit();
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
	
	private void disInit() {
		String strFname = " disInit ; ";
		try {
			if(altThd.size()==0){
				disCreateThread(intBSize);
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
	public synchronized T getThread() {
		String strFname = " getThread ; ";
		T rnbRe = null;
		try {
			synchronized (altThd) {
				while(rnbRe==null){
					if(altThd.size()<=intBSize*0.9){
						disCreateThread(-1);
					} else if (altThd.size()>intBSize*0.9) {
						rnbRe = altThd.remove(0);
						if(rnbRe==null){
							rnbRe = (T)t.getClass().newInstance();
						}
					} else {
						rnbRe = (T)t.getClass().newInstance();
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(strFname + ex);
			try{
				rnbRe = (T)t.getClass().newInstance();
			} catch(Exception exx) {
				long lonFlg = System.currentTimeMillis();
				logger.error(strCname + strFname + exx + "||" + lonFlg);
				StackTraceElement[] subSte = exx.getStackTrace();
				for(int i=0; i<subSte.length; i++){
					logger.error(
							subSte[i].getClassName() 
							+ subSte[i].getMethodName() 
							+ ":" + subSte[i].getLineNumber() 
							+ "||" + lonFlg );
				}
			}
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
//		System.out.println(strFname + " End " + altThd.size() + ":" + System.currentTimeMillis());
		return rnbRe;
	}

	private void disCreateThread(int intNum){
		String strFname = " disCreateThread ; ";
		try{
			if(intNum==-1 && altThd.size()<=intBSize*0.9){
//				System.out.println(strFname + " Start" + altThd.size() + ":" + System.currentTimeMillis());
				for(int i=0 ; i<50; i++){
					synchronized (altThd) {
						altThd.add((T)t.getClass().newInstance());
					}
				}
//				System.out.println(strFname + " End" + altThd.size() + ":" + System.currentTimeMillis());
			} else if(intNum==intBSize) {
				for(int i=0 ; i<intNum; i++){
					synchronized (altThd) {
						altThd.add((T)t.getClass().newInstance());
					}
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
}
