package com.lhy.fool;

import cn.hutool.extra.mail.MailUtil;
import com.lhy.fool.mq.rabbitmq.RabbitProducer;
import com.lhy.fool.security.core.entity.SysUserEntity;
import com.lhy.fool.security.core.entity.SysUserRoleEntity;
import com.lhy.fool.security.core.service.SysUserRoleService;
import com.lhy.fool.security.core.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @name: Application
 * @author： 98403
 * @classPath: com.lhy.Application
 * @date: 2019-07-30 18:33
 * @Version: 1.0
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional(transactionManager = "transactionManager")
@Slf4j
public class Application {


    @Resource
    private RabbitProducer producer;

    @Test
    public void rabbitmq(){
        producer.send();
    }


    public static void main(String[] args) {
        String user = "15897476550@163.com";
        String subject = "xxx";
        MailUtil.sendHtml(user,subject,subject);
    }




    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SysUserRoleService sysUserRoleService;


    /**
     * 注册用户
     */
    @Test
    public void contextLoads() {
        // 注册用户
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername("cj");
        sysUserEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
        // 设置用户状态
        sysUserEntity.setStatus("NORMAL");
        sysUserService.save(sysUserEntity);
        // 分配角色 1:ADMIN 2:USER
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setRoleId(2L);
        sysUserRoleEntity.setUserId(sysUserEntity.getUserId());
        sysUserRoleService.save(sysUserRoleEntity);
    }
}

