package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoServer -- 对应命令 info serve
 */
@Data
@NoArgsConstructor
public class InfoServer {
    private String redis_version;
    private String redis_git_sha1;
    private String redis_git_dirty;
    private String redis_build_id;
    private String redis_mode;
    private String os;
    private String arch_bits;
    private String multiplexing_api;
    private String gcc_version;
    private String process_id;
    private String run_id;
    private String tcp_port;
    private String uptime_in_seconds;
    private String uptime_in_days;
    private String hz;
    private String lru_clock;
    private String executable;
    private String config_file;
}
