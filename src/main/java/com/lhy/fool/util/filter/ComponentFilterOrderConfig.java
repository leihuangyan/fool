package com.lhy.fool.util.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author 98403
 * @Date: 2019-03-27 14:27
 * @Description:  过滤器配置
 */

@Slf4j
@Configuration
public class ComponentFilterOrderConfig {

    @Bean
    public Filter sessionFilter(){
        return new SessionFilter();
    }

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter());
        //拦截所有APP请求
        registration.addUrlPatterns("/app/*");
        //初始化参数
        //registration.addInitParameter("test", "test");
        //registration.setName("sessionFilter");
        //优先级
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

}
