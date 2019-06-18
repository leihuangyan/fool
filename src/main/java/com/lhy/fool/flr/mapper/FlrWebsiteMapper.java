package com.lhy.fool.flr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhy.fool.flr.entity.FlrWebsite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *     网点
 *  Mapper 接口
 * </p>
 *
 * @author lhy
 * @since 2019-06-17
 */
public interface FlrWebsiteMapper extends BaseMapper<FlrWebsite> {

    /**
     *  新增网点数据
     * @param flrWebsite 网点(条件)
     * @return 成功列数
     */
    Integer insertOne(FlrWebsite flrWebsite);

    /**
     *  新增一批网点数据
     * @param flrWebsite 网点(条件)
     * @return 成功列数
     */
    Integer insertArray(List<FlrWebsite> flrWebsite);



    /**
     * 删除网点数据（逻辑）
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteLogicById(@Param("fid") String fid);

    /**
     * 批量删除网点数据（逻辑）
     * @param ids FIDs
     * @return 成功列数
     */
    Integer deleteLogicByIds(@Param("ids") List<String> ids);

    /**
     * 删除网点数据
     * @param fid FID
     * @return 成功列数
     */
    Integer deleteById(@Param("fid") String fid);


    /**
     * 批量删除网点数据
     * @param ids FID
     * @return 成功列数
     */
    Integer deleteByIds(@Param("ids") List<String> ids);


}
