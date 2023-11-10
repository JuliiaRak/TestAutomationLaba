package com.solvd.laba.block1.task2_OOP;

public class DeliveryService {

    public static void printServiceWelcome() {
        System.out.println("Welcome to our delivery service!\n");
    }

    public static void printInfo() {
        // Створення об'єктів і виклик конструкторів
        Item item1 = new Item("Laptop", 2.5);
        Customer sender = new Customer(new FullName("Julia", "Rak"), "0980207334", "juliarak@gmail.com", new Adress("Kyiv", "Shevchenka", "8a"));
        Customer recipient = new Customer(new FullName("Olena", "Rak"), "0676757226", "olenarak@gmail.com", new Adress("Kyiv", "Khreshchatyk", "5"));
        DeliveryOrder order1 = new DeliveryOrder(sender, recipient, item1, 7.0);

        // Визначення вартості доставки
        DeliveryCostCalculator deliveryCalculator = new DeliveryCostCalculator();
        double cost = deliveryCalculator.calculateDeliveryCost(order1);

        // Виведення основної інформації
        System.out.println("Your delivery order details:");
        System.out.printf("%-20s: %s%n", "Sender", sender.getFullName());
        System.out.printf("%-20s: %s%n", "Recipient", recipient.getFullName());
        System.out.printf("%-20s: %s%n", "Item", item1.getName());
        System.out.printf("%-20s: %.2f kilometers%n", "Distance", order1.getDistance());
        System.out.printf("%-20s: %.2f UAH%n", "Delivery cost", cost);
    }
}
