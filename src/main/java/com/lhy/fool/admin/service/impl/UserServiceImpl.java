package com.lhy.fool.admin.service.impl;

import com.lhy.fool.admin.entity.User;
import com.lhy.fool.admin.mapper.UserMapper;
import com.lhy.fool.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhy
 * @since 2019-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
