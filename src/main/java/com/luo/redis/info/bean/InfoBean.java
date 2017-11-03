package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoBean -- 对应命令 info
 */
@Data
@NoArgsConstructor
public class InfoBean {
    private InfoServer server;
    private InfoClients clients;
    private InfoMemory memory;
    private InfoPersistence persistence;
    private InfoStats stats;
    private InfoReplication replication;
    private InfoCpu cpu;
    private InfoCluster cluster;
    private InfoKeyspace keyspace;
}
