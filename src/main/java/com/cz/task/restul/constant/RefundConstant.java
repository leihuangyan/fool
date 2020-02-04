package com.cz.task.restul.constant;

/**
 * @name: RefundConstant
 * @author： LHY
 * @classPath: com.cz.task.restul.constant.RefundConstant
 * @date: 2020/2/4 12:47
 * @Version: 1.0
 * @description: 常量
 */
public class RefundConstant {

    /**
     * 合作 ID
     */
    public  final static String PARTNER = "NB111";
    /**c
     * 请求参数格式,只支持 XML
     */
    public  final static String REQUEST_FMT = "XML";
    /**
     * 返回参数格式,只支持 XML
     */
    public  final static String RESPONSE_FMT = "XML";
    /**
     * 签名方式
     */
    public  final static String SIGN_TYPE = "MD5";
    /**
     * 版本
     */
    public  final static String VERSION = "1.0.0";

    /**
     * 退票接口
     */
    public  final static String ORDER_REFUND = "http://testiapi.jinri.net:6012/Api/OrderRefund.ashx";

    /**
     * 附件上传接口
     */
    public  final static String FILE_UPLOAD_REFUND = "http://testiapi.jinri.net:6012/Api/OrderRefund.ashx";
}

