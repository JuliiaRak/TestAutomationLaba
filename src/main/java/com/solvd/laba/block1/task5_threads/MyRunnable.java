package com.solvd.laba.block1.task5_threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyRunnable implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(MyRunnable.class);

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            LOGGER.info(Thread.currentThread().getName() + ": " + i);
        }
    }
}