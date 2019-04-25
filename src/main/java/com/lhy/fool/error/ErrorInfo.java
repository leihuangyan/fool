package com.lhy.fool.error;

import lombok.Data;

/**
 * @author 98403
 */
@Data
public class ErrorInfo {
    /**
     * 错误类别码
     */
    public Integer code;
    /**
     * 错误信息
     */
    public String msg;
    /**
     * 映射路径
     */
    public String url;

}