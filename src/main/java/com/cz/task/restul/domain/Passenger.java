package com.cz.task.restul.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * @name: Passenger
 * @author： LHY
 * @classPath: com.cz.task.restul.domain.Passenger
 * @date: 2020/2/4 14:18
 * @Version: 1.0
 * @description: 乘客信息
 */
@Data
@XmlRootElement(name = "Passenger")
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger {

    /**
     * 乘客名称
     */
    @XmlElement(name = "Name")
    private String name;
    /**
     * 乘机人类型
     */
    @XmlElement(name = "PassengerType")
    private String passengerType;
    /**
     *证件号
     */
    @XmlElement(name = "IDCard")
    private String idCard;
    /**
     *票号
     */
    @XmlElement(name = "TicketNo")
    private String ticketNo;
    /**
     *行程单遗失费用
     */
    @XmlElement(name = "LoseInvoice")
    private BigDecimal loseInvoice;
}
