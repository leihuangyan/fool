package com.cz.task.restul.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @name: FileTypeEnum
 * @author： LHY
 * @classPath: com.cz.task.restul.enums.FileTypeEnum
 * @date: 2020/2/4 16:37
 * @Version: 1.0
 * @description: 附件类型枚举
 */
@AllArgsConstructor
@Getter
public enum FileTypeEnum {
    /**
     *
     */
    REFUND(1,"退票"),
    RESCHEDULE(2,"改期"),
    CAN_NOT_ANNEX(1,"暂时不能附件");

    Integer code;
    String val;
}

