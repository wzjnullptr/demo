package com.example.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicSender {
    private final String TOPIC_NAME = "topicApplication";

    private final String[] keys = {"1.1.1","2.2.2","3.4.5"};

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i) {
        int limit = i%3;
        String message = keys[limit];
        this.rabbitTemplate.convertAndSend(TOPIC_NAME,keys[limit],message);
    }
}
