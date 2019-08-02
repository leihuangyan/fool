package com.lhy.fool.sys.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.lhy.fool.sys.admin.entity.User;
import com.lhy.fool.sys.admin.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhy
 * @since 2019-08-02
 */
@RestController
@RequestMapping("/sys/admin/user")
@Api("User模块")
public class UserController extends ApiController {

    @Autowired
    private IUserService userService;


    @ApiOperation(value = "登陆",notes = "登陆")
    @PostMapping(value = "/login")
    public R<User> login(@ApiParam(value="用户名",required=true) @RequestParam String name,
                         @ApiParam(value="密码",required=true) @RequestParam String pwd){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().eq(User::getName,name).eq(User::getPwd,pwd);
        final User one = userService.getOne(qw);
        if(null != one){
            return R.ok(one);
        }
        return R.failed("该用户不存在");
    }

    
}

