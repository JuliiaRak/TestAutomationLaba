package com.solvd.laba.block1.task2;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів і виклик конструкторів
        DeliveryCostCalculator deliveryCalculator = new DeliveryCostCalculator();
        Item item1 = new Item("Laptop", 2.5);
        Customer sender = new Customer(new FullName("Julia", "Rak"), new Adress("Kyiv", "Shevchenka", "8a"));
        Customer recipient = new Customer(new FullName("Olena", "Rak"), new Adress("Kyiv", "Khreshchatyk", "5"));
        DeliveryOrder order1 = new DeliveryOrder(sender, recipient, item1, new Courier("Alex", new Vehicle(VehicleType.MOTORCYCLE)), 500.0);

        // Визначення вартості доставки
        double cost = deliveryCalculator.calculateDeliveryCost(order1);
        System.out.println("Delivery cost: $" + cost);
    }
}
