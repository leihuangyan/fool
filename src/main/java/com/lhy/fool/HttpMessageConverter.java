package com.lhy.fool;

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
}
