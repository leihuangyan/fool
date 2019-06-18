package com.lhy.fool.flr.enums;

/**
 * @author 98403
 * @date: 2019-06-17 16:45
 */
public enum  StatementStatus {
    /**
     * 已保存
     */
    SAVE(1),

    /**
     * 已审核
     */
    AUDIT(2),

    /**
     * 待确认
     */
    TO_CONFIRM(3),

    /**
     * 已确认
     */
    CONFIRMED(4),

    /**
     * 已提交
     */
    SUBMIT(1),

    /**
     * 不同意
     */
    DISAGREE(2),

    /**
     * 已同意
     */
    AGREE(3),
    /**
     * 未预提
     */
    NOT_WITHHOLDING(1),
    /**
     * 已预提
     */
    IS_WITHHOLDING(2),
    /**
     * 超时
     */
    TIMEOUT(1),
    /**
     * 未超时
     */
    NOT_TIMEOUT(2);

    private  Integer code;

    StatementStatus(Integer code) {
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }


}
