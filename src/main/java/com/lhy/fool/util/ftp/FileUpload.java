package com.lhy.fool.util.ftp;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

/**
 *
 * 文件上传
 * @author 9840
 * @date  2019-3-39
 */
@Slf4j
@Component
public class FileUpload {


    @Autowired
    private  FtpClient  client;


    /**
	 * 保存到ftp
	 * @param is 文件输入流
	 * @param type 储存的文件类
	 * @return 文件在ftp 服务器的完整路径
	 */
	public  String saveDataToFtp(InputStream is,String type) {
        final String fileName = createFileName();
        final String filePath = createFilePath(type);
        client.uploadUrlFile(is,filePath,fileName);
		return client.getPath(filePath,fileName);
	}



	@Getter
	public enum Path{
        ggtt_root("/ggtt/"),
	    user_head("/ggtt/user/head/"),
	    teacher_head("/ggtt/teacher/head/"),
        teacher_fx("/ggtt/teacher/fx/"),
        teacher_bg("/ggtt/teacher/gb/");
	    private String val;
        Path(String val) {
            this.val= val;
        }
    }


    /**
     * 获取文件路径
     * @return 文件夹路径
     */
    private static String createFilePath(String type){
        Boolean cut = false;
        if(type.equals(Path.user_head.toString())){
            return createFilePath(cut,Path.user_head.val);
        }
        if(type.equals(Path.teacher_head.toString())){
            return createFilePath(cut,Path.teacher_head.val);
        }
        if(type.equals(Path.teacher_fx.toString())){
            return createFilePath(cut,Path.teacher_fx.val);
        }
        if(type.equals(Path.teacher_bg.toString())){
            return createFilePath(cut,Path.teacher_bg.val);
        }
        return createFilePath(cut,Path.ggtt_root.val);
    }
	/**
	 * 获取文件路径
	 * @param cut 日期分割
     *              true :2019/3/39
     *              false:2019339
	 * @return 文件夹路径
	 */
    private static String createFilePath(Boolean cut,String path){
		Calendar c = Calendar.getInstance();
		if(cut){
			return path+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+ "/"+c.get(Calendar.DATE);
		}
		return path+c.get(Calendar.YEAR)+""+(c.get(Calendar.MONTH)+1)+ ""+c.get(Calendar.DATE);
	}

	/**
	 * 获取文件名字
	 * @return 文件名
	 */
    private static String createFileName(){
        return Long.toString(Calendar.getInstance().getTime().getTime());
	}

    /**
     *通过get请求得到读取器响应数据的数据流
     * @param url 网页图片的url
     * @return 图片的 inputStream
     */
    public static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                    .openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将服务器响应的数据流存到本地文件
     * @param is 需要保存的文件的 inputStrem
     * @param file 本地文件路径
     */
    public static void saveData(InputStream is, File file) {
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
