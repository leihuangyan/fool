package com.lhy.fool.util.ftp;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

/**
 * @author lhy
 */

@Data
@Slf4j
@Component
public class FtpClient {

	@Value("${ftp.host}")
	private String host;

	@Value("${ftp.port}")
	private  Integer port;

	@Value("${ftp.ftpPort}")
	private  Integer ftpPort;

	@Value("${ftp.username}")
	private  String username;

	@Value("${ftp.password}")
	private  String password;

	@Value("${ftp.rootPath}")
	private  String rootPath;


	/**
	 * 得到 FTPClient
	 * @return FTPClient对象
	 */
	private  FTPClient getFTPClient() {
		try {
			FTPClient client = new FTPClient();
			client.setDataTimeout(1000*120);
			// 连接
			client.connect(host, port);
			//被动本地连接模式
			client.enterLocalPassiveMode();
			// 登录
			client.login(username, password);
			if (!FTPReply.isPositiveCompletion(client.getReplyCode())) {
				client.disconnect();
			} else {
				return client;
			}
		} catch (SocketException e) {
			log.error(e.toString());
		} catch (IOException e) {
			log.error(e.toString());
		}
		return null;
	}


	/**
	 *  ftp 文件下载
	 * @param remoteFilePath ftp 路劲
	 * @param localDir 本地路径
	 */
	public  void downloadFile(String remoteFilePath, String localDir) {
		if (StringUtils.hasText(rootPath)) {
			remoteFilePath = rootPath + remoteFilePath;
		}
		FileOutputStream fos = null;
		//进行连接
		FTPClient client = getFTPClient();
		try {
			//保存到本地的路径
			File localFile = new File(localDir);
			fos = new FileOutputStream(localFile);
			client.setBufferSize(1024);
			// 设置文件类型（二进制）
			client.setControlEncoding("UTF-8"); 
			client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			//remoteFileName 检索的路劲		通过 fos 检索到本地
			client.retrieveFile(remoteFilePath, fos);
			client.logout();
            log.debug("【FTP文件】:"+ localFile.getName() + "下载成功");
		} catch (IOException e) {
			log.error("【FTP文件下载】=======IOException:");
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					log.error("【FTP文件下载】=======IOException:");
				}
			}
			closeCoon(client);
		}
	}


	/**
	 * ftp 文件上传
	 * @param is 文件流
	 * @param ftpPath  上传到的FTP路径
	 * @param fileName 文件名字
	 */
	public   void uploadUrlFile(InputStream is,String ftpPath,String fileName) {
		if (StringUtils.hasText(rootPath)) {
			rootPath = rootPath + ftpPath;
		}
		//进行连接
		FTPClient client = getFTPClient();
		try {
			// 设置编码
			client.setControlEncoding("UTF-8");
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			//判断传入路径是否存在
			boolean exist = client.changeWorkingDirectory(rootPath);
			if (!exist) {
				String[] pah = ftpPath.split("/");
				for (String pa : pah) {
					client.makeDirectory(pa);
					client.changeWorkingDirectory(pa);
				}
			}
			//fileName:保存的文件名
			//is :要上传的源文件 流
			client.storeFile(fileName, is);
		} catch (Exception e) {
			log.error("【FTP文件上传】=======:"+e.toString());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				log.error("【关闭流失败】=======IOException");
			}
			closeCoon(client);
		}
	}


	/**
	 * 关闭连接
	 * @param ftpClient ftpClient
	 */
	private static void closeCoon(FTPClient ftpClient){
        if(null!=ftpClient){
			if(ftpClient.isConnected()){
				try {
					ftpClient.logout();
					ftpClient.disconnect();
				} catch (Exception e) {
                    log.error("【FTP关闭流】"+e.toString());
				}
			}
		}
	}


	/**
	 * 得到ftp路径
	 * @param ftpPath ftp路径
	 * @param fileName 文件名字
	 * @return 完整ftp路径
	 */
	public  String getPath(String ftpPath,String fileName){
		return "http://"+host+":"+ftpPort+ftpPath+"/"+fileName;
	}



}