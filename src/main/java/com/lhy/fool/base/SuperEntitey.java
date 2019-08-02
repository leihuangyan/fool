package com.lhy.fool.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @name: SuperEntitey
 * @author： 98403
 * @classPath: com.lhy.fool.base.SuperEntitey
 * @date: 2019-08-02 14:58
 * @Version: 1.0
 * @description: TODO
 */
@Data
public class SuperEntitey<T> implements Serializable {

    private static final long serialVersionUID = 3795273066087855203L;

    @TableField("createDate")
    private LocalDateTime createDate;

    @TableField("createCode")
    private String createCode;

    @TableField("updateDate")
    private LocalDateTime updateDate;

    @TableField("updateCode")
    private String updateCode;

    @TableField("status")
    @TableLogic
    private Integer status;
}
