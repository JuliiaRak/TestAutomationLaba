package com.solvd.laba.block1.task2_OOP;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів і виклик конструкторів
        DeliveryCostCalculator deliveryCalculator = new DeliveryCostCalculator();
        Item item1 = new Item("Laptop", 2.5);
        Customer sender = new Customer(new FullName("Julia", "Rak"), "0980207334", "juliarak@gmail.com", new Adress("Kyiv", "Shevchenka", "8a"));
        Customer recipient = new Customer(new FullName("Olena", "Rak"), "0676757226", "olenarak@gmail.com", new Adress("Kyiv", "Khreshchatyk", "5"));
        DeliveryOrder order1 = new DeliveryOrder(sender, recipient, item1,
                new Courier(new FullName("Alex", "Emets"),  "0980562546", "alexemets@gmail.com", new Vehicle(VehicleType.MOTORCYCLE)),
                500.0, DeliveryStatus.DELIVERED);

        // Визначення вартості доставки
        double cost = deliveryCalculator.calculateDeliveryCost(order1);

        // Виведення основної інформації
        System.out.println("Delivery cost: $" + cost);
    }
}
