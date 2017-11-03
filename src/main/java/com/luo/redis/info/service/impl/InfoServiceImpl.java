package com.luo.redis.info.service.impl;

import com.luo.redis.info.bean.*;
import com.luo.redis.info.component.BeanConvert;
import com.luo.redis.info.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * InfoServiceImpl
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BeanConvert beanConvert;

    @Override
    public InfoBean getInfoBean() {
        return (InfoBean) redisTemplate.execute((RedisCallback) connection -> beanConvert.toInfoBean(connection.info(), new InfoBean()));
    }

    @Override
    public InfoCpu getInfoCpu() {
        return (InfoCpu) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Cpu"), new InfoCpu()));
    }

    @Override
    public InfoServer getInfoServer() {
        return (InfoServer) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Server"), new InfoServer()));
    }

    @Override
    public InfoReplication getInfoReplication() {
        return (InfoReplication) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Replication"), new InfoReplication()));
    }

    @Override
    public InfoStats getInfoStats() {
        return (InfoStats) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Stats"), new InfoStats()));
    }

    @Override
    public InfoKeyspace getInfoKeyspace() {
        return (InfoKeyspace) redisTemplate.execute((RedisCallback) connection -> beanConvert.toInfoKeyspace(connection.info("Keyspace"), new InfoKeyspace()));
    }

    @Override
    public InfoPersistence getInfoPersistence() {
        return (InfoPersistence) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Persistence"), new InfoPersistence()));
    }

    @Override
    public InfoClients getInfoClients() {
        return (InfoClients) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Clients"), new InfoClients()));
    }

    @Override
    public InfoMemory getInfoMemory() {
        return (InfoMemory) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Memory"), new InfoMemory()));
    }

    @Override
    public InfoCluster getInfoCluster() {
        return (InfoCluster) redisTemplate.execute((RedisCallback) connection -> beanConvert.toBean(connection.info("Cluster"), new InfoCluster()));
    }

}
