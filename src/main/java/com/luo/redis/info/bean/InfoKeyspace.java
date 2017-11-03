package com.luo.redis.info.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * InfoKeyspace -- 对应命令 info keyspace
 */
@Data
public class InfoKeyspace {
    private List<String> dbList;

    public InfoKeyspace() {
        this.dbList = new ArrayList<>();
    }
}
