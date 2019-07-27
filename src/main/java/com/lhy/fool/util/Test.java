package com.lhy.fool.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @name: Test
 * @author： 98403
 * @classPath: com.lhy.fool.util.Test
 * @date: 2019-07-25 14:50
 * @Version: 1.0
 * @description: TODO
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        String url ="https://yfapi.mygzb.com:9212/gzbbz/lsp/fs/upload";
       //  url = "https://free-api.heweather.com/v5/forecast?city=CN101080101&key=5c043b56de9f4371b0c7f8bee8f5b75e";
        //封装请求参数
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap();
        paramMap.set("sign", "sing");
        paramMap.set("data","{aa:bb}");
        paramMap.set("op", "{aa:bb}");
        paramMap.set("partner_key", "deppon_lsp");
        Object responseEntity = restTemplate.postForObject(url, paramMap, Object.class);
        log.info("结果：{}",responseEntity.toString());
    }

}
