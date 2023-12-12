package com.solvd.laba.block1.task5_threads;

import java.util.concurrent.*;

// 2. Create Connection Pool.
// Use collection from java.util.concurrent package.
// Connection class may be mocked.
// The pool should be threadsafe and lazy initialized.
public class ConnectionPool {
    private static ConnectionPool instance;
    private final BlockingQueue<Connection> connections;
    private final int poolSize;
    private boolean initialized = false; //lazy initialized

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        this.connections = new LinkedBlockingQueue<>(poolSize);
    }

    public static ConnectionPool getInstance(int poolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class){
                instance = new ConnectionPool(poolSize);
            }
        }
        return instance;
    }

    private void initializeConnections() {
        for (int i = 0; i < poolSize; i++) {
            connections.offer(new Connection(i));
        }
        initialized = true;
    }

    public Connection getConnection() throws InterruptedException {
        if (!initialized) {
            initializeConnections();
        }
        return connections.take();
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.offer(connection);
        }
    }
}