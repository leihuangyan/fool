package com.lhy.fool.sys.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lhy.fool.base.SuperEntitey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhy
 * @since 2019-08-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_dict")
public class Dict2 extends SuperEntitey {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("item")
    private String item;

    @TableField("val")
    private String val;

    @TableField("orderNum")
    private Integer orderNum;

    @TableField("remake")
    private String remake;

    @TableField("parentId")
    private Long parentId;

    @TableField("icon")
    private String icon;

    @TableField("level")
    private Integer level;

    @TableField("itemClass")
    private String itemClass;

    @TableField("itemClass")
    private String itemClass2;


}
