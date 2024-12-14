package org.example;

import java.util.concurrent.ExecutionException;

public class PostgresImplementation implements Database{
    @Override
    public void connect() {

    }

    @Override
    public void put(String key, String value) {

    }

    @Override
    public String get(String key) throws ExecutionException, InterruptedException {
        return "";
    }

    @Override
    public void acquireLock(String Key) {

    }

    @Override
    public void releaseLock(String Key) {

    }
}
