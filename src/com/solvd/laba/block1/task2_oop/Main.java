package com.solvd.laba.block1.task2_oop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final DeliveryService DELIVERY_SERVICE = new DeliveryService();

    public static void main(String[] args) {
        LOGGER.info("PROGRAM STARTED");
        DELIVERY_SERVICE.printInfo();
        DELIVERY_SERVICE.printInfoInFile();
        LOGGER.info("PROGRAM ENDED\n");
    }
}
