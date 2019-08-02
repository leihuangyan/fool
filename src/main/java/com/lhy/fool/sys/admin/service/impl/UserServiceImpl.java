package com.lhy.fool.sys.admin.service.impl;

import com.lhy.fool.sys.admin.entity.User;
import com.lhy.fool.sys.admin.mapper.UserMapper;
import com.lhy.fool.sys.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhy
 * @since 2019-08-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
