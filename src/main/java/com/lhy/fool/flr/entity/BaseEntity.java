package com.lhy.fool.flr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author 98403
 * @date: 2019-06-17 19:30
 */
@Data
public class BaseEntity {

    /**
     *创建人】
     */
    @TableField("CREATEUSERCODE")
    protected String createusercode;

    /**
     *【创建时间】
     */
    @TableField("CREATETIME")
    protected Date createtime;

    /**
     *【最后修改人】
     */
    @TableField("MODIFYUSERCODE")
    protected String modifyusercode;

    /**
     * 【最后修改时间】
     */
    @TableField("MODIFYTIME")
    protected Date modifytime;

    /**
     "【逻辑状态】
     */
    @TableField("LOGICSTATE")
    protected Integer logicstate;
}
