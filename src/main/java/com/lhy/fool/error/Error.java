package com.lhy.fool.error;

import lombok.Getter;

/**
 * @author  98403
 * @Date  2019-03-29 17:12
 * @Description:
 */
@Getter
public enum Error {
    ERROR_NULL_POINTER(101),
    ERROR_NAME_REPEAT(102,"用户名已被占用"),
    ERROR_SERVER_REPEAT(103,"处理出错"),
    ERROR_OTHER(100),
    ERROR_MISSING_SERVLET_REQUEST_PARAMETER(400),
    ERROR_SERVER_ERROR(500),
    ERROR_PAGE_NOT_FOUND(404);
    private int code;
    private String value;

    Error(int code) {
        this.code = code;
    }
    Error(int code,String value) {
        this.code = code;
        this.value = value;
    }
}
