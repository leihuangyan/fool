package com.cz.task.restul.domain;

import com.cz.task.restul.annotaction.IsParam;
import com.cz.task.restul.domain.base.BaseSignObj;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @name: RefundTicketApplyReqestParam
 * @author： LHY
 * @classPath: com.cz.task.restul.domain.RefundTicketApplyReqestParam
 * @date: 2020/2/4 14:16
 * @Version: 1.0
 * @description: 退票请求参数
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundTicketApplyRequestParam extends BaseSignObj {

    /**
     *分销商用户名
     */
    @XmlElement(name = "Consumer")
    private String consumer;
    /**
     *订单号
     */
    @XmlElement(name = "OrderID")
    private String orderId;

    /**
     *废票乘机人信息
     */
    @IsParam("Passenger=")
    @XmlElementWrapper(name = "PassengerList")
    @XmlElement(name = "Passenger")
    private List<Passenger> passengerList;
    /**
     *退票原因
     */
    @XmlElement(name = "Reason")
    private String reason;
    /**
     *退票说明
     */
    @XmlElement(name = "Remark")
    private String remark;
    /**
     *外部订单号(有就必填，没有就不填)
     */
    @XmlElement(name = "OutOrderID")
    private String outOrderId;
    /**
     *退票航班组
     */
    @IsParam("TRFlightList=")
    @XmlElementWrapper(name = "TRFlightList")
    @XmlElement(name = "TRFlightList")
    private List<TRFlightList> trFlightList;
}
