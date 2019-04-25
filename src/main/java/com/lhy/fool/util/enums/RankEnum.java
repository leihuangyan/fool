package com.lhy.fool.util.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 *@author 98403
 * @Date: 2019-04-02 14:48
 * @Description:
 */

@Getter
public enum RankEnum implements IEnum {
    GOLD(1, "xxx");

    private String desc;

    RankEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;

    @Override
    public Serializable getValue() {
        return this.code;
    }
}
