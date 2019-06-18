package com.lhy.fool.flr.enums;

/**
 * @author 98403
 * @date: 2019-06-17 19:21
 */
public enum EntityStatus {
    /**
     * 存在
     */
    IS_EXIST(1),
    /**
     * 不存在
     */
    NOT_IS_EXIST(2),
    ;

    private  Integer code;

    EntityStatus(Integer code) {
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }
}
