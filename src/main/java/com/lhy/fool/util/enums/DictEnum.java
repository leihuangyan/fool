package com.lhy.fool.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @name: DictEnum
 * @author： 98403
 * @classPath: com.lhy.fool.util.enums.DictEnum
 * @date: 2019-08-02 16:11
 * @Version: 1.0
 * @description: TODO
 */
@Getter
@AllArgsConstructor
@ToString
public enum DictEnum {
    LEVEL_PARENT(0),
    LEVEL_SELECT(1),
    LEVEL_ITEM(2),
    LEVEL_ITEM_SON(3),
    LEVEL_BUTTON(4);
    private Integer code;

}
