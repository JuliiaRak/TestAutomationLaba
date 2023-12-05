package com.solvd.laba.block1.task2_oop;

import com.solvd.laba.block1.task2_oop.exceptions.ObjectNotFoundExeption;
import com.solvd.laba.block1.task2_oop.exceptions.SettingCourierException;
import com.solvd.laba.block1.task2_oop.interfaces.OrderProcessor;
import com.solvd.laba.block1.task2_oop.interfaces.Printer;
import com.solvd.laba.block1.task2_oop.repos.CustomersRepo;
import com.solvd.laba.block1.task2_oop.repos.ItemsRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DeliveryService {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);
    private CustomersRepo customerRepo = new CustomersRepo();
    private ItemsRepo itemsRepo = new ItemsRepo();

    public DeliveryService (){
        System.out.println("Welcome to our delivery service!\n");
        LOGGER.info("Welcome to our delivery service!");
    }

    public DeliveryOrder createNewOrder(){
        DeliveryOrder order = new DeliveryOrder();
        try {
            Customer sender = customerRepo.getCustomers().get(0);
            Customer recipient = customerRepo.getCustomers().get(1);
            Item item1 = itemsRepo.getItems().get(0);
            Item item2 = itemsRepo.getItems().get(1);
            // Створення замовлення
            order = new DeliveryOrder(sender, sender.getAddresses().get(0),
                    recipient, recipient.getAddresses().get(0),
                    15.0);
            order.addItem(item1);
            order.addItem(item2);
        } catch (SettingCourierException e){
            LOGGER.error(e.getMessage());
            System.out.println("Sorry, there is no courier found that can carry your order with weight "
                    + order.getOrderWeight());
        }
        return order;
    }

    public void printInfo(Printer printer) {
        LOGGER.info("Printing order");
        try (DeliveryOrderFileWriter orderWriter = new DeliveryOrderFileWriter("orders.txt")) {
            // Створення об'єктів і виклик конструкторів
            DeliveryOrder order = createNewOrder();

            // Визначення вартості доставки
            double cost = DeliveryCostCalculator.calculateDeliveryCost(order);

            // Запис основної інформації в файл
            printer.printInfo();

            LOGGER.info("Printing delivery order details");
            LOGGER.info("Delivery cost: " + cost);
        } catch (ObjectNotFoundExeption e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error("Error reading and writing to file in DeliveryService class" + e.getMessage());
        }
    }

    public void processCustomOrder(DeliveryOrder order, OrderProcessor customOrderProcessor) {
        if (customOrderProcessor != null) {
            customOrderProcessor.processOrder(order, "change address", "JuliaRak");
        }
    }

}
