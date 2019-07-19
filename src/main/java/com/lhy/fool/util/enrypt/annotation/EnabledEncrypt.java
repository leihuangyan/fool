package com.lhy.fool.util.enrypt.annotation;


import com.lhy.fool.util.enrypt.EncryptService;
import com.lhy.fool.util.enrypt.config.EncryptConfiguration;
import com.lhy.fool.util.enrypt.config.EncryptProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {EncryptConfiguration.class, EncryptProperties.class, EncryptService.class})
public @interface EnabledEncrypt {
}
