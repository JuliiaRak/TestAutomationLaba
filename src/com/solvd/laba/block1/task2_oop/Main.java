package com.solvd.laba.block1.task2_oop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("PROGRAM STARTED");
        DeliveryService.printInfo();
        DeliveryService.printInfoInFile();
        logger.info("PROGRAM ENDED\n");
    }
}
