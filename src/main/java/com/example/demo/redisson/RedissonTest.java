package com.example.demo.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonRxClient;

/**
 * Create 2021/12/10 by Gq
 */
public class RedissonTest {

    public static void main(String[] args) {
        RedissonClient redissonClient = Redisson.create();
        RLock lock = redissonClient.getFairLock("try_lock");
        lock.tryLock();

    }
}
