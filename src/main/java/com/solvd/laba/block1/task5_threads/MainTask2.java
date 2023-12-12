package com.solvd.laba.block1.task5_threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTask2 {

    private static final Logger LOGGER = LogManager.getLogger(MainTask2.class);

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
                    LOGGER.info(Thread.currentThread().getName() + " t" + (i + 1) + " got connection: " + connection);
                    Thread.sleep(1000);
                    connectionPool.releaseConnection(connection);
                    LOGGER.info(Thread.currentThread().getName() + " t" + (i + 1) + " release connection: " + connection);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    Connection connection = connectionPool.getConnection();
                    LOGGER.info(Thread.currentThread().getName() + " T" + (i + 1) + " got connection: " + connection);
                    Thread.sleep(3000);
                    connectionPool.releaseConnection(connection);
                    LOGGER.info(Thread.currentThread().getName() + " T" + (i + 1) + " release connection: " + connection);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);

        CompletableFuture.allOf(future1, future2).join();

        executorService.shutdown();
    }
}
