package com.example.controller;

import com.example.component.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rabbit")
@Controller
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;
    @Autowired
    private WorkSender workRabbitSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private DirectSender directSender;
    @Autowired
    private TopicSender topicSender;

    //rabbitmq简单模式
    @RequestMapping("/simple")
    public void simpleRabbit() {
        //每隔一秒发送一次
        try{
            for(int i = 0;i<10;i++) {
                simpleSender.send();
                Thread.sleep(1000);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 工作模式
     * 消费者获取消息处理耗时任务时，空闲的消费者从队列中获取并消费消息
     */
    @RequestMapping("/work")
    public void workRabbit() {
        try{
            for(int i = 0;i<10;i++) {
                workRabbitSender.send();
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 发布订阅模式
     */
    @RequestMapping("/publish")
    public void publishRabbit() {
        try{
            for(int i = 0;i<10;i++) {
                fanoutSender.send();
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //路由模式
    @RequestMapping("/direct")
    public void directRabbit() {
        try{
            for(int i = 0;i<10;i++) {
                directSender.send(i);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //通配符模式
    @RequestMapping("/topic")
    public void topicRabbit() {
        try{
            for(int i = 0;i<10;i++) {
                topicSender.send(i);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
