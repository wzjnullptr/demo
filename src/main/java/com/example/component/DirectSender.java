package com.example.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {
    private final String DIRECT_EXCHANGE = "DirectApplication";
    private final String[] keys = {"1","2","3"};

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i){
        int limit = i%3;
        String message = keys[limit];
        this.rabbitTemplate.convertAndSend(DIRECT_EXCHANGE,keys[limit],message);
    }
}
