package com.creditharmony.core.ocr.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.creditharmony.core.ocr.dto.RecognizeResult;

import exocr.exocrengine.OcrActivity;


public class RecognizeHelper {
	
	private static Logger logger = LoggerFactory.getLogger(RecognizeHelper.class);
	
	public static RecognizeResult recognize(String userId, MultipartFile cardFile){
		logger.debug("userId:" + userId);
		String uuId = UUID.randomUUID().toString();
		String fileName = getFileName(cardFile, uuId);
		FileOutputStream out = null;
		
		RecognizeResult idCardResult = new RecognizeResult();
		if(userId==null || userId.trim().equals("")){
			idCardResult.setErrorCode("用户无权限");
			logger.debug("调用ocr识别图像时,用户无权限.");
			return idCardResult;
		}
		String filePath = getFilePath();
		String newFile = filePath + fileName; 
		File file = new File(newFile);
		logger.debug("---开始写入文件---");
		try {
			byte[] bytes = cardFile.getBytes();
			out = new FileOutputStream(file);
			out.write(bytes);
			logger.debug("---写入文件---");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("调用ocr识别图像时,没有找到文件.");
			idCardResult.setErrorCode("调用ocr识别图像时,没有找到文件.");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ocr识别图像时,读取文件出错.");
			idCardResult.setErrorCode("调用ocr识别图像时,读取文件出错.");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("调用ocr识别图像时,关闭文件出错.");
				}
			}
		}
		logger.debug("---OcrActivity.getResult开始---");
		idCardResult = OcrActivity.getResult(fileName);
		if (file.exists()) {
			logger.debug("调用ocr识别图像时,删除文件时,文件的绝对路径:"+file.getAbsolutePath());
			file.delete();
			logger.debug("调用ocr识别图像时,删除文件成功.");
		}
		logger.debug("---OcrActivity.getResult结束---");
		return idCardResult;
	}
	
	public static RecognizeResult recognize(String userId, File cardFile){
		logger.debug("userId:" + userId);
		String uuId = UUID.randomUUID().toString();
		String fileName = getFileName(cardFile, uuId);
		FileOutputStream out = null;
		
		RecognizeResult idCardResult = new RecognizeResult();
		if(userId==null || userId.trim().equals("")){
			idCardResult.setErrorCode("用户无权限");
			logger.debug("调用ocr识别图像时,用户无权限.");
			return idCardResult;
		}
		String filePath = getFilePath();
		String newFile = filePath + fileName; 
		File file = new File(newFile);
		logger.debug("---开始写入文件---");
		try {
			out = new FileOutputStream(file);
			out.write(0);
			logger.debug("---写入文件---");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("调用ocr识别图像时,没有找到文件.");
			idCardResult.setErrorCode("调用ocr识别图像时,没有找到文件.");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("调用ocr识别图像时,读取文件出错.");
			idCardResult.setErrorCode("调用ocr识别图像时,读取文件出错.");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("调用ocr识别图像时,关闭文件出错.");
				}
			}
		}
		logger.debug("---OcrActivity.getResult开始---");
		idCardResult = OcrActivity.getResult(fileName);
		if (file.exists()) {
			logger.debug("调用ocr识别图像时,删除文件时,文件的绝对路径:"+file.getAbsolutePath());
			file.delete();
			logger.debug("调用ocr识别图像时,删除文件成功.");
		}
		logger.debug("---OcrActivity.getResult结束---");
		return idCardResult;
	}

	private static String getFilePath() {
		URL url = RecognizeHelper.class.getClassLoader().getResource("/web.xml");  
		String path = url.getPath().replace("/classes/web.xml", "");
		return path + "/ocr/";
	}

	private static String getFileName(MultipartFile cardFile, String uuid) {
		String fileName = uuid
				+ "."
				+ cardFile.getOriginalFilename().substring(
						cardFile.getOriginalFilename().lastIndexOf(".") + 1);
		return fileName;
	}
	
	private static String getFileName(File cardFile, String uuid) {
		String fileName = uuid
				+ "."
				+ cardFile.getName().substring(
						cardFile.getName().lastIndexOf(".") + 1);
		return fileName;
	}
	
}
