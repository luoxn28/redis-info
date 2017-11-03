package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoClients -- 对应命令 info clients
 */
@Data
@NoArgsConstructor
public class InfoCluster {
    private String cluster_enabled;
}
