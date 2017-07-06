package com.creditharmony.core.thd;

public class Thread01 extends AbsThread implements IThread00 {
	
	private final String strCname = this.getClass().getName();
	private String strMsg = "";
	
	public void setMsg(String strMsg){
		this.strMsg = strMsg;
	}
	public void appendMag(String strAppend){
		this.strMsg = this.strMsg + ":" + strAppend;
	}
	
	@Override
	public void run() {
		String strFname = " run ; ";
		try{
			super.disOutputMsg(strFname + " - " + strMsg + "-" + Thread.currentThread().getId(), strCname);
//			System.out.println(strCname + " - " + strMsg + "-" + Thread.currentThread().getId());
		} catch(Exception ex) {
			
		}
	}

}
