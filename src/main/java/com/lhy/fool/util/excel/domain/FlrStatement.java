package com.lhy.fool.util.excel.domain;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Data
public class FlrStatement implements Serializable{

    /**
	 * @field：serialVersionUID
	 * @description：
	 * @author：T26974
	 * @date：2019年6月21日 上午9:33:04
	 */
	private static final long serialVersionUID = -8835057391554523563L;


	/**
     * 唯一ID
     */
    private String fid;

    /**
     * 【子公司名称】部门映射的成本中心对应的子公司
     */
    private String subsidiary;

    /**
     * 账期】话单对应的月份
     */
    private String paymentday;

    /**
     "【预算项目】【固定电话费】
     */
    private String budgetitem ;

    /**
     "【报账总金额】通服费总金额+装维费总金额+其他费用总金额
     */
    private BigDecimal reimbursetotalamount;

    /**
     *【账单状态】 1:已保存 2:已审核 3：待确认 4 ：已确认
     */
    private Integer billstatus;



	//设置导出list类
	public List<Object> toExportList(String xx,String xx1) {
		// 定义导出字段集合
		List<Object> list = new ArrayList<Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 单据编号
		list.add(fid);
		// 子公司
		list.add(subsidiary);
		return list;
	}

}
