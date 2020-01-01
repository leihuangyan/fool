package com.lhy.fool;

import com.lhy.fool.util.enrypt.annotation.EnabledEncrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 111
 * @author 98403
 */
@EnableTransactionManagement
@EnabledEncrypt
@SpringBootApplication
public class FoolApplication  extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(FoolApplication.class, args);
    }

}
