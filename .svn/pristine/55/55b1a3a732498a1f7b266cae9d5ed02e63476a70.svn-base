package exocr.exocrengine;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditharmony.core.ocr.dto.RecognizeResult;

public class OcrActivity {
	
    public native static int get();
    public native static void set(int i);
    
    private static Logger logger = LoggerFactory.getLogger(OcrActivity.class);
    
    private static boolean isInit = false;
    
    public static RecognizeResult getResult(String name){
    	
    	RecognizeResult idcardRst = new RecognizeResult();
    	URL url = OcrActivity.class.getClassLoader().getResource("/web.xml"); 
    	String path = url.getPath().replace("/classes/web.xml", "") + "/ocr/";
    	logger.debug("path:" + path);
    	byte [] bPath = new byte[512];
    	for(int i = 0; i < path.length(); i++){
    		bPath[i]= (byte)path.charAt(i);
    	}
    	bPath[path.length()] = 0;
    	if(!isInit){
    		int res = EXOCREngine.init(bPath);
        	logger.debug("调用ocr,EXOCREngine.nativeInit返回值res:" + res);
        	if(res != 0){
        		idcardRst.setErrorCode("加载OCR出错");
        		logger.debug("加载OCR出错");
        		EXOCREngine.nativeDone();
            	return idcardRst;
        	}
        	isInit=true;
    	}
    	
    	String imgPath = path+name;
    	logger.debug("调用ocr,执行方法getResult()时,imgPath:" + imgPath);
    	EXOCREngine engine = new EXOCREngine();
    	for(int i = 0; i < imgPath.length(); i++){
    		bPath[i]= (byte)imgPath.charAt(i);
    	}
    	bPath[imgPath.length()] = 0;
    	int rstLen = EXOCREngine.EXCARDSRecoIDCard2FaceFileServer(bPath, engine.bResultBuf, 4096);
    	if(rstLen > 0){
    		idcardRst = RecognizeResult.decode(engine.bResultBuf, rstLen);
    	}else{
    		idcardRst.setErrorCode("图片识别失败，请确认上传图片的格式以及布局规范");
    		logger.debug("图片识别失败，请确认上传图片的格式以及布局规范");
    	}
    	return idcardRst;
    }
}