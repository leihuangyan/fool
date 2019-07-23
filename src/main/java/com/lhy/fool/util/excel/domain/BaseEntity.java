package com.lhy.fool.util.excel.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @title: BaseEntity
 * @author: 98403
 * @classPath: com.lhy.fool.util.excel.domain.BaseEntity
 * @date: 2019-07-21 22:36
 * @Version: 1.0
 * @description: TODO
 */
@Data
public class BaseEntity implements Serializable {

    /**
     *创建人】
     */
    protected String createusercode;

    /**
     *【创建时间】
     */
    protected Date createtime;

    /**
     *【最后修改人】
     */
    protected String modifyusercode;

    /**
     * 【最后修改时间】
     */
    protected Date modifytime;
}
