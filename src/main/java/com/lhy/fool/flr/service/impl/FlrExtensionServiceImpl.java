package com.lhy.fool.flr.service.impl;

import com.lhy.fool.flr.entity.FlrExtension;
import com.lhy.fool.flr.mapper.FlrExtensionMapper;
import com.lhy.fool.flr.service.IFlrExtensionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class FlrExtensionServiceImpl extends ServiceImpl<FlrExtensionMapper, FlrExtension> implements IFlrExtensionService {

    @Autowired
    private  FlrExtensionMapper flrExtensionMapper;

    @Override
    public Integer insertOne(FlrExtension flrExtension) {
        return flrExtensionMapper.insertOne(flrExtension);
    }

    @Override
    public Integer insertArray(List<FlrExtension> flrExtensions) {
        return flrExtensionMapper.insertArray(flrExtensions);
    }

    @Override
    public Integer deleteLogicById(String fid) {
        return flrExtensionMapper.deleteLogicById(fid);
    }

    @Override
    public Integer deleteLogicByIds(List<String> ids) {
        return flrExtensionMapper.deleteLogicByIds(ids);
    }

    @Override
    public Integer deleteById(String fid) {
        return flrExtensionMapper.deleteById(fid);
    }

    @Override
    public Integer deleteByIds(List<String> ids) {
        return flrExtensionMapper.deleteByIds(ids);
    }

}
