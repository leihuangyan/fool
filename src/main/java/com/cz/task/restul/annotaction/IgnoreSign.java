package com.cz.task.restul.annotaction;

import java.lang.annotation.*;


/**
 * @name: ExcelField
 * @author: LHY
 * @classPath: com.deppon.module.transfer.service.util.excel.annotaction.ExcelField
 * @date: 2019-11-19 9:25
 * @Version: 1.0
 * @description: 是否签名
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSign {

    boolean status() default true;
}
