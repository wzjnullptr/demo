package com.example.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkSender {

    private final String WORK_NAME = "WorkApplication";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String message = "start to workApplication";
        rabbitTemplate.convertAndSend(WORK_NAME,message);
    }
}
