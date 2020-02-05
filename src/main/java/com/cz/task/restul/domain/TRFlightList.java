package com.cz.task.restul.domain;

import com.cz.task.restul.domain.base.BaseSignObj;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @name: TRFlightList
 * @author： LHY
 * @classPath: com.cz.task.restul.domain.TRFlightList
 * @date: 2020/2/4 14:20
 * @Version: 1.0
 * @description: 航班信息
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class TRFlightList extends BaseSignObj implements Serializable {


    /**
     *航班号
     */
    @XmlElement(name = "FlightNo")
    private String flightNo;
    /**
     *出发时间
     */
    @XmlElement(name = "DepartTime")
    private String departTime;
}
