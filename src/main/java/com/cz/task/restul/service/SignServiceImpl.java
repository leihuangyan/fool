package com.cz.task.restul.service;

import com.cz.task.restul.annotaction.IgnoreSign;
import com.cz.task.restul.annotaction.IsParam;
import com.cz.task.restul.domain.base.BaseSignObj;
import com.cz.task.restul.util.MD5Utils;
import com.cz.task.restul.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;

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
        StringBuilder sb = new StringBuilder();
        //得到当前类class
        final Class<? extends BaseSignObj> signClass = signObj.getClass();
        //得到所有属性
        final Field[] fields = ReflectUtil.getFields(signClass);
        //初始化map接受参数
        HashMap<String, String> hashMap = new HashMap<>(fields.length);
        //遍历
        for (Field field : fields) {
            //得到属性注解 是否忽略，是否是param
            IgnoreSign ignoreSignAnnotation = field.getAnnotation(IgnoreSign.class);
            IsParam isParamAnnotation = field.getAnnotation(IsParam.class);
            //判空
            if(null!=isParamAnnotation){
                //得到param属性值
                Object fieldValue = ReflectUtil.getFieldValue(signObj, field);
                //为空跳过
                if(null==fieldValue){
                    continue;
                }
                //注：所有被的@IsParam均要继承BaseSignObj ，此处可做强校验优化，当前测试用例不做处理
                //强转
                List<BaseSignObj> obj = (List<BaseSignObj>)fieldValue;
                for (BaseSignObj baseSignObj : obj) {
                    //递归拼接被@IsParam注解对象所转换的字符串
                    sb.append("&").append(isParamAnnotation.value()).append(analysisParam(baseSignObj));
                }
                //@IsParam注解对象已经在递归中处理了，continue 防止重复处理
                continue;
            }
            //没有忽略注解且状态为true
            if( null!=ignoreSignAnnotation && ignoreSignAnnotation.status()){
                //@IgnoreSign注解属性是忽略属性，直接跳过
                continue;
            }
            //首字母大写
            String keyName = initialCapital(field.getName());
            //得到属性值
            String val = ReflectUtil.getFieldValue(signObj, field).toString();
            //放入map
            hashMap.put(keyName,val);
        }
        String subStr = sb.toString();
        log.info("结束返回:{}",sb.toString());
        //1:按顺序处理字符
        //2:结束时拼接上被@IsParam注解对象所转换的字符串
        return String.format("%s%s",processSignParam(hashMap),subStr);
    }

    @Override
    public String initialCapital(String str) {
        String bodyChar = str.substring(1);
        String firstChar = str.substring(0,1).toUpperCase();
        return firstChar+bodyChar;
    }


    @Override
    public  String processSignParam(Map<String, String> param) {
        Map<String, String> paramMap = new HashMap<>(param.size());
        param.forEach(paramMap::put);
        // 按照key升续排序，然后拼接参数
        Set<String> keySet = paramMap.keySet();
        String[] keyArray = keySet.toArray(new String[0]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (StringUtils.isNotEmpty(sb.toString())) {
                sb.append("&");
            }
            sb.append(k).append("=").append(param.get(k));
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
        String analysisParamStr = analysisParam(signObj);
        log.error("最终签名字符:{}",analysisParamStr);
        return MD5Utils.MD5Encode(analysisParamStr, StandardCharsets.UTF_8.name());
    }



}
