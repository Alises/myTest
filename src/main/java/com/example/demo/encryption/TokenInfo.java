package com.example.demo.encryption;

import lombok.Data;

/**
 * Create By Gq
 * 2022/5/24
 */
@Data
public class TokenInfo {
    private String token;
    private Integer id;
    private Integer val; // 附加值  暂时无值
    private long createTime;
    private boolean valid;
}
