package org.example;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException {
        Database redis = new RedisImplementation();
        redis.connect();

        while (true) {
            try {
                System.out.println("Waiting to acquire lock on key1...");
                redis.acquireLock("key1");
                System.out.println("Acquired Lock");
                redis.put("key1", "value1");
                System.out.println(redis.get("key1"));
                redis.put("key2","value2");
                System.out.println(redis.get("key2"));
                redis.releaseLock("key1");
                System.out.println("Released Lock");
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}