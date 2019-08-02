package com.lhy.fool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author 98403
 */
@Configuration
public class DefaultView  implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/p1").setViewName("p1");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}


