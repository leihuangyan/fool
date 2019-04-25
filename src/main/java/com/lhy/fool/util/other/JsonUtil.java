package com.lhy.fool.util.other;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 98403
 */
@Slf4j
public class JsonUtil {
    private final  static ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * response 直接返回 jsonObject
     * @param obj 预处理对象
     * @param response  response
     */
    public static void convertJSONObject(Object obj, HttpServletResponse response) {
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            MAPPER.writeValue(response.getOutputStream(), obj);
        } catch (JsonProcessingException e) {
            log.error("Json处理错误", e);
        } catch (Exception e) {
            log.error("Json处理错误", e);
        }
    }

    /**
     * response 直接返回 jsonObject
     * @param obj 预处理对象
     * @param response  response
     */
    public static void convertJSONObject(Object obj, HttpServletResponse response, Boolean isAll) {
        try {
            if(null!=isAll&&isAll){
                MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
            }else {
                MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            }
            MAPPER.writeValue(response.getOutputStream(), obj);
        } catch (JsonProcessingException e) {
            log.error("Json处理错误", e);
        } catch (Exception e) {
            log.error("Json处理错误", e);
        }
    }


    /**
     * 返回json 字符串
     * @param obj 预处理对象
     * @return 处理完毕的Json字符
     */
    public static String convertJSON (Object obj) {
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Json处理错误", e);
        }
        return null;
    }

    /**
     * 返回json 字符串
     * @param obj 预处理对象
     * @param isAll  是否序列化空值
     * @return 处理完毕的Json字符
     */
    public static String convertJSON (Object obj,Boolean isAll) {
        try {
            if(null!=isAll&&isAll){
                MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
            }else {
                MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            }
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Json处理错误", e);
        }
        return null;
    }



}
