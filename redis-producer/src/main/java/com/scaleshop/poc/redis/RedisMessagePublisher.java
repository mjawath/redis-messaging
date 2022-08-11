package com.scaleshop.poc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RedisMessagePublisher implements MessagePublisher {

    @Autowired
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisMessagePublisher(final RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publish(final String message) {
        System.out.println("Message publised: " + message.toString());
        redisTemplate.convertAndSend("messageQueue", message);
    }
}