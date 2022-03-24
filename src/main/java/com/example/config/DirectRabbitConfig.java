package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("DirectApplication");
    }

    @Bean
    public Queue directQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue directQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingQueue1() {
        return  BindingBuilder.bind(directQueue1()).to(directExchange()).with("1");
    }

    @Bean
    public Binding bindingQueue2() {
        return  BindingBuilder.bind(directQueue2()).to(directExchange()).with("2");
    }

    @Bean
    public Binding bindingQueue3() {
        return  BindingBuilder.bind(directQueue1()).to(directExchange()).with("3");
    }

    @Bean
    public Binding bindingQueue4() {
        return  BindingBuilder.bind(directQueue2()).to(directExchange()).with("3");
    }



}
