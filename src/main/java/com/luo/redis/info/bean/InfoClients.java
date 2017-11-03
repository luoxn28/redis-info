package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoClients -- 对应命令 info clients
 */
@Data
@NoArgsConstructor
public class InfoClients {
    private String connected_clients;
    private String client_longest_output_list;
    private String client_biggest_input_buf;
    private String blocked_clients;
}
