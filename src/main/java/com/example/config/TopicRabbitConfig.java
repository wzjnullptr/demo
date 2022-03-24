package com.example.config;

import com.example.component.TopicReceiver;
import com.example.component.TopicSender;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//通配符模式
@Configuration
public class TopicRabbitConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicApplication");
    }

    @Bean
    public Queue topicQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue topicQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingQueue7() {
        return  BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.1.*");
    }

    @Bean
    public Binding bindingQueue5() {
        return  BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("*.2.*");
    }

    @Bean
    public Binding bindingQueue6() {
        return  BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("3.#");
    }

    @Bean
    public TopicSender topicSender() {
        return new TopicSender();
    }

    @Bean
    public TopicReceiver topicReceiver() {
        return new TopicReceiver();
    }
}
