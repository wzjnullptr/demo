package com.example.controller;

import com.example.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redisTest")
public class RedisTestController {
    @Autowired
    private RedisTestService redisTestService;

    @GetMapping("/set")
    public void setRedis() {
        redisTestService.setRedis();
    }

    @GetMapping("/get")
    public void getRedis() {
        try {
            for (int i = 0; i < 5; i++) {
                redisTestService.getRedis();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
