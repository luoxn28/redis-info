package com.test.redis.info;

import com.luo.redis.info.bean.InfoServer;
import com.luo.redis.info.service.InfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
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
        System.out.println(ops.get(key).getClass());
    }

    @Test
    public void testObjectList() {
        ValueOperations<String, List<Person>> ops = redisTemplate.opsForValue();

        String key = "personList";
        if (!redisTemplate.hasKey(key)) {
            List<Person> personList = new ArrayList<>();
            personList.add(new Person("luo", 25));

            ops.set(key, personList);
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));
    }

    @Test
    public void testObjectList2() {
        ListOperations<String, List<Person>> ops = redisTemplate.opsForList();

        String key = "personList2";
        if (!redisTemplate.hasKey(key)) {
            List<Person> personList = new ArrayList<>();
            personList.add(new Person("luo", 25));
            personList.add(new Person("bei", 24));

            ops.leftPush(key, personList);
        }

        System.out.println(ops.range(key, 0, -1));
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

    @Test
    public void testCallback2() {
        final Properties[] result = {null};

        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Properties properties = connection.info("keyspace");
                System.out.println(properties);

                Enumeration<String> nameList = (Enumeration<String>) properties.propertyNames();
                while (nameList.hasMoreElements()) {
                    System.out.println(nameList.nextElement());
                }

                result[0] = properties;
                return null;
            }
        });
    }

    @Test
    public void testCallback3() {
        final Properties[] result = {null};

        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Properties properties = connection.info();
                System.out.println(properties);

                Enumeration<String> nameList = (Enumeration<String>) properties.propertyNames();
                while (nameList.hasMoreElements()) {
                    System.out.println(nameList.nextElement());
                }

                result[0] = properties;
                return null;
            }
        });
    }

    @Autowired
    InfoService infoService;

    @Test
    public void testInfo() {
        System.out.println(infoService.getInfoBean());
    }

}
