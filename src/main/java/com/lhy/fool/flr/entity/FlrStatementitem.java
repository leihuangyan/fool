package com.lhy.fool.flr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("T_FLR_STATEMENTITEM")
public class FlrStatementitem extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *【对账单明细编号】对账单明细唯一标识
     */
    @TableId("FID")
    private String fid;

    /**
     *【对账编号】  外键
     */
    @TableField("STATEMENTNUM")
    private String statementnum;

    /**
     *【预提号】  未预提时为空
     */
    @TableField("WITHHOLDINGNUM")
    private String withholdingnum;

    /**
     *【使用部门】从UUMS内获取的使用部门名称
     */
    @TableField("DEPARTMENT")
    private String department;

    /**
     *【成本中心】部门映射对应的成本中心
     */
    @TableField("COSTCENTER")
    private String costcenter;

    /**
     *【外线号】联通分配的外线号码
     */
    @TableField("OUTSIDELINENUM")
    private String outsidelinenum;

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
     *【需摊销金额】需摊销金额
     */
    @TableField("AMORTIZATIONAMOUNT")
    private Double amortizationamount;

    /**
     *【其他费用】设备损坏/分机费用减免/罚款扣减等
     */
    @TableField("OTHEREXPENSES")
    private Double otherexpenses;

    /**
     *【低消差距】该部门内的总费用距离低消标准的差额
     */
    @TableField("GAP")
    private Double gap;

    /**
     *【备注】
     */
    @TableField("REMARK")
    private String remark;

}
