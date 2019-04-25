package com.lhy.fool.util.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 98403
 * @Date: 2019-03-27 15:32
 * @Description: 继承WebMvcConfigureAdapter继承并重写addInterceptor方法用于添加配置拦截器
 */
@Configuration
public class MyAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/sys/**");
    }
}


