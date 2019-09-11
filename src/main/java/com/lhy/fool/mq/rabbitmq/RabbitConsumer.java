package com.lhy.fool.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @name: RabbitConsumer 消费者
 * @author： LHY
 * @classPath: com.lhy.fool.mq.rabbitmq.RabbitConsumer
 * @date: 2019-08-20 22:34
 * @Version: 1.0
 * @description: 监听 名称为 LHY 的queue
 */
@Component
@RabbitListener(queues = "LHY")
@Slf4j
public class RabbitConsumer {


    /**
     * 消息处理器
     * @param message
     */
    @RabbitHandler
    public void process(String message){
        log.info("==========================>消费消息:{}<============",message);
    }

}
