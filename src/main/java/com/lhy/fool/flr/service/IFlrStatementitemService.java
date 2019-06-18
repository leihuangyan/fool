package com.lhy.fool.flr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhy.fool.flr.entity.FlrStatementitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhy
 * @since 2019-06-17
 */
public interface IFlrStatementitemService extends IService<FlrStatementitem> {


    /**
     * 根据不同条件查询对账单项明细 (分页)
     * @param page 分页对象
     * @param flrStatementitem 对账单项 (查询条件ID ，部门，成本中心,外线号码)
     * @return 对账单项集合
     */
    List<FlrStatementitem> listByCondition(IPage<FlrStatementitem> page, FlrStatementitem flrStatementitem);

    /**
     * 查询所有对账单项（导出）
     * @param flrStatementitem 对账单项 (查询条件ID ，部门，成本中心,外线号码)
     * @return 对账单项集合
     */
    List<FlrStatementitem> listAll(FlrStatementitem flrStatementitem);

    /**
     *  查询一个对账单项
     * @param fid  FID
     * @return 对账单项
     */
    FlrStatementitem selectById(String fid);



    /**
     *  新增一个对账单项
     * @param flrStatementitem 对账单项(条件)
     * @return 成功列数
     */
    Integer insertOne(FlrStatementitem flrStatementitem);

    /**
     *  新增一批对账单项
     * @param list 对账单项(条件)
     * @return 成功列数
     */
    Integer insertArray(List<FlrStatementitem> list);


    /**
     *  修改对账单项备注
     * @param flrStatementitem 对账单项(FID 备注)必填
     * @return 成功列数
     */
    Integer updateRemarks(FlrStatementitem flrStatementitem);


    /**
     * 删除对账单项
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteById(@Param("fid") String fid);


    /**
     * 批量删除对账单项
     * @param ids FID
     * @return 成功列数
     */
    Integer deleteByIds(@Param("ids") List<String> ids);

    /**
     * 删除对账单项（逻辑）
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteLogicById(@Param("fid") String fid);

    /**
     * 批量删除对账单项（逻辑）
     * @param ids FIDs
     * @return 成功列数
     */
    Integer deleteLogicByIds(@Param("ids") List<String> ids);
}
