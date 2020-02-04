package com.cz.task.restul.service;

import com.cz.task.restul.domain.base.BaseSignObj;

import java.util.Map;

/**
 * @name: SignService
 * @author： LHY
 * @classPath: com.cz.task.restul.service.SignService
 * @date: 2020/2/4 12:30
 * @Version: 1.0
 * @description: TODO
 */
public interface ISignService {

    /**
     * 签名
     * @param signStr 签名字符
     * @return  成功状态
     */
    String sign(String signStr);


    /**
     * 解析参数
     * @param signObj 签名对象
     * @return str
     */
    String analysisParam(BaseSignObj signObj);

    /**
     * 排序
     * @param map map
     * @return str
     */
    String concatSignString(Map<String, String> map);

    /**
     * 请求签名
     * @param signObj 签名对象
     * @return MD5加密后字符
     */
    String requestSign(BaseSignObj signObj);
}
