package com.example.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息 生产者
 */
@Component
public class SimpleSender {

    private final String QUEUE_NAME = "simpleApplication";
    //rabbitTemplate 模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String message = "start to produce";
        //输出没有顺序 不需要等待 convertSendAndReceive只有确定消费者收到消息才会发送下一条消息 消息存在间隔时间
        this.rabbitTemplate.convertAndSend(QUEUE_NAME,message);
    }
}
