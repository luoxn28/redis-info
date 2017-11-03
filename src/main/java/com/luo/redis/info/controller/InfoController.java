package com.luo.redis.info.controller;

import com.luo.redis.info.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * InfoController
 */
@RequestMapping("/info")
@RestController
public class InfoController {

    @Autowired
    InfoService infoService;

    @GetMapping
    public Object infoBean() {
        return infoService.getInfoBean();
    }

    @GetMapping("/cpu")
    public Object infoCpu() {
        return infoService.getInfoCpu();
    }

    @GetMapping("/server")
    public Object infoServer() {
        return infoService.getInfoServer();
    }

    @GetMapping("/replication")
    public Object infoReplication() {
        return infoService.getInfoReplication();
    }

    @GetMapping("/stats")
    public Object infoStats() {
        return infoService.getInfoStats();
    }

    @GetMapping("/keyspace")
    public Object infoKeyspace() {
        return infoService.getInfoKeyspace();
    }

    @GetMapping("/persistence")
    public Object infoPersistence() {
        return infoService.getInfoPersistence();
    }

    @GetMapping("/clients")
    public Object infoClients() {
        return infoService.getInfoClients();
    }

    @GetMapping("/memory")
    public Object infoMemory() {
        return infoService.getInfoMemory();
    }

    @GetMapping("/cluster")
    public Object infoCluster() {
        return infoService.getInfoCluster();
    }

}
