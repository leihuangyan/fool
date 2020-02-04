package com.cz.task.restul.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @name: MessageModel
 * @author： LHY
 * @classPath: com.cz.task.restul.domain.MessageModel
 * @date: 2020/2/4 14:22
 * @Version: 1.0
 * @description: 消息model
 */
@Data
@XmlRootElement(name = "MessageModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageModel {
    /**
     * 编码
     */
    @XmlElement(name = "MessageCode")
    private String  messageCode;
    /**
     * 详情
     */
    @XmlElement(name = "Desciption")
    private String description;
}
