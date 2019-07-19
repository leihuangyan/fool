package com.lhy.fool.util.excel;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * 对上传的文件进行预处理
 * @author 148122
 * @date 2016-4-16
 */
public class CEVUtil {

	/**
	 * 依据后缀名判断读取的是否为Excel文件
	 * @param filePath
	 * @return
	 * @author 148122
	 * @date 2016-4-16
	 */
	public static boolean isExcel(String filePath) {
		//正则表达式匹配
		if (filePath.matches("^.+\\.(?i)(xls)$")
				|| filePath.matches("^.+\\.(?i)(xlsx)$")) {
			return true;
		}
		return false;
	}

	/**
	 * 检查文件是否存在
	 * @author 148122
     * @date 2016-4-16
	 */
	public static boolean fileExist(String filePath) {
		//文件路径为空
		if (filePath == null || filePath.trim().equals(""))
			return false;
		File file = new File(filePath);
		//文件不存在或为空
		if (file == null || !file.exists()) {
			return false;
		}
		return true;
	}

	/**
	 * 依据内容判断是否为excel2003及以下
	 * @author 148122
     * @date 2016-4-16
	 */
	public static boolean isExcel2003(String filePath) {
		try {
			//定义流
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(filePath));
			//读取流
			if (POIFSFileSystem.hasPOIFSHeader(bis)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * 依据内容判断是否为excel2007及以上
	 * @author 148122
     * @date 2016-4-16
	 */
	public static boolean isExcel2007(String filePath) {
		try {
			//定义流
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(filePath));
			//读取流
			if (POIXMLDocument.hasOOXMLHeader(bis)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	//根据服务器的绝对路径删除新导入服务器的文件
	public static Boolean deleteFile(String path){
		 //找到该文件的实体
	    File file = new File(path);
	    //判断该文件的有效性
	    if (file.isFile() && file.exists()) {
	      //删除该文件
	      file.delete();
	      return true;
	    } else {
	        return false;
	      }
	}
}
