package com.example.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutRecever {

    @RabbitListener(queues = "#{fanoutQueue1.name}")
    public void recever1(String in) {
        recever(in,1);
    }

    @RabbitListener(queues = "#{fanoutQueue2.name}")
    public void recever2(String in) {
        recever(in,2);
    }

    private void recever(String in,int i) {
        System.out.println("第"+i+"个消费者"+"发布订阅模式获取" + in);
    }
}
