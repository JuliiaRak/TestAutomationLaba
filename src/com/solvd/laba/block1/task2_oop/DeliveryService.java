package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.*;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeliveryService {

    private static final Logger logger = LogManager.getLogger(DeliveryService.class);

    static {
        System.out.println("Welcome to our delivery service!\n");
        logger.info("Welcome to our delivery service!\n");
    }

    private static DeliveryOrder createNewOrder(){
        DeliveryOrder order = new DeliveryOrder();
        try {
            // Створення об'єктів і виклик конструкторів
            Item item1 = new Item("Laptop", 2.5);
            Customer sender = new Customer(new FullName("Julia", "Rak"), "+380980207334", "juliarak@gmail.com", new Adress("Kyiv", "Shevchenka", "8a"));
            Customer recipient = new Customer(new FullName("Marta", "Rak"), "+380676757226", "olenarak@gmail.com", new Adress("Kyiv", "Khreshchatyk", "5"));
            order = new DeliveryOrder(sender, recipient, item1, 7.0);
        } catch (SettingCourierException e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        } catch (InvalidAddressException e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        } catch (InvalidPhoneNumberException e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        } catch (InvalidEmailException e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        }
        return order;
    }

    public static void printInfo() {
        logger.info("Printing order info into console");
        try {
            // Створення об'єктів і виклик конструкторів
            DeliveryOrder order = createNewOrder();

            // Визначення вартості доставки
            double cost = DeliveryCostCalculator.calculateDeliveryCost(order);

            // Виведення основної інформації
            System.out.printf(order.toString());
            System.out.println("Delivery cost: " + cost);
            logger.info("Printing delivery order details");
            logger.info("Delivery cost: " + cost);
        } catch (DeliveryCostCalculationException e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        }
    }

    public static void printInfoInFile() {
        logger.info("Printing order info into file");
        try (DeliveryOrderWriter orderWriter = new DeliveryOrderWriter("orders.txt")) {
            // Створення об'єктів і виклик конструкторів
            DeliveryOrder order = createNewOrder();

            // Визначення вартості доставки
            double cost = DeliveryCostCalculator.calculateDeliveryCost(order);

            // Запис основної інформації в файл
            orderWriter.write(order.toString());
            orderWriter.write("Delivery cost: " + cost);
            logger.info("Printing delivery order details");
            logger.info("Delivery cost: " + cost);
        } catch (DeliveryCostCalculationException e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        }
    }
}
