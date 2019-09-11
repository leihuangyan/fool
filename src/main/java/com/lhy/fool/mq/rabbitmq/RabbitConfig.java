package com.lhy.fool.mq.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;
/**
 * @name: RabbitMQ 配置类
 * @author： LHY
 * @classPath: com.lhy.fool.mq.rabbitmq.RabbitConfig
 * @date: 2019-08-20 22:32
 * @Version: 1.0
 * @description: TODO
 */
@Configuration
public class RabbitConfig {

    /**
     * @return 创建名字为 LHY 的队列
     */
    @Bean
    public Queue queue(){
        String queueName = "LHY";
        return new Queue(queueName);
    }

}
