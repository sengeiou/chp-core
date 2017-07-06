package com.creditharmony.core.ocr.dto;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * 识别结果对象
 * @Class Name RecognizeResult
 * @author 张永生
 * @Create In 2016年4月7日
 */
public class RecognizeResult implements Serializable{

	private static final long serialVersionUID = 3599520649829660316L;
	
	private String imgtype;
    private int type;
    private String cardnum;
    private String name;
    private String sex;
    private String address;
    private String nation;
    private String office;
    private String validdate;
    private int nColorType;
    private String errorCode;
    
    
	public String getImgtype() {
		return imgtype;
	}
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getValiddate() {
		return validdate;
	}
	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}
	public int getnColorType() {
		return nColorType;
	}
	public void setnColorType(int nColorType) {
		this.nColorType = nColorType;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
    
	
	/**
	 * decode
	 * 2016年4月7日
	 * By 张永生
	 * @param bResultBuf
	 * @param reslen
	 * @return
	 */
	public static RecognizeResult decode(byte[] bResultBuf, int reslen) {
		byte code;
		int i, j, rdcount;
		String content = null;
		RecognizeResult idcard = new RecognizeResult();
		rdcount = 0;
		while (rdcount < reslen) {
			code = bResultBuf[rdcount++];
			i = 0;
			j = rdcount;
			while (rdcount < reslen) {
				i++;
				rdcount++;
				if (bResultBuf[rdcount] == 0x20){
					break;
				}
			}
			try {
				content = new String(bResultBuf, j, i, "gbk");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (code == 0x21) {
				idcard.setCardnum(content);
			} else if (code == 0x22) {
				idcard.setName(content);
			} else if (code == 0x23) {
				idcard.setSex(content);
			} else if (code == 0x24) {
				idcard.setNation(content);
			} else if (code == 0x25) {
				idcard.setAddress(content);
			} else if (code == 0x26) {
				idcard.setOffice(content);
			} else if (code == 0x27) {
				idcard.setValiddate(content);
			}
			rdcount++;
		}
		return idcard;
	}
    
}
