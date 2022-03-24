package com.example.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收消息 消费者
 * @RabbitListener监听消息队列中的消息 如果有消息则接收 与rabbitHandler配合使用 当收到消息时 交给RabbitHandler处理
 */
@RabbitListener(queues = "simpleApplication")
@Component
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String in){
        System.out.println("简单模式接收到"+in);
    }
}
