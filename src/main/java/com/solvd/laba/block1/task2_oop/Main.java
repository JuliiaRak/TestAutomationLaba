package com.solvd.laba.block1.task2_oop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final DeliveryService DELIVERY_SERVICE = new DeliveryService();

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static void main(String[] args) {
        LOGGER.info("PROGRAM STARTED");
        DELIVERY_SERVICE.printInfo();
        DELIVERY_SERVICE.printInfoInFile();
        LOGGER.info("PROGRAM ENDED\n");



    }

    public int calculateQuantityForBudget(String product, double budget){
        Map<Double, String> menu = new HashMap<>();
        menu.put(10.0, "Кава");
        menu.put(20.0, "Чай");
        menu.put(30.0, "Печиво");

        int quantity = 0;

        for (Map.Entry<Double, String> entry : menu.entrySet()) {
            Double price = entry.getKey();
            String productName = entry.getValue();

            if (productName.equals(product)) {
                int affordableQuantity = (int) (budget / price);

                if (affordableQuantity > 0) {
                    System.out.println("За " + budget + "$ ви можете купити " + affordableQuantity + " порцій " + product);
                    quantity += affordableQuantity;

                    budget -= affordableQuantity * price;
                }
            }
        }

        return quantity;
    }
}
