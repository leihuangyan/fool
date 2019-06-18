package com.lhy.fool.flr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhy
 * @since 2019-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_FLR_EXTENSION")
public class FlrExtension  extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 佳米平台注册的分机号
     */
    @TableId("FID")
    private String fid;

    /**
     *【使用部门】从UUMS内获取的使用部门名称
     */
    @TableField("DEPARTMENT")
    private String department;


    /**
     *【子公司】部门映射的成本中心对应的子公司
     */
    @TableField("SUBSIDIARY")
    private String subsidiary;

    /**
     *【成本中心】部门映射对应的成本中心
     */
    @TableField("COSTCENTER")
    private String costcenter;

    /**
     *【账期】话单对应的月份
     */
    @TableField("PAYMENTDAY")
    private Date paymentday;

    /**
     *【外线号】联通分配的外线号码
     */
    @TableField("OUTSIDELINENUM")
    private String outsidelinenum;

    /**
     *【分机号】佳米平台注册的分机号
     */
    @TableField("EXTENSIONNUMBER")
    private String extensionnumber;

    /**
     *【开通日期】分机注册使用的时间
     */
    @TableField("OPENINGDATE")
    private Date openingdate;

    /**
     *【是否计低消】根据联通合同规则判断是否计低消
     */
    @TableField("ISOFFSET")
    private Integer isoffset;

    /**
     *【总费用】线路费+号码费+实际通话费+需摊销金额+其他费用
     */
    @TableField("TOTALCOST")
    private Double totalcost;

    /**
     *【线路费】当月25号及之前安装的当月10元/线/月
     */
    @TableField("LINECHARGES")
    private Double linecharges;

    /**
     *【号码费】正常使用的6元/号/月
     */
    @TableField("NUMCHARGES")
    private Double numcharges;

    /**
     *【实际通话费】计费分钟数*0.075元/分钟
     */
    @TableField("ACTUALCALLCHARGE")
    private Double actualcallcharge;

    /**
     *【计费分钟数】由COP平台及佳米记录的实际计费分钟数
     */
    @TableField("MINUTESNUM")
    private Double minutesnum;

    /**
     *【内部通话分钟数】由COP平台及佳米记录的内部通话分钟数（不计费）
     */
    @TableField("INSIDECALLMINUTES")
    private Double insidecallminutes;

    /**
     *【低消差距】该部门内的总费用距离低消标准的差额
     */
    @TableField("GAP")
    private Double gap;

    /**
     *【费用类型】【固定电话费】
     */
    @TableField("EXPENSETYPE")
    private String expensetype;

    /**
     *【其他费用】设备损坏/分机费用减免/罚款扣减等
     */
    @TableField("OTHEREXPENSES")
    private String otherexpenses;

    /**
     *【其他费用备注】其他费用备注
     */
    @TableField("OTHEREXPENSESREMARKS")
    private String otherexpensesremarks;

}
