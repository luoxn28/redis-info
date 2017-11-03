package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoMemory -- 对应命令 info memory
 */
@Data
@NoArgsConstructor
public class InfoMemory {
    private String used_memory;
    private String used_memory_human;
    private String used_memory_rss;
    private String used_memory_rss_human;
    private String used_memory_peak;
    private String used_memory_peak_human;
    private String total_system_memory;
    private String total_system_memory_human;
    private String used_memory_lua;
    private String used_memory_lua_human;
    private String maxmemory;
    private String maxmemory_human;
    private String maxmemory_policy;
    private String mem_fragmentation_ratio;
    private String mem_allocator;
}
