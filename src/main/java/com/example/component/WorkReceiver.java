package com.example.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "WorkApplication")
public class WorkReceiver {

    private int instance;

    public WorkReceiver(int i) {
        this.instance = i;
    }

    @RabbitHandler
    public void receiver(String in) {
        System.out.println("第"+this.instance+"个消费者"+"获取"+in);
    }
}
