package com.scaleshop.poc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Qualifier("rds2")
public class RedisMessagePublisher2 implements MessagePublisher {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisMessagePublisher2(final RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publish(final String message) {
        System.out.println("Message publised2222: " + message.toString());
        redisTemplate.convertAndSend("messageQueue2", message);
    }
}