package com.cz.task.restul.domain;

import com.cz.task.restul.annotaction.IgnoreSign;
import com.cz.task.restul.domain.base.BaseRequestParam;
import com.cz.task.restul.domain.base.BaseSignObj;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * @name: OrderRefund
 * @author： LHY
 * @classPath: com.cz.task.restul.domain.OrderRefund
 * @date: 2020/2/4 12:35
 * @Version: 1.0
 * @description: 请求主体
 */
@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "partner",
        "action",
        "requestFmt",
        "responseFmt",
        "signType",
        "sign",
        "version",
        "param"
})
public class RequestParam extends BaseSignObj implements Serializable {

    /**
     * 合作 ID
     */
    @XmlElement(name = "Partner")
    private String partner;
    /**
     * 业务动作
     */
    @XmlElement(name = "Action")
    private String action;
    /**c
     * 请求参数格式,只支持 XML
     */
    @XmlElement(name = "RequestFmt")
    private String requestFmt;
    /**
     * 返回参数格式,只支持 XML
     */
    @XmlElement(name = "ResponseFmt")
    private String responseFmt;
    /**
     * 参数签名方式,只支持 MD5
     */
    @IgnoreSign
    @XmlElement(name = "SignType")
    private String signType;
    /**
     * 业务参数签名结果
     */
    @IgnoreSign
    @XmlElement(name = "Sign")
    private String sign;
    /**
     * 版本
     */
    @XmlElement(name = "Version")
    private String version;
    /**
     * 业务参数
     */
    @IgnoreSign
    @XmlElement(name = "Param")
    private List<BaseRequestParam> param;

}
