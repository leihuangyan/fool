package com.lhy.fool;

import com.lhy.fool.util.enrypt.annotation.EnabledEncrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 98403
 */
@EnableTransactionManagement
@EnabledEncrypt
@EnableAutoConfiguration
@SpringBootApplication
public class FoolApplication  extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(FoolApplication.class, args);
    }

    //@Override
    //protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //    return builder.sources(FoolApplication.class);
    //}



}
