package com.example.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {

    private void receiver(String in,int i) {
        System.out.println("第"+i+"个消费者获取路由消息"+in);
    }

    @RabbitListener(queues = "#{directQueue1.name}")
    public void receive1(String in){
        receiver(in,1);
    }

    @RabbitListener(queues = "#{directQueue2.name}")
    public void receive2(String in){
        receiver(in,2);
    }
}
