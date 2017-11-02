package com.test.redis.info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {com.luo.redis.info.Application.class})
public class TestRedis {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
        ValueOperations<String, String> ops = template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!template.hasKey(key)) {
            ops.set(key, "foo");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));
    }

    @Test
    public void testObject() {
        ValueOperations<String, Person> ops = redisTemplate.opsForValue();
        String key = "person";
        if (!redisTemplate.hasKey(key)) {
            ops.set(key, new Person("luo", 25));
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));

        System.out.println(redisTemplate.opsForValue().get("info"));
    }

    @Test
    public void testCallback() {

        final Properties[] result = {null};

        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Properties properties = connection.info();
                System.out.println(properties);

                properties = connection.info("CPU");
                System.out.println(properties);

                result[0] = properties;

                return null;
            }
        });

        System.out.println(result[0]);
    }

}
