package com.scaleshop.poc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {

    @Autowired
    private MessagePublisher publisher;
    @Autowired
    @Qualifier("rds2")
    private MessagePublisher publisher2;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            publisher.publish("test" + LocalDateTime.now());
            publisher2.publish("test2222222222222" + LocalDateTime.now());
        }
    }
}
