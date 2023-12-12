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





    public static void main(String[] args) {

        // 3. Initialize pool with 5 sizes.
        // Load Connection Pool using threads and Thread Pool(7 threads).
        // 5 threads should be able to get the connection.
        // 2 Threads should wait for the next available connection.
        // The program should wait as well.
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);
        ExecutorService executorService = Executors.newFixedThreadPool(7);

        // 4. Implement 4th part but with IFuture and CompletableStage.
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Connection connection = connectionPool.getConnection();
                    System.out.println(Thread.currentThread().getName() + " t" + (i + 1) + " got connection: " + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    System.out.println(Thread.currentThread().getName() + " t" + (i + 1) + " release connection: " + connection);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    Connection connection = connectionPool.getConnection();
                    System.out.println(Thread.currentThread().getName() + " T" + (i + 1) + " got connection: " + connection);
                    Thread.sleep(3000);
                    connectionPool.releaseConnection(connection);
                    System.out.println(Thread.currentThread().getName() + " T" + (i + 1) + " release connection: " + connection);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);

        CompletableFuture.allOf(future1, future2).join();

        executorService.shutdown();
    }
}