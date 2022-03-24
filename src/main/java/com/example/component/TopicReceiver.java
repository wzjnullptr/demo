package com.example.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class TopicReceiver {

    private void receiver(String in,int i) {
        System.out.println("第"+i+"个消费者获取路由消息"+in);
    }

    @RabbitListener(queues = "#{topicQueue1.name}")
    public void receive1(String in){
        receiver(in,1);
    }

    @RabbitListener(queues = "#{topicQueue2.name}")
    public void receive2(String in){
        receiver(in,2);
    }
}
