package com.luo.redis.info.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置
 */
@Configuration
public class RedisConfig {

    @Autowired
    private JedisConnectionFactory jedisConnFactory;

//    @Autowired
//    private StringRedisSerializer stringRedisSerializer;

//    @Autowired
//    private JacksonJsonRedisSerializer jacksonJsonRedisSerializer;

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public Jackson2JsonRedisSerializer jacksonJsonRedisSerializer() {
        return new Jackson2JsonRedisSerializer(Object.class);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(jacksonJsonRedisSerializer());
        return redisTemplate;
    }

}
