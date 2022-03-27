package com.example.serviceImpl;

import com.example.service.RedisService;
import com.example.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisTestServiceImpl implements RedisTestService {

    @Autowired
    private RedisService redisService;

    @Override
    public void setRedis() {
        String key = "key2";
        String value = "value2";
        Long expire = 5L;
        redisService.set(key,value);
        redisService.expire(key,expire);
    }

    @Override
    public void getRedis() {
        String key = "key2";
        String value = redisService.get(key);
        System.out.println(value);
    }
}
