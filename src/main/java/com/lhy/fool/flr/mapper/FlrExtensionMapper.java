package com.lhy.fool.flr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhy.fool.flr.entity.FlrExtension;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分机
 *  Mapper 接口
 * @author lhy
 * @since 2019-06-17
 */
public interface FlrExtensionMapper extends BaseMapper<FlrExtension> {


    /**
     *  新增分机数据
     * @param flrExtensions 分机
     * @return 成功列数
     */
    Integer insertOne(FlrExtension flrExtensions);

    /**
     *  新增一批分机数据
     * @param flrExtensions 分机(条件)
     * @return 成功列数
     */
    Integer insertArray(List<FlrExtension> flrExtensions);


    /**
     * 删除分机数据（逻辑）
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteLogicById(@Param("fid") String fid);

    /**
     * 批量删除分机数据（逻辑）
     * @param ids FIDs
     * @return 成功列数
     */
    Integer deleteLogicByIds(@Param("ids") List<String> ids);

    /**
     * 删除分机数据
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteById(@Param("fid") String fid);


    /**
     * 批量删除分机数据
     * @param ids FID
     * @return 成功列数
     */
    Integer deleteByIds(@Param("ids") List<String> ids);
}
