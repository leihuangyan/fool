package com.lhy.fool.sys.dict.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.lhy.fool.sys.dict.entity.Dict;
import com.lhy.fool.sys.dict.service.IDictService;
import com.lhy.fool.util.enums.DictEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhy
 * @since 2019-08-02
 */
@RestController
@RequestMapping("/api/dict")
@Api("菜单")
public class DictController extends ApiController {


    private QueryWrapper<Dict> queryWrapper;

    private UpdateWrapper<Dict> updateWrapper;

    @Autowired
    private IDictService dictService;

    @ModelAttribute
    public void init(){
        logger.info("初始化：{}",this.getClass());
        queryWrapper = new QueryWrapper<>();
        updateWrapper = new UpdateWrapper<>();
    }



    @GetMapping("/list")
    @ApiOperation("得到一级菜单")
    public R getMenu(){
        queryWrapper.lambda().eq(Dict::getLevel, DictEnum.LEVEL_SELECT.getCode());
        final List<Dict> list = dictService.list(queryWrapper);
        return R.ok(list);
    }

    @GetMapping("/item")
    @ApiOperation("得到一个菜单下面的子菜单")
    public R getItem(@ApiParam(value = "父ID",required = true)@RequestParam Integer pid){
        queryWrapper.lambda()
                .eq(Dict::getLevel, DictEnum.LEVEL_ITEM.getCode())
                .eq(Dict::getParentId,pid);
        final List<Dict> list = dictService.list(queryWrapper);
        return R.ok(list);
    }
}

