/*
 * 
 */
package com.lhy.fool.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

/**
 * @Title: Guid.java
 * @Package com.deppon.soa.common
 * @Description: TODO(添加描述)
 * @date 2012-10-31 下午2:18:19
 * @version V1.0
 */
public class Guid {
	private static Log logger=LogFactory.getLog(Guid.class);
	//定义字面量常量
	private static final int SIXTEEN=16;

  /**
   * 
   */
  private static Random rd = new Random();

  /**
   * 
   * <pre>
   * 方法体说明：实例化一个新的guid 
   *  作为实体对象的主键
   *  首先是以系统简体名称开始，FSSC
   *  在加入当前时间
   *  然后加入16位随机码
   *  最后生成系统唯一键id
   * 日期：2013-7-26
   * </pre>
   * 
   * @return
   */
  public synchronized static String newDCGuid() {
    // 所属系统名称
    String sysCode = "LSP";
    // 定义id
    String id = "";
    // 记录当前时间 以long类型显示
    String time = System.currentTimeMillis() + "";
    // 如果id为空的话，则生成16位随机码
    if (id.equals("")) {
      id = Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase();
    }
    // 最后通过拼接随机码返回唯一键id
    String rtn = sysCode + time + id;
    return rtn;
  }
  
  public synchronized static String newWFGuid() {
	    // 所属系统名称
	    String sysCode = "DLSP";
	    // 定义id
	    String id = "";
	    // 记录当前时间 以long类型显示
	    String time = System.currentTimeMillis() + "";
	    // 如果id为空的话，则生成16位随机码
	    if (id.equals("")) {
	      id = Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
	          + Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase();
	    }
	    // 最后通过拼接随机码返回唯一键id
	    String rtn = sysCode + time + id;
	    return rtn;
  }
  
 /* public static void main(String[] args){
	  //System.out.println(newWFGuid());
	  //logger.info(newWFGuid());
  }*/
  
  
  
  
}
