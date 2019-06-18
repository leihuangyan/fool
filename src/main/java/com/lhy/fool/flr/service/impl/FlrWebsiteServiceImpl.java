package com.lhy.fool.flr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.fool.flr.entity.FlrWebsite;
import com.lhy.fool.flr.mapper.FlrWebsiteMapper;
import com.lhy.fool.flr.service.IFlrWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhy
 * @since 2019-06-17
 */
@Service
public class FlrWebsiteServiceImpl extends ServiceImpl<FlrWebsiteMapper, FlrWebsite> implements IFlrWebsiteService {


    @Autowired
    private FlrWebsiteMapper flrWebsiteMapper;

    @Override
    public Integer insertOne(FlrWebsite flrWebsite) {
        return flrWebsiteMapper.insertOne(flrWebsite);
    }

    @Override
    public Integer insertArray(List<FlrWebsite> flrWebsite) {
        return flrWebsiteMapper.insertArray(flrWebsite);
    }

    @Override
    public Integer deleteLogicById(String fid) {
        return flrWebsiteMapper.deleteLogicById(fid);
    }

    @Override
    public Integer deleteLogicByIds(List<String> ids) {
        return flrWebsiteMapper.deleteLogicByIds(ids);
    }

    @Override
    public Integer deleteById(String fid) {
        return flrWebsiteMapper.deleteById(fid);
    }

    @Override
    public Integer deleteByIds(List<String> ids) {
        return flrWebsiteMapper.deleteByIds(ids);
    }

}
