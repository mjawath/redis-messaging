package com.scaleshop.poc.redis;

public interface MessagePublisher {

    void publish(final String message);
}