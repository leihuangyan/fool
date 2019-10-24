package com.lhy.fool.security.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhy.fool.security.core.dao.SysMenuDao;
import com.lhy.fool.security.core.entity.SysMenuEntity;
import com.lhy.fool.security.core.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * @Description 权限业务实现
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

}