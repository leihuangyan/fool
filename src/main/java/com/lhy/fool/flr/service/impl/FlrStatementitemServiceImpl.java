package com.lhy.fool.flr.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.fool.flr.entity.FlrStatementitem;
import com.lhy.fool.flr.mapper.FlrStatementitemMapper;
import com.lhy.fool.flr.service.IFlrStatementitemService;
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
public class FlrStatementitemServiceImpl extends ServiceImpl<FlrStatementitemMapper, FlrStatementitem> implements IFlrStatementitemService {

    @Autowired
    private FlrStatementitemMapper flrStatementitemMapper;

    @Override
    public List<FlrStatementitem> listByCondition(IPage<FlrStatementitem> page, FlrStatementitem flrStatementitem) {
        return flrStatementitemMapper.listByCondition(page,flrStatementitem);
    }

    @Override
    public List<FlrStatementitem> listAll(FlrStatementitem flrStatementitem) {
        return flrStatementitemMapper.listAll(flrStatementitem);
    }

    @Override
    public FlrStatementitem selectById(String fid) {
        return flrStatementitemMapper.selectById(fid);
    }

    @Override
    public Integer insertOne(FlrStatementitem flrStatementitem) {
        return flrStatementitemMapper.insertOne(flrStatementitem);
    }

    @Override
    public Integer insertArray(List<FlrStatementitem> list) {
        return flrStatementitemMapper.insertArray(list);
    }

    @Override
    public Integer updateRemarks(FlrStatementitem flrStatementitem) {
        return flrStatementitemMapper.updateRemarks(flrStatementitem);
    }

    @Override
    public Integer deleteById(String fig) {
        return flrStatementitemMapper.deleteById(fig);
    }

    @Override
    public Integer deleteByIds(List<String> ids) {
        return flrStatementitemMapper.deleteByIds(ids);
    }

    @Override
    public Integer deleteLogicById(String fid) {
        return flrStatementitemMapper.deleteLogicById(fid);
    }

    @Override
    public Integer deleteLogicByIds(List<String> ids) {
        return flrStatementitemMapper.deleteLogicByIds(ids);
    }
}
