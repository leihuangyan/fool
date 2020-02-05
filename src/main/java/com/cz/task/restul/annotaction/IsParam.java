package com.cz.task.restul.annotaction;

import java.lang.annotation.*;



/**
 * @name: IsParam
 * @author: LHY
 * @classPath: com.cz.task.restul.annotaction.IsParam
 * @date: 2020/2/5 13:51
 * @Version: 1.0
 * @description:
 * 是否是参数对象
 * 注：所有被的@IsParam均要继承BaseSignObj
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsParam {

    String value();
}
