package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoKeyspace -- 对应命令 info keyspace
 */
@Data
@NoArgsConstructor
public class InfoPersistence {
    private String loading;
    private String rdb_changes_since_last_save;
    private String rdb_bgsave_in_progress;
    private String rdb_last_save_time;
    private String rdb_last_bgsave_status;
    private String rdb_last_bgsave_time_sec;
    private String rdb_current_bgsave_time_sec;
    private String aof_enabled;
    private String aof_rewrite_in_progress;
    private String aof_rewrite_scheduled;
    private String aof_last_rewrite_time_sec;
    private String aof_current_rewrite_time_sec;
    private String aof_last_bgrewrite_status;
    private String aof_last_write_status;
}
