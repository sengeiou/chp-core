package com.creditharmony.core.propertiess;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetProperties {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String strCname = this.getClass().getName();
	
	public Properties disGet(String strPath){
		String strFname = " disGet : ";
		Properties proRe = null;
		String strLocalPath = null;
		try {
			if(strPath!=null && strPath.trim().length()>0){
				strLocalPath = strPath;
				proRe =  new  Properties(); 
				String strOs = System.getProperty("os.name");
				if(strLocalPath.indexOf("/")==0
						&& strOs.trim().toUpperCase().indexOf("WIN")>-1){
					strLocalPath = strLocalPath.substring(1, strLocalPath.length());
				}
				File file1 = new File(strLocalPath);
				if(file1!=null){
					InputStream ins = new FileInputStream(file1);
					proRe.load(ins); 
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
			proRe = null;
		}
		return proRe;
	}
}
