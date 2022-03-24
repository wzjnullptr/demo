package com.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 简单模式的rabbitmq配置 amqp 消息队列
 */
@Configuration
public class SimpleRabbitConfig {

    //创建一个名称为simpleApplication的消息队列
    @Bean
    public Queue queue() {
        return new Queue("simpleApplication");
    }
}
