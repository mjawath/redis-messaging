package com.scaleshopx.redis.test;

import com.scaleshop.poc.redis.RedisConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
@PropertySource("application.properties")
public class RedisConfigClass extends RedisConfig {

    @Bean
//    @Override
    protected MessageListener getListener() {
        return new RedisMessageSubscriber();
    }

    protected MessageListener getListener2() {
        return new RedisMessageSubscriber2();
    }
    @Bean
    @Override
    protected Map<ChannelTopic,MessageListener> topics() {
        Map<ChannelTopic,MessageListener> topicMessageListenerMap= new HashMap<>();
        topicMessageListenerMap.put(new ChannelTopic("messageQueue"),getListener());
        topicMessageListenerMap.put(new ChannelTopic("messageQueue2"),getListener2());
        return topicMessageListenerMap;
    }

}
