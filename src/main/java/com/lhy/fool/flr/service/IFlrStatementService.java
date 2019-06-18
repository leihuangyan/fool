package com.lhy.fool.flr.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhy.fool.flr.entity.FlrStatement;
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
public interface IFlrStatementService extends IService<FlrStatement> {


    /**
     * 根据条件模糊查询所有对账单 (分页)
     * @param page 分页对象
     * @param flrStatement 对账单(查询条件{单据编号，子公司，账期，单据状态})
     * @return 对账单项集合
     */
    List<FlrStatement> listByCondition(Page<FlrStatement> page, @Param("flrStatement") FlrStatement flrStatement);

    /**
     * 模糊查询所有对账单（导出）
     * @param flrStatement 对账单(查询条件{单据编号，子公司，账期，单据状态})
     * @return 对账单项集合
     */
    List<FlrStatement> listAll(FlrStatement flrStatement);


    /**
     *  查询单个对账单
     * @param fid 对账单ID
     * @return 对账单
     */
    FlrStatement selectById(@Param("fid")String fid);

    /**
     *  查询单个对账单以及他的所有项
     * @param fid 对账单ID
     * @return 对账单
     */
    FlrStatement selectStatementById(@Param("fid")String fid);


    /**
     *  新增一个对账单
     * @param flrStatement 对账单(条件)
     * @return 成功列数
     */
    Integer insertOne(FlrStatement flrStatement);

    /**
     *  新增一批对账单
     * @param list 对账单集合
     * @return 成功列数
     */
    Integer insertArray(List<FlrStatement> list);


    /**
     * 删除对账单（逻辑）
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteLogicById(@Param("fid") String fid);

    /**
     * 批量删除对账单（逻辑）
     * @param ids FIDs
     * @return 成功列数
     */
    Integer deleteLogicByIds(@Param("ids") List<String> ids);

    /**
     * 删除对账单
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteById(@Param("fid") String fid);


    /**
     * 批量删除对账单
     * @param ids FID
     * @return 成功列数
     */
    Integer deleteByIds(@Param("ids") List<String> ids);


    /**
     *  修改对账单
     * @param flrStatement 对账单(财务，抬头)
     * @return 成功列数
     */
    Integer updateByStatement (FlrStatement flrStatement);



}
