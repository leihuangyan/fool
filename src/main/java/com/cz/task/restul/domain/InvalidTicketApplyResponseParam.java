package com.cz.task.restul.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @name: InvalidTicketApplyResponseParam
 * @author： LHY
 * @classPath: com.cz.task.restul.domain.InvalidTicketApplyResponseParam
 * @date: 2020/2/4 14:21
 * @Version: 1.0
 * @description: 退票返回信息
 */
@Data
@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvalidTicketApplyResponseParam {


    /**
     * 分销商用户名d
     */
    @XmlElement(name = "OrderID")
    private String orderId;
    /**
     * 返回处理信息
     */
    @XmlElement(name = "MessageModel")
    private MessageModel messageModel;
}
