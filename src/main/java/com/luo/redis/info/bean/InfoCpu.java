package com.luo.redis.info.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * InfoCpu -- 对应命令 info cpu
 */
@Data
@NoArgsConstructor
public class InfoCpu {
    private String used_cpu_sys;
    private String used_cpu_user;
    private String used_cpu_sys_children;
    private String used_cpu_user_children;
}
