package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoReplication -- 对应命令 info replication
 * Redis的复制信息
 */
@Data
@NoArgsConstructor
public class InfoReplication {
    private String role;
    private String connected_slaves;
    private String master_repl_offset;
    private String repl_backlog_active;
    private String repl_backlog_size;
    private String repl_backlog_first_byte_offset;
    private String repl_backlog_histlen;
}
