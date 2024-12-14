package org.example;


import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutionException;

public class RedisImplementation implements Database{

    StatefulRedisConnection<String, String> connection;
    RedissonClient redisson;

    @Override
    public void connect() {

        connection = RedisClient.create(
                RedisURI.Builder
                        .redis("localhost", 6379)
                        .build()
        ).connect();

        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        redisson = Redisson.create(config);
    }

    @Override
    public void put(String key, String value) {
        connection.async().set(key, value);
    }

    @Override
    public String get(String key) throws ExecutionException, InterruptedException {
        return connection.async().get(key).get();
    }

    @Override
    public void acquireLock(String Key) {
        RLock rLock = redisson.getLock("lock:"+Key);
        rLock.lock();
    }

    @Override
    public void releaseLock(String Key) {
        RLock rLock = redisson.getLock("lock:"+Key);
        rLock.unlock();
    }
}

