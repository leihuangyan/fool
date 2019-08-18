package com.lhy.fool;

import com.alibaba.fastjson.JSON;
import com.lhy.fool.util.MyNameValuePair;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: HttpMessageConverter
 * @author： 98403
 * @classPath: com.lhy.fool.HttpMessageConverter
 * @date: 2019-07-25 14:54
 * @Version: 1.0
 * @description: TODO
 */
public class HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public HttpMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        //加入text/html类型的支持
        mediaTypes.add(MediaType.TEXT_HTML);
        // tag6
        setSupportedMediaTypes(mediaTypes);
    }

    
    public static void main(String[] args) {

        String str ="[{\"name\":\"sign\",\"value\":\"gD93aAHWxwrMNHu8Z4OcYg4+PiPIrQoRppl/GZ8LYVLPg6iDH/gL4RWJ0b1OrrxxKShZKfnTffoPP8zwj35xlnJ0jspaVk0TIw/KuABG3NnMvyPtB3f6SKUZDD/EK1RKWIENAxiB36hC7Kt16CYSSajhDFvbbg3olUp0x8ktiUs=\"},{\"name\":\"op\",\"value\":\"{\\\"data\\\":\\\"{\\\\\\\"points\\\\\\\":[{\\\\\\\"accountPeriond\\\\\\\":\\\\\\\"201907\\\\\\\",\\\\\\\"pointCodes\\\\\\\":[\\\\\\\"W0000006376\\\\\\\"],\\\\\\\"subsidiary\\\\\\\":\\\\\\\"乌鲁木齐精准德邦物流有限公司\\\\\\\"}],\\\\\\\"extensions\\\\\\\":[{\\\\\\\"extension\\\\\\\":null,\\\\\\\"remark\\\\\\\":\\\\\\\"0.0xxx\\\\\\\",\\\\\\\"accountPeriod\\\\\\\":\\\\\\\"201907\\\\\\\"}]}\\\",\\\"type\\\":\\\"ﬁliale\\\",\\\"serial\\\":1565511199674}\"},{\"name\":\"partner_key\",\"value\":\"deppon_lsp\"},{\"name\":\"audit\",\"value\":\"{\\\"reimbursstatus\\\":null,\\\"withholdingstatus\\\":null,\\\"billstatus\\\":null,\\\"fidArray\\\":[\\\"LSP1565346490942B5625FFAEA\\\"]}\"}]";
        List<MyNameValuePair> parseArray = JSON.parseArray(str, MyNameValuePair.class);
        parseArray.forEach(System.out::println);
    }
}
