package com.lhy.fool.util.excel;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 98403
 * @date: 2019-07-20 08:51
 */
public  class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    public WxMappingJackson2HttpMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        mediaTypes.add(MediaType.IMAGE_JPEG);
        setSupportedMediaTypes(mediaTypes);
    }
}
