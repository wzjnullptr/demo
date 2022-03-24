package com.example.config;

import com.example.component.WorkReceiver;
import com.example.component.WorkSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq 工作模式配置
 */
@Configuration
public class WorkRabbitConfig {

    @Bean
    public Queue workApplication() {
        return new Queue("WorkApplication");
    }

    //创建第一个消费者
    @Bean
    public WorkReceiver workOneReceiver(){
        return new WorkReceiver(1);
    }

    //创建第二个消费者
    @Bean
    public WorkReceiver workTwoReceiver() {
        return new WorkReceiver(2);
    }

    //创建生产者
    @Bean
    public WorkSender workRabbitSender(){
        return new WorkSender();
    }

}
