package com.solvd.laba.block1.task2_oop;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) {
        DeliveryService.printInfo();
        DeliveryService.printInfoInFile();
    }
}
