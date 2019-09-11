package com.lhy.fool;

import cn.hutool.extra.mail.MailUtil;
import com.lhy.fool.mq.rabbitmq.RabbitProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
}
