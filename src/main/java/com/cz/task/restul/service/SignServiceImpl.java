package com.cz.task.restul.service;

import com.cz.task.restul.annotaction.IgnoreSign;
import com.cz.task.restul.domain.base.BaseSignObj;
import com.cz.task.restul.util.MD5Utils;
import com.cz.task.restul.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @name: SignServiceImpl
 * @author： LHY
 * @classPath: com.cz.task.restul.service.SignServiceImpl
 * @date: 2020/2/4 12:30
 * @Version: 1.0
 * @description: 签名实现
 */
@Slf4j
public class SignServiceImpl implements ISignService {


    @Override
    public String sign(String signStr) {
        return MD5Utils.MD5Encode(signStr, StandardCharsets.UTF_8.name());
    }

    @Override
    public String analysisParam(BaseSignObj signObj) {
        final Class<? extends BaseSignObj> signClass = signObj.getClass();

        final Field[] fields = ReflectUtil.getFields(signClass);

        HashMap<String, String> hashMap = new HashMap<>(fields.length);

        for (Field field : fields) {
            IgnoreSign annotation = field.getAnnotation(IgnoreSign.class);
            //没有忽略注解且状态为true
            if( null!=annotation && annotation.status()){
                continue;
            }
            String name = field.getName();
            String bodyChar = name.substring(1);
            String firstChar = name.substring(0,1).toUpperCase();
            String signKeyName = firstChar+bodyChar;
            String val = ReflectUtil.getFieldValue(signObj, field).toString();
            hashMap.put(signKeyName,val);

            //TODO param暂时未处理 待优化。。。
        }
        String str = concatSignString(hashMap);
        log.info("组合str{}:",str);
        return str;
    }



    @Override
    public  String concatSignString(Map<String, String> map) {
        Map<String, String> paramMap = new HashMap<>(map.size());
        map.forEach(paramMap::put);
        // 按照key升续排序，然后拼接参数
        Set<String> keySet = paramMap.keySet();
        String[] keyArray = keySet.toArray(new String[0]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (StringUtils.isNotEmpty(sb.toString())) {
                sb.append("&");
            }
            sb.append(k).append("=").append(map.get(k));
        }
        return sb.toString();
    }

    /**
     * 请求签名
     * @param signObj 签名对象
     * @return MD5加密后字符
     */
    @Override
    public String requestSign(BaseSignObj signObj){
        return MD5Utils.MD5Encode(analysisParam(signObj), StandardCharsets.UTF_8.name());
    }



}
