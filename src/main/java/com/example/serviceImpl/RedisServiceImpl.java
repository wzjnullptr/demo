package com.example.serviceImpl;

import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemple;

    @Override
    public void set(String key, String value) {
        stringRedisTemple.opsForValue().set(key,value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemple.opsForValue().get(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemple.opsForValue().increment(key,delta);
    }

    @Override
    public void remove(String key) {
        stringRedisTemple.delete(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemple.expire(key,expire, TimeUnit.SECONDS);
    }
}
