package com.cz.task.restul.domain;

import com.cz.task.restul.domain.base.BaseRequestParam;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @name: UploadFileRequestParam
 * @author： LHY
 * @classPath: com.cz.task.restul.domain.UploadFileRequestParam
 * @date: 2020/2/4 16:32
 * @Version: 1.0
 * @description: 上传附件参数
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class UploadFileRequestParam extends BaseRequestParam {

    /**
     *用户名
     */
    @XmlElement(name = "UserName")
    private String userName;

    /**
     *订单号
     */
    @XmlElement(name = "OrderID")
    private String orderId;

    /**
     * 原始文件名(含扩展名)
     *  支持文件:jpeg,jpg,gif,png
     */
    @XmlElement(name = "OrgFileName")
    private String orgFileName;

    /**
     * 附件类型（1=退废票，2=改期，3=暂时不能附件）
     */
    @XmlElement(name = "TypeId")
    private Integer typeId;

    /**b
     *上传的文件,
     */
    @XmlElement(name = "FileByte")
    private byte [] fileByte;


}
