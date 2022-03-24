package com.example.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    private final String EXTER_CHANGE = "fanoutApplication";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String message = "Start to fanoutApplication";
        this.rabbitTemplate.convertAndSend(EXTER_CHANGE,"",message);
    }
}
