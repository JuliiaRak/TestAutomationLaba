package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.*;
import java.io.IOException;
import com.solvd.laba.block1.task2_oop.interfaces.IDeliveryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeliveryService implements IDeliveryService {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);
    private final DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();

    public DeliveryService (){
        System.out.println("Welcome to our delivery service!\n");
        LOGGER.info("Welcome to our delivery service!");
    }

    private DeliveryOrder createNewOrder(){
        DeliveryOrder order = new DeliveryOrder();
        try {
            // Створення об'єктів і виклик конструкторів
            Item item1 = new Item("Laptop", 2.5);
            Customer sender = new Customer(new FullName("Julia", "Rak"), "+380980207334", "juliarak@gmail.com", new Adress("Kyiv", "Shevchenka", "8a"));
            Customer recipient = new Customer(new FullName("Marta", "Rak"), "+380676757226", "olenarak@gmail.com", new Adress("Kyiv", "Khreshchatyk", "5"));
            order = new DeliveryOrder(sender, recipient, item1, 7.0);
        } catch (SettingCourierException e) {
            System.err.println(e.getMessage());
            LOGGER.error(e.getMessage());
        } catch (InvalidAddressException e) {
            System.err.println(e.getMessage());
            LOGGER.error(e.getMessage());
        } catch (InvalidPhoneNumberException e) {
            System.err.println(e.getMessage());
            LOGGER.error(e.getMessage());
        } catch (InvalidEmailException e) {
            System.err.println(e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return order;
    }

    @Override
    public void printInfo() {
        LOGGER.info("Printing order info into console");
        try {
            // Створення об'єктів і виклик конструкторів
            DeliveryOrder order = createNewOrder();

            // Визначення вартості доставки
            double cost = deliveryCostCalculator.calculateDeliveryCost(order);

            // Виведення основної інформації
            System.out.printf(order.toString());
            System.out.println("Delivery cost: " + cost);
            LOGGER.info("Printing delivery order details");
            LOGGER.info("Delivery cost: " + cost);
        } catch (DeliveryCostCalculationException e) {
            System.err.println(e.getMessage());
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void printInfoInFile() {
        LOGGER.info("Printing order info into file");
        try (DeliveryOrderFileWriter orderWriter = new DeliveryOrderFileWriter("orders.txt")) {
            // Створення об'єктів і виклик конструкторів
            DeliveryOrder order = createNewOrder();

            // Визначення вартості доставки
            double cost = deliveryCostCalculator.calculateDeliveryCost(order);

            // Запис основної інформації в файл
            orderWriter.write(order.toString());
            orderWriter.write("Delivery cost: " + cost);
            LOGGER.info("Printing delivery order details");
            LOGGER.info("Delivery cost: " + cost);
        } catch (DeliveryCostCalculationException e) {
            System.err.println(e.getMessage());
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            LOGGER.error(e.getMessage());
        }
    }
}
