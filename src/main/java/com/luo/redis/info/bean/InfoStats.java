package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoStats -- 对应命令 info stats
 */
@Data
@NoArgsConstructor
public class InfoStats {
    private String total_connections_received;
    private String total_commands_processed;
    private String instantaneous_ops_per_sec;
    private String total_net_input_bytes;
    private String total_net_output_bytes;
    private String instantaneous_input_kbps;
    private String instantaneous_output_kbps;
    private String rejected_connections;
    private String sync_full;
    private String sync_partial_ok;
    private String sync_partial_err;
    private String expired_keys;
    private String evicted_keys;
    private String keyspace_hits;
    private String keyspace_misses;
    private String pubsub_channels;
    private String pubsub_patterns;
    private String latest_fork_usec;
    private String migrate_cached_sockets;
}
