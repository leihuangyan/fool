package com.cz.task.restul.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @name: PassengerType
 * @author： LHY
 * @classPath: com.cz.task.restul.enums.PassengerType
 * @date: 2020/2/4 15:08
 * @Version: 1.0
 * @description: 乘机人类型枚举
 */
@AllArgsConstructor
@Getter
public enum PassengerTypeEnum {
    /**
     *
     */
    ADU("成人"),
    CHD("儿童"),
    INF("婴儿"),
    SD("留学生"),
    SC("海员"),
    DR("博士"),
    DL("劳工"),
    ZZ("青年"),
    CD("老人");

    String val;
}
