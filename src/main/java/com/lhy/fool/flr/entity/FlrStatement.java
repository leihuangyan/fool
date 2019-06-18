package com.lhy.fool.flr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@TableName("T_FLR_STATEMENT")
public class FlrStatement extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
    @TableId("FID")
    private String fid;


    /**
     * 【子公司名称】部门映射的成本中心对应的子公司
     */
    @TableField("SUBSIDIARY")
    private String subsidiary;

    /**
     * 账期】话单对应的月份
     */
    @TableField("PAYMENTDAY")
    private Date paymentday;

    /**
     "【预算项目】【固定电话费】
     */
    @TableField("BUDGETITEM")
    private String budgetitem;

    /**
     "【通话费总金额】号码费+实际通话费+需摊销金额的汇总额
     */
    @TableField("CALLTOTALAMOUNT")
    private Double calltotalamount;

    /**
     * 【装维费总金额】线路费汇总
     */
    @TableField("INSTALLTOTALAMOUNT")
    private Double installtotalamount;

    /**
     *【其他费用总金额】其他费用汇总
     */
    @TableField("OTHERTOTALAMOUNT")
    private Double othertotalamount;

    /**
     "【报账总金额】通服费总金额+装维费总金额+其他费用总金额
     */
    @TableField("REIMBURSETOTALAMOUNT")
    private Double reimbursetotalamount;

    /**
     *【账单状态】 1:已保存 2:已审核 3：待确认 4 ：已确认
     */
    @TableField("BILLSTATUS")
    private Integer billstatus;

    /**
     *【报账状态】 1；已提交 2 ：不同意 3 :已同意
     */
    @TableField("REIMBURSSTATUS")
    private Integer reimbursstatus;

    /**
     *【预提状态】1：未预提  2：已预提
     */
    @TableField("WITHHOLDINGSTATUS")
    private Integer withholdingstatus;


    /**
     *【报销时效是否超时】报销时效是否超时  1：是 ;2 ：否
     */
    @TableField("ISREIMBURSEOVERTIME")
    private Integer isreimburseovertime;

    /**
     *【所属财务部】所属财务部
     */
    @TableField("FINANCIALDEPARTMENT")
    private String financialdepartment;

    /**
     *【工作流名称】报账单工作流名称
     */
    @TableField("WORKFLOWNAME")
    private String workflowname;


    /**
     *【发票抬头】
     */
    @TableField("INVOICETITLE")
    private String invoicetitle;


    /**
     * 一对多对账单项
     */
    private List<FlrStatementitem> items;
}
