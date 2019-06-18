package com.lhy.fool.flr.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.fool.flr.entity.FlrStatement;
import com.lhy.fool.flr.mapper.FlrStatementMapper;
import com.lhy.fool.flr.service.IFlrStatementService;
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
public class FlrStatementServiceImpl extends ServiceImpl<FlrStatementMapper, FlrStatement> implements IFlrStatementService {


    @Autowired
    private FlrStatementMapper flrStatementMapper;

    @Override
    public List<FlrStatement> listByCondition(Page<FlrStatement> page, FlrStatement flrStatement) {
        return flrStatementMapper.listByCondition(page,flrStatement);
    }

    @Override
    public List<FlrStatement> listAll(FlrStatement flrStatement) {
        return flrStatementMapper.listAll(flrStatement);
    }


    @Override
    public FlrStatement selectById(String fid) {
        return flrStatementMapper.selectById(fid);
    }

    @Override
    public FlrStatement selectStatementById(String fid) {
        return flrStatementMapper.selectStatementById(fid);
    }

    @Override
    public Integer insertOne(FlrStatement flrStatement) {
        return flrStatementMapper.insertOne(flrStatement);
    }

    @Override
    public Integer insertArray(List<FlrStatement> list) {
        return flrStatementMapper.insertArray(list);
    }

    @Override
    public Integer deleteLogicById(String fid) {
        return flrStatementMapper.deleteLogicById(fid);
    }

    @Override
    public Integer deleteLogicByIds(List<String> ids) {
        return flrStatementMapper.deleteLogicByIds(ids);
    }

    @Override
    public Integer updateByStatement(FlrStatement flrStatement) {
        return flrStatementMapper.updateByStatement(flrStatement);
    }

    @Override
    public Integer deleteById(String fid) {
        return flrStatementMapper.deleteById(fid);
    }

    @Override
    public Integer deleteByIds(List<String> ids) {
        return flrStatementMapper.deleteByIds(ids);
    }
}
