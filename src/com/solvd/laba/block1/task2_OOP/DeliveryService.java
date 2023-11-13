package com.solvd.laba.block1.task2_OOP;

import com.solvd.laba.block1.task2_OOP.exceptions.*;

import java.io.IOException;

public class DeliveryService {

    public static void printServiceWelcome() {
        System.out.println("Welcome to our delivery service!\n");
    }

    private static DeliveryOrder createNewOrder(){
        DeliveryOrder order = new DeliveryOrder();
        try {
            // Створення об'єктів і виклик конструкторів
            Item item1 = new Item("Laptop", 2.5);
            Customer sender = new Customer(new FullName("Julia", "Rak"), "+380980207334", "juliarak@gmail.com", new Adress("Kyiv", "Shevchenka", "8a"));
            Customer recipient = new Customer(new FullName("Olena", "Rak"), "+380676757226", "olenarak@gmail.com", new Adress("Kyiv", "Khreshchatyk", "5"));
            order = new DeliveryOrder(sender, recipient, item1, 7.0);
        } catch (SettingCourierException e) {
            System.err.println(e.getMessage());
        } catch (InvalidAddressException e) {
            System.err.println(e.getMessage());
        } catch (InvalidPhoneNumberException e) {
            System.err.println(e.getMessage());
        } catch (InvalidEmailException e) {
            System.err.println(e.getMessage());
        }
        return order;
    }

    public static void printInfo() {
        try {
            // Створення об'єктів і виклик конструкторів
            DeliveryOrder order = createNewOrder();

            // Визначення вартості доставки
            double cost = DeliveryCostCalculator.calculateDeliveryCost(order);

            // Виведення основної інформації
            System.out.printf(order.toString());
            System.out.println("Delivery cost: " + cost);
        } catch (DeliveryCostCalculationException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void printInfoInFile() {
        try (DeliveryOrderWriter orderWriter = new DeliveryOrderWriter("orders.txt")) {
            // Створення об'єктів і виклик конструкторів
            DeliveryOrder order = createNewOrder();

            // Визначення вартості доставки
            double cost = DeliveryCostCalculator.calculateDeliveryCost(order);

            // Запис основної інформації в файл
            orderWriter.write(order.toString());
            orderWriter.write("Delivery cost: " + cost);
        } catch (DeliveryCostCalculationException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
