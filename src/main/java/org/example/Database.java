package org.example;

import java.util.concurrent.ExecutionException;

public interface Database {
    void connect();
    void put(String key,String value);
    String get(String key) throws ExecutionException, InterruptedException;
    void acquireLock(String Key);
    void releaseLock(String Key);
}
