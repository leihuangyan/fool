package com.lhy.fool.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @name: RabbitProducer 生产者
 * @author： LHY
 * @classPath: com.lhy.fool.mq.rabbitmq.RabbitProducer
 * @date: 2019-08-20 22:34
 * @Version: 1.0
 */
@Component
@Slf4j
public class RabbitProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(){
        String queueName = "LHY";
        //往名称为 LHY 的queue中发送消息
        log.info("==========================>给LHY Queue 发送了消息<==========================");
        this.amqpTemplate.convertAndSend(queueName,String.format("[消息] to LHY Queues，时间：%s",new Date().toLocaleString()));
    }
}
