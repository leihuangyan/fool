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
@TableName("T_FLR_WEBSITE")
public class FlrWebsite extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *网点ID
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
     *【总费用】
     * 线路费+号码费+实际通话费+需摊销金额+不计低消实际通话费+其他费用
     */
    @TableField("TOTALCOST")
    private Double totalcost;

    /**
     *【总线路数】该部门分机号数量
     */
    @TableField("LINENUM")
    private Integer linenum;

    /**
     *【线路费】该部门总线路费
     */
    @TableField("LINECHARGES")
    private Double linecharges;

    /**
     *【号码费】该部门总号码费
     */
    @TableField("NUMCHARGES")
    private Double numcharges;

    /**
     *【实际通话费】该部门总实际通话费
     */
    @TableField("ACTUALCALLCHARGE")
    private Double actualcallcharge;

    /**
     *【低消差距】该部门内的总费用距离低消标准的差额
     */
    @TableField("GAG")
    private Double gag;

    /**
     *【不计低消实际通话费】不计低消实际通话费
     */
    @TableField("UNREALISTICCALLCHARGES")
    private Double unrealisticcallcharges;

    /**
     *【需摊销金额】需摊销金额
     */
    @TableField("AMORTIZATIONAMOUNT")
    private Double amortizationamount;

    /**
     *【其他费用】该部门总其他费用
     */
    @TableField("OTHEREXPENSES")
    private Double otherexpenses;

    /**
     *【费用类型】固定电话费
     */
    @TableField("EXPENSETYPE")
    private String expensetype;

}
