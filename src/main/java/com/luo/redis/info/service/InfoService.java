package com.luo.redis.info.service;

import com.luo.redis.info.bean.*;

/**
 * InfoService
 */
public interface InfoService {

    InfoBean getInfoBean();

    InfoCpu getInfoCpu();

    InfoServer getInfoServer();

    InfoReplication getInfoReplication();

    InfoStats getInfoStats();

    InfoKeyspace getInfoKeyspace();

    InfoPersistence getInfoPersistence();

    InfoClients getInfoClients();

    InfoMemory getInfoMemory();

    InfoCluster getInfoCluster();

}
