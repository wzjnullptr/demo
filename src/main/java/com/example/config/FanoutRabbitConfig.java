package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布订阅模式  通过交换机将消息绑定到队列上
 */
@Configuration
public class FanoutRabbitConfig {

    //定义一个交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutApplication");
    }

    //匿名队列 一旦断开和mq的连接  队列将会自动删除
    @Bean
    public Queue fanoutQueue1() {
        return new AnonymousQueue();
    }

    //匿名队列
    @Bean
    public Queue fanoutQueue2() {
        return new AnonymousQueue();
    }

    //定义交换机与匿名队列的绑定关系
    @Bean
    public Binding fanoutBinging1(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinging2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
}
