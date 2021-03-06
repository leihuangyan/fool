package com.cz.task.restul.annotaction;

import java.lang.annotation.*;



/**
 * @name: IgnoreSign
 * @author: LHY
 * @classPath: com.cz.task.restul.annotaction.IgnoreSign
 * @date: 2020/2/5 13:51
 * @Version: 1.0
 * @description: 是否签名
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSign {

    boolean status() default true;
}
